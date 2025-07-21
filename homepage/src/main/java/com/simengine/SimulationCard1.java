package com.simengine;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SimulationCard1 extends VBox {

   public static VBox createSimulationCard( String simName, String description,String simImageUrl,String author,String authorImageUrl,String rating,String runs ,Image icon1Image) {
    VBox card = new VBox(10);
    card.setPadding(new Insets(10));
    card.setPrefWidth(400);
    card.setPrefHeight(200);
    card.setStyle(
        "-fx-background-color: #F9FAFB; " +
        "-fx-background-radius: 14; " +
        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.08), 8, 0, 0, 4);"
    );

    // Static Data
    String simName1 = simName;
    String description1 = description;
    String simImageUrl1 = simImageUrl; 
    String author1 = author;
    String authorImageUrl1 = authorImageUrl; 
    String rating1 = rating;
    String runs1 = runs;
    Image backgroundImageUrl1 = icon1Image;

    // Simulation Image
    ImageView simImage1 = new ImageView(new Image(simImageUrl1));
    simImage1.setFitWidth(200);
    simImage1.setFitHeight(100);
    simImage1.setPreserveRatio(true);
    simImage1.setSmooth(true);

    // Simulation Name
    Label nameLabel = new Label(simName1);
    nameLabel.setFont(Font.font("Segoe UI", FontWeight.BOLD, 15));
    nameLabel.setWrapText(true);

    // Description
    Label descLabel = new Label(description1);
    descLabel.setFont(Font.font("Segoe UI", 11));
    descLabel.setTextFill(Color.web("#555555"));
    descLabel.setWrapText(true);

    // Rating & Runs
    Label statsLabel = new Label("★ " + rating1 + "   ▶️ " + runs1 + " runs");
    statsLabel.setFont(Font.font("Segoe UI", 11));
    statsLabel.setTextFill(Color.web("#6C63FF"));

    // Author Info
    ImageView authorPic = new ImageView(new Image(authorImageUrl1));
    authorPic.setFitHeight(24);
    authorPic.setFitWidth(24);
    authorPic.setClip(new Circle(12, 12, 12));
    Label authorLabel = new Label(author1 + "\nCreator");
    authorLabel.setFont(Font.font("Segoe UI", 10));
    HBox authorBox = new HBox(10, authorPic, authorLabel);
    authorBox.setAlignment(Pos.CENTER_LEFT);

    Button launchSim = new Button("🚀 Launch");
    launchSim.setStyle("-fx-background-color: #6C63FF; -fx-text-fill: white; -fx-background-radius: 10;");
    launchSim.setPrefWidth(85);

    HBox buttons = new HBox(10, launchSim);
    buttons.setAlignment(Pos.CENTER);

    DropShadow ds = new DropShadow(10, Color.rgb(100, 99, 255, .12));
    card.setEffect(ds);
    card.getChildren().addAll(
        simImage1, nameLabel, descLabel,
        statsLabel, authorBox, buttons
    );

    BackgroundImage bgImage = new BackgroundImage(
        backgroundImageUrl1,
        BackgroundRepeat.NO_REPEAT,
        BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.DEFAULT,
        new BackgroundSize(
            BackgroundSize.AUTO,
            BackgroundSize.AUTO,
            false,
            false,
            true,
            true
        )
    );

    card.setBackground(new Background(bgImage));
        // StackPane bg = new StackPane();
        // bg.setBackground(new Background(bgImage));
        // bg.getChildren().add(card);

    // Set as the background for the card
    return card;
}

}
