package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Security;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import app.config.security.CryptoConfig;
import app.gui.EncryptPasswordGUI;

public class MainLauncher {

    private static final Logger logger = LogManager.getLogger(MainLauncher.class);

	public static void main(String[] args) {

    	printLogo();
    	
    	CryptoConfig cryptoConfig = new CryptoConfig();
    	        
        logger.info("Elenco provider sicurezza disponibili:");
        for (var provider : Security.getProviders()) {        	
            System.out.println("- " + provider.getName());
            logger.info("- " + provider.getName());
        }
        

        EncryptPasswordGUI.main(args);
    }
    
    
    /**
     * Print the application logo in console and logger on start
     */
    private static void printLogo() {

 	   String fileName = "logo.txt";

       try {
    	   InputStream inputStream = MainLauncher.class.getClassLoader().getResourceAsStream(fileName);
           
    	   String asciiArt = new BufferedReader(new InputStreamReader(inputStream))
                  .lines()
                  .collect(Collectors.joining("\n"));

	       
	       logger.info("\n" + asciiArt);
	       System.out.println("\n" + asciiArt);
	  
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}


