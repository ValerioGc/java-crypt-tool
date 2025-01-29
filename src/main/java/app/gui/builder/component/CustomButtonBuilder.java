package app.gui.builder.component;

import app.business.EncryptDecryptLogic;
import app.config.AppConfig;
import app.text.AppMessages;
import app.util.AppUtils;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

/**
 * A utility class for creating custom buttons with specific functionalities.
 * <strong>Created by ValerioGc</strong>
 * <strong>@Version 1.0 </strong>
 */
public class CustomButtonBuilder {

    /**
     * Creates a "Run" button to execute encryption or decryption based on the selected operation.
     * The button is initially disabled and becomes active when all required inputs are provided.
     *
     * @param resultField       the label to display the result of the operation
     * @param copyButton        the button to copy the result to the clipboard
     * @param operationGroup    the ToggleGroup containing encryption and decryption options
     * @param algorithmSelector the ComboBox to select the encryption algorithm
     * @param saltingInput      the TextField for entering the salt value
     * @param passwordInput     the TextField for entering the password
     * @return the configured "Run" button
     */
    public static Button createRunButton(Label resultField, Button copyButton, ToggleGroup operationGroup, ComboBox<String> algorithmSelector, TextField saltingInput, TextField passwordInput) {
        Button runButton = new Button(AppMessages.BUTTON_RUN_LABEL);
        runButton.getStyleClass().add("btn-primary");
        runButton.setDisable(true);

        // Tooltip for the Run button
        Tooltip runTooltip = new Tooltip(AppMessages.BUTTON_RUN_ERROR_TOOLTIP);
        Tooltip.install(runButton, runTooltip);

        runButton.setOnAction(event -> {
            String salt = saltingInput.getText();
            String input = passwordInput.getText();
            String algorithm = algorithmSelector.getValue();

            RadioButton selectedOption = (RadioButton) operationGroup.getSelectedToggle();
            if (selectedOption.getText().equals(AppMessages.RADIO_ENCRYPT)) {
                resultField.setText(EncryptDecryptLogic.encrypt(salt, input, algorithm));
            } else {
                try {
                    resultField.setText(EncryptDecryptLogic.decrypt(salt, input, algorithm));
                } catch (Exception e) {
                    resultField.setText(AppMessages.ERROR_DECRYPT);
                }
            }

            resultField.setVisible(true);
            copyButton.setVisible(true);
        });

        // Update tooltip dynamically based on the button state
        runButton.disableProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                runTooltip.setText(AppMessages.BUTTON_RUN_ERROR_TOOLTIP); // Tooltip for disabled state
            } else {
                runTooltip.setText(AppMessages.BUTTON_RUN_TOOLTIP); // Tooltip for enabled state
            }
        });

        return runButton;
    }

    /**
     * Creates a "Copy" button to copy the result from the result label to the system clipboard.
     * The button is initially hidden and becomes visible when a result is available.
     *
     * @param resultField the label containing the result to be copied
     * @return the configured "Copy" button
     */
    public static Button createCopyButton(Label resultField) {
        Button copyButton = new Button();
        copyButton.setGraphic(AppUtils.loadImage(AppConfig.COPY_ICON));
        copyButton.getStyleClass().add("btn-primary");
        copyButton.setVisible(false);

        // Tooltip for the Copy button
        Tooltip copyTooltip = new Tooltip(AppMessages.BUTTON_COPY_TOOLTIP);
        Tooltip.install(copyButton, copyTooltip);

        copyButton.setOnAction(event -> {
            String resultText = resultField.getText();
            if (!resultText.isEmpty()) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(resultText);
                clipboard.setContent(content);
            }
        });

        return copyButton;
    }
}
