package app.gui;

import java.io.InputStream;

import app.config.AppConfig;
import app.gui.builder.CustomSceneBuilder;
import app.text.AppMessages;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class EncryptPasswordGUI extends Application {

    @Override
    public void start(Stage primaryStage) {

    	Scene mainPage = CustomSceneBuilder.createScene();
    	
        InputStream iconStream = getClass().getResourceAsStream(AppConfig.APP_ICON);
        if (iconStream != null) {
            Image appIcon = new Image(iconStream);
            primaryStage.getIcons().add(appIcon);
        } else {
            System.err.println(AppMessages.ERROR_LOGO);
        }

        primaryStage.setScene(mainPage);
        primaryStage.setTitle(AppConfig.APP_TITLE);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
