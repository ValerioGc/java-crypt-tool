package app.config;

import java.util.Map;


/**
 * Application configuration constants
 */
public class AppConfig {

    // Window settings
    public static final String APP_TITLE = "Encrypt Tool";
    public static final String APP_ICON = "/icons/logo.png";
    public static final boolean RESIZABLE = true;
    public static final int VIEW_PADDING = 45;
    public static final int VIEW_WIDTH = 550;
    public static final int VIEW_HEIGHT = 380;
    public static final int INPUT_MAX_WIDTH = 300;

    // Icons
    public static final String SALTING_ICON = "/icons/salting.png";
    public static final String PASSWORD_ICON = "/icons/password.png";
    public static final String ALGORITHM_ICON = "/icons/algor.png";
    public static final String COPY_ICON = "/icons/copy.png";

    /**
     * Supported algorithms both from Jaysypt & Bounty Castle
     */
    public static final Map<String, String> ALGORITHMS = Map.of(
    	    "MD5 + DES", "PBEWITHMD5ANDDES",
    	    "SHA1 + Triple DES", "PBEWITHSHA1ANDDESEDE",
    	    "SHA256 + AES (128-bit)", "PBEWITHSHA256AND128BITAES-CBC-BC",
    	    "SHA256 + AES (256-bit)", "PBEWITHSHA256AND256BITAES-CBC-BC",
    	    "MD5 + Triple DES", "PBEWITHMD5ANDTRIPLEDES",
    	    "SHA1 + AES (128-bit)", "PBEWITHSHA1ANDAES_128",
    	    "SHA1 + AES (256-bit)", "PBEWITHSHA1ANDAES_256",
    	    "SHA512 + AES (128-bit)", "PBEWITHHMACSHA512ANDAES_128",
    	    "SHA512 + AES (256-bit)", "PBEWITHHMACSHA512ANDAES_256"
    );
}