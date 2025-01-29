package app.text;

import java.io.Serializable;


/**
 * <b>App Text messages</b>
 */
public class AppMessages implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
//  ####################################### MESSAGES #########################################
	
	/**
	 * 
	 */
	public static final String ALGORITHM_LABEL = "Select the algorithm";
	
	/**
	 * 
	 */
	public static final String ALGORITHM_PLACEHOLDER = "Select an encypting algorithm";

	
	/**
	 * 
	 */
	public static final String SALTING_LABEL = "Insert the salting key";
	
	/**
	 * 
	 */
    public static final String SALTING_PLACEHOLDER = "Enter salting key";
    
    /**
     * 
     */
    public static final String SALTING_NOT_VALID = "Error: Not valid salting key.";
    
    
    /**
     * Placeholder for input field 'password'
     */
    public static final String PLACEHOLDER_PASSWORD = "Enter password";
    
    /*
     * Label for input field 'password'
    */
    public static final String LABEL_PASSWORD = "Insert the password";
 
    /**
	 * Label for the 'result' input field
	 */
	public static final String RESULT_LABEL = "Result";
    
    /*
     * Label for radio button selector encrypt'
     */
    public static final String RADIO_ENCRYPT = "Encrypt Password";
    
    /*
     * Label for radio button selector decrypt'
     */
    public static final String RADIO_DECRYPT = "Decrypt Password";

   
//  ####################################### BUTTONS #########################################
	
	/*
	 * 
	 */
    public static final String BUTTON_RUN_LABEL = "Run";
    
    /*
     * 
     */
    public static final String BUTTON_RUN_TOOLTIP = "Encrypt the password";
    
    /*
     * 
    */
    public static final String BUTTON_RUN_ERROR_TOOLTIP = "Insert the required values";
	
    /*
     * 
     */
    public static final String BUTTON_COPY_TOOLTIP = "Copy to clipboard";

    
//  ####################################### ERRORS #########################################

    /**
     * 
     */
    public static final String ERROR_LOGO = "Unable to find icon application.";
    
    /**
     * 
     */
    public static final String ERROR_DECRYPT = "Error: Unable to decrypt password.";
    
    /**
     * 
     */
    public static final String ERROR_CRYPT = "Error: Unable to crypt password.";	
    
    /**
     * 
     */
    public static final String STYLE_NOT_FOUND = "File style.css not found in src/main/resources.";
    
}