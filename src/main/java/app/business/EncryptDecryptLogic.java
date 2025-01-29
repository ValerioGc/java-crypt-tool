package app.business;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.exceptions.EncryptionInitializationException;
import org.jasypt.exceptions.EncryptionOperationNotPossibleException;

import app.config.AppConfig;

/**
 * Classe che gestisce le operazioni di crittografia e decrittografia delle password.
 * Utilizza Jasypt per la crittografia e Bouncy Castle come provider.
 */
public class EncryptDecryptLogic {

    /**
     * Esegue la crittografia di una password utilizzando il salting e l'algoritmo specificato.
     *
     * @param salt      La password di salting.
     * @param plainText La password da crittografare.
     * @param algorithm L'algoritmo da utilizzare.
     * @return La password crittografata.
     */
	public static String encrypt(String salt, String plainText, String algorithmName) {
	    String algorithmValue = AppConfig.ALGORITHMS.get(algorithmName);
	    if (algorithmValue == null) {
	        throw new IllegalArgumentException("Algoritmo non supportato: " + algorithmName);
	    }
	    StandardPBEStringEncryptor encryptor = createEncryptor(salt, algorithmValue);
	    return encryptor.encrypt(plainText);
	}


    /**
     * Esegue la decrittografia di una password utilizzando il salting e l'algoritmo specificato.
     *
     * @param salt          La password di salting.
     * @param encryptedText La password crittografata da decrittare.
     * @param algorithm     L'algoritmo da utilizzare.
     * @return La password decrittografata.
     * @throws IllegalArgumentException Se la decrittografia non è possibile.
     */
    public static String decrypt(String salt, String encryptedText, String algorithm) {
        try {
            StandardPBEStringEncryptor decryptor = createEncryptor(salt, algorithm);
            return decryptor.decrypt(encryptedText);
        } catch (EncryptionInitializationException e) {
            throw new IllegalArgumentException("Errore di inizializzazione dell'algoritmo: " + algorithm, e);
        } catch (EncryptionOperationNotPossibleException e) {
            throw new IllegalArgumentException("Errore durante la decrittografia: verifica i parametri di input.", e);
        }
    }

    /**
     * Crea un encryptor configurato con il salting e l'algoritmo specificato.
     *
     * @param salt      La password di salting.
     * @param algorithm L'algoritmo da utilizzare.
     * @return Un oggetto StandardPBEStringEncryptor configurato.
     */
    private static StandardPBEStringEncryptor createEncryptor(String salt, String algorithm) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(salt); 
        encryptor.setProviderName("BC"); 
        encryptor.setAlgorithm(algorithm);
        return encryptor;
    }


    /**
     * Valida se un algoritmo è supportato.
     *
     * @param algorithm L'algoritmo da verificare.
     * @return True se supportato, altrimenti false.
     */
    public static boolean isAlgorithmSupported(String algorithm) {
        try {
            StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
            encryptor.setAlgorithm(algorithm);
            encryptor.initialize();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
