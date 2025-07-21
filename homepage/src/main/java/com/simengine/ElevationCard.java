package com.simengine;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.util.Duration;

public class ElevationCard{

public static void applyElevationEffect(Region card) {
        DropShadow shadow = new DropShadow();
        shadow.setRadius(0);
        shadow.setOffsetY(0);
        //shadow.setColor(Color.web("#00000033")); // soft black

        card.setEffect(shadow);

        card.setOnMouseEntered((MouseEvent e) -> {
            Timeline enterAnimation = new Timeline(
                new KeyFrame(Duration.millis(200),
                    new KeyValue(shadow.radiusProperty(), 20),
                    new KeyValue(shadow.offsetYProperty(), 15)
                )
            );
            enterAnimation.play();
        });

        card.setOnMouseExited((MouseEvent e) -> {
            Timeline exitAnimation = new Timeline(
                new KeyFrame(Duration.millis(200),
                    new KeyValue(shadow.radiusProperty(), 0),
                    new KeyValue(shadow.offsetYProperty(), 0)
                )
            );
            exitAnimation.play();
        });
    }
}