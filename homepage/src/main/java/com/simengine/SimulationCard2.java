package com.simengine;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SimulationCard2 extends VBox {

   public static VBox createSimulationCard() {
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
    String simName = "Projectile Motion";
    String description = "Explore and visualize projectile trajectories in 2D physics. Experiment with angle, velocity, and gravity!";
    String simImageUrl = "https://example.com/simulation-image.png"; // Replace with a real image path or use getClass().getResource(...)
    String author = "Dr. Jane Smith";
    String authorImageUrl = "https://example.com/author-avatar.png"; // Replace with a real image path
    String rating = "4.8";
    String runs = "2,312";
    String[] tags = {"Physics", "Motion", "2D", "Interactive"};

    // Simulation Image
    ImageView simImage = new ImageView(new Image(simImageUrl));
    simImage.setFitWidth(200);
    simImage.setFitHeight(100);
    simImage.setPreserveRatio(true);
    simImage.setSmooth(true);

    // Simulation Name
    Label nameLabel = new Label(simName);
    nameLabel.setFont(Font.font("Segoe UI", FontWeight.BOLD, 15));
    nameLabel.setWrapText(true);

    // Description
    Label descLabel = new Label(description);
    descLabel.setFont(Font.font("Segoe UI", 11));
    descLabel.setTextFill(Color.web("#555555"));
    descLabel.setWrapText(true);

    // Rating & Runs
    Label statsLabel = new Label("★ " + rating + "   ▶️ " + runs + " runs");
    statsLabel.setFont(Font.font("Segoe UI", 11));
    statsLabel.setTextFill(Color.web("#6C63FF"));

    // Author Info
    ImageView authorPic = new ImageView(new Image(authorImageUrl));
    authorPic.setFitHeight(24);
    authorPic.setFitWidth(24);
    authorPic.setClip(new Circle(12, 12, 12));
    Label authorLabel = new Label(author + "\nCreator");
    authorLabel.setFont(Font.font("Segoe UI", 10));
    HBox authorBox = new HBox(10, authorPic, authorLabel);
    authorBox.setAlignment(Pos.CENTER_LEFT);

    // Tags
    FlowPane tagPane = new FlowPane(5, 5);
    for (String tag : tags) {
        Label tagLabel = new Label(tag);
        tagLabel.setStyle("-fx-background-color: #E3E7FD; -fx-padding: 3 8 3 8; -fx-background-radius: 10;");
        tagLabel.setFont(Font.font("Segoe UI", 10));
        tagPane.getChildren().add(tagLabel);
    }

    // Buttons
    Button launchSim = new Button("🚀 Launch");
    Button addToFav = new Button("☆ Favorite");
    launchSim.setStyle("-fx-background-color: #6C63FF; -fx-text-fill: white; -fx-background-radius: 10;");
    addToFav.setStyle("-fx-border-color: #C7C7F7; -fx-text-fill: #6155A6; -fx-background-radius: 10;");
    launchSim.setPrefWidth(85);
    addToFav.setPrefWidth(85);

    HBox buttons = new HBox(10, launchSim, addToFav);
    buttons.setAlignment(Pos.CENTER);

    // Drop Shadow
    DropShadow ds = new DropShadow(10, Color.rgb(100, 99, 255, .12));
    card.setEffect(ds);

    card.getChildren().addAll(
        simImage, nameLabel, descLabel,
        statsLabel, authorBox, tagPane, buttons
    );

    return card;
}


}
