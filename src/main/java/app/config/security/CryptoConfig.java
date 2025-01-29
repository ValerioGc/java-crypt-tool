package app.config.security;

import java.security.Security;
import java.util.Set;

import org.bouncycastle.jce.provider.BouncyCastleProvider;


/**
 * Security provider (Bounty Castle) configuration class
*/
public class CryptoConfig {

	static {
        if (Security.getProvider("BC") == null) {
            Security.addProvider(new BouncyCastleProvider());
            
            System.out.println("################ Supported Algorithm ##################");
            Set<String> algorithms = Security.getAlgorithms("Cipher");
            algorithms.forEach(System.out::println);
        }
    }
}
