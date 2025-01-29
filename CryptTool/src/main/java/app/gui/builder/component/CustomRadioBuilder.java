package app.gui.builder.component;

import app.text.AppMessages;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;


/**
 * A utility class for creating custom radio button components for selecting operations.
 * <br/>
 * <br/><strong>Created by ValerioGc</strong>
 * <br/><strong>@Version 1.0 </strong>
 */
public class CustomRadioBuilder {
	
	
    /**
     * Creates a horizontal box containing two radio buttons for selecting encryption or decryption operations.
     * The "Encrypt" option is selected by default.
     *
     * @return an HBox containing the radio buttons
     */
	 public static HBox createRadioButtonsRow() {
		ToggleGroup operationGroup = new ToggleGroup();
		RadioButton encryptOption = new RadioButton(AppMessages.RADIO_ENCRYPT);
		RadioButton decryptOption = new RadioButton(AppMessages.RADIO_DECRYPT);
		encryptOption.setToggleGroup(operationGroup);
		decryptOption.setToggleGroup(operationGroup);
		encryptOption.setSelected(true);
		
		HBox radioButtonsBox = new HBox(45, encryptOption, decryptOption);
		radioButtonsBox.setAlignment(Pos.CENTER);
		
		return radioButtonsBox;
	}

}
