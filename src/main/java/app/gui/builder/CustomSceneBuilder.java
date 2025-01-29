package app.gui.builder;

import java.net.URL;

import app.config.AppConfig;
import app.gui.builder.component.CustomButtonBuilder;
import app.gui.builder.component.CustomInputBuilder;
import app.gui.builder.component.CustomRadioBuilder;
import app.text.AppMessages;
import app.util.AppUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CustomSceneBuilder {

    public static Scene createScene() {
    	
	// Window
        VBox root = new VBox(25);
        root.setPadding(new Insets(AppConfig.VIEW_PADDING));
        root.setAlignment(Pos.TOP_CENTER);

        
    // Algorithm
        HBox algorithmBox = CustomInputBuilder.createAlgorithmRow();

        ComboBox<String> algorithmSelector = new ComboBox<>();
        algorithmSelector.getItems().addAll(AppConfig.ALGORITHMS.keySet());
        algorithmSelector.setValue(null);
        algorithmSelector.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                String algorithmName = newValue;
                String algorithmValue = AppConfig.ALGORITHMS.get(algorithmName);
                System.out.println("Selezionato: " + algorithmName + " -> Valore: " + algorithmValue);
            }
        });

    // Salting key input
        HBox saltingBox = CustomInputBuilder.createSaltingInput();
        TextField saltingInput = (TextField) saltingBox.getChildren().get(2);

    // Password field		
        HBox passwordBox = CustomInputBuilder.createPasswordInput();
        TextField passwordInput = (TextField) passwordBox.getChildren().get(2);

        // Radio Buttons
        HBox radioButtonsBox = CustomRadioBuilder.createRadioButtonsRow();
        ToggleGroup operationGroup = ((RadioButton) radioButtonsBox.getChildren().get(0)).getToggleGroup();

    // Run button and result
        Label resultField = new Label();
        resultField.getStyleClass().add("result_field");
        resultField.setVisible(false);

        Button copyButton = CustomButtonBuilder.createCopyButton(resultField);
        Button runButton = CustomButtonBuilder.createRunButton(
            resultField,
            copyButton,
            operationGroup,
            algorithmSelector,
            saltingInput,
            passwordInput
        );

        HBox resultBox = AppUtils.createResultBox(resultField, copyButton);

        // Enable/disable "Run" button based on other inputs
        saltingInput.textProperty().addListener((observable, oldValue, newValue) -> {
            updateRunButtonState(runButton, saltingInput, passwordInput, algorithmSelector);
        });
        passwordInput.textProperty().addListener((observable, oldValue, newValue) -> {
            updateRunButtonState(runButton, saltingInput, passwordInput, algorithmSelector);
        });
        algorithmSelector.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateRunButtonState(runButton, saltingInput, passwordInput, algorithmSelector);
        });

        
        root.getChildren().addAll(
            algorithmBox,
            saltingBox,
            passwordBox,
            radioButtonsBox,
            runButton,
            resultBox
        );

        Scene scene = new Scene(root, AppConfig.VIEW_WIDTH, AppConfig.VIEW_HEIGHT);

        URL cssResource = CustomSceneBuilder.class.getResource("/styles.css");
        if (cssResource == null) {
            throw new RuntimeException(AppMessages.STYLE_NOT_FOUND);
        }
        scene.getStylesheets().add(cssResource.toExternalForm());

        return scene;
    }

    private static void updateRunButtonState(Button runButton, TextField saltingInput, TextField passwordInput, ComboBox<String> algorithmSelector) {
        boolean disable = !saltingInput.getText().isEmpty()
            && !passwordInput.getText().isEmpty()
            && algorithmSelector.getValue() != null;

        
        if(!disable)
            runButton.getStyleClass().add("disabled");
        else
        	runButton.getStyleClass().remove("disabled");
    }
}
