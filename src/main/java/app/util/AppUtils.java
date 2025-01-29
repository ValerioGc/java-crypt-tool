package app.util;

import java.io.InputStream;

import app.gui.builder.CustomSceneBuilder;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos
;
public class AppUtils {


	/**
     * Creates an HBox containing a label and a button, with a specified alignment and spacing.
     *
     * @param resultField the label to display results
     * @param copyButton the button to copy the result
     * @return HBox containing the result label and copy button
     */
    public static HBox createResultBox(Label resultField, Button copyButton) {
        HBox resultBox = new HBox(10, resultField, copyButton);
        resultBox.setAlignment(Pos.CENTER);
        return resultBox;
    }

    /**
     * Loads an image from the specified resource path and returns an ImageView containing the image.
     *
     * @param resourcePath the path to the image resource
     * @return ImageView displaying the loaded image
     * @throws RuntimeException if the resource is not found
     */
    public static ImageView loadImage(String resourcePath) {
        InputStream stream = CustomSceneBuilder.class.getResourceAsStream(resourcePath);
        if (stream == null) 
            throw new RuntimeException("File not found: " + resourcePath);
        
        Image image = new Image(stream);
        return new ImageView(image);
    }
}
