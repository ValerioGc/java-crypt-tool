package app.gui.builder.component;

import app.config.AppConfig;
import app.text.AppMessages;
import app.util.AppUtils;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;


/**
 * A utility class for creating custom input components in the GUI.
 */
public class CustomInputBuilder {

    private static ComboBox<String> algorithmSelector;
    private static TextField saltingInput;
    private static TextField passwordInput;
    

    /**
     * Retrieves the ComboBox used for selecting algorithms.
     *
     * @return the algorithm selector ComboBox
     */
    public static ComboBox<String> getAlgorithmSelector() {
        return algorithmSelector;
    }

    /**
     * Retrieves the TextField used for salting input.
     *
     * @return the salting input TextField
     */
    public static TextField getSaltingInput() {
        return saltingInput;
    }

    /**
     * Retrieves the TextField used for password input.
     *
     * @return the password input TextField
     */
    public static TextField getPasswordInput() {
        return passwordInput;
    }

    
    /**
     * Creates an HBox for selecting an algorithm, including an icon, label, and ComboBox.
     *
     * @return HBox containing the algorithm selection components
     */
	public static HBox createAlgorithmRow() {
	    ImageView icon = AppUtils.loadImage(AppConfig.ALGORITHM_ICON);
	    Label label = new Label(AppMessages.ALGORITHM_LABEL);
	    label.getStyleClass().add("form-label");
	
	    ComboBox<String> algorithmSelector = new ComboBox<>(FXCollections.observableArrayList(AppConfig.ALGORITHMS.values()));
	    algorithmSelector.setPromptText(AppMessages.ALGORITHM_PLACEHOLDER);
	    algorithmSelector.setPrefWidth(250);
	    algorithmSelector.getStyleClass().add("text-field");
	
	    HBox row = new HBox(10, icon, label, algorithmSelector);
	    row.setAlignment(Pos.CENTER_LEFT);
	
	    return row;
	}

	/**
     * Creates an HBox for entering salting information, including an icon, label, and TextField.
     *
     * @return HBox containing the salting input components
     */
    public static HBox createSaltingInput() {
        ImageView icon = AppUtils.loadImage(AppConfig.SALTING_ICON);

        Label label = new Label(AppMessages.SALTING_LABEL);
        label.getStyleClass().add("form-label");

        saltingInput = new TextField();
        saltingInput.setPromptText(AppMessages.SALTING_PLACEHOLDER);
        saltingInput.setMaxWidth(Double.MAX_VALUE);
        saltingInput.getStyleClass().add("text-field");
        HBox.setHgrow(saltingInput, Priority.ALWAYS);

        HBox row = new HBox(10, icon, label, saltingInput);
        row.setAlignment(Pos.CENTER_LEFT);
        return row;
    }

    /**
     * Creates an HBox for entering a password, including an icon, label, and TextField.
     *
     * @return HBox containing the password input components
     */
    public static HBox createPasswordInput() {
        ImageView icon = AppUtils.loadImage(AppConfig.PASSWORD_ICON);

        Label label = new Label(AppMessages.LABEL_PASSWORD);
        label.getStyleClass().add("form-label");

        passwordInput = new TextField();
        passwordInput.setPromptText(AppMessages.PLACEHOLDER_PASSWORD);
        passwordInput.setMaxWidth(Double.MAX_VALUE);
        passwordInput.getStyleClass().add("text-field");
        HBox.setHgrow(passwordInput, Priority.ALWAYS);

        HBox row = new HBox(10, icon, label, passwordInput);
        row.setAlignment(Pos.CENTER_LEFT);
        return row;
    }

}
