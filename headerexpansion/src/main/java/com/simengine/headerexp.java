package com.simengine;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class headerexp extends Application {
    @Override
    public void start(Stage headerStage) {

        Image bgImage = new Image(getClass().getResource("/mechsim5.png").toExternalForm());

        BackgroundImage backgroundImage = new BackgroundImage(
            bgImage,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,
            new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
        ); 

        VBox mainContent = new VBox(24);
        mainContent.setPadding(new Insets(24));
        mainContent.setStyle("-fx-background-radius: 32;" +
                             "-fx-background-color: linear-gradient(to bottom right, rgba(103, 92, 92, 0.11) 0%, rgba(65, 63, 63, 0.45) 100%);" +
                             "-fx-border-radius: 32;" +
                             "-fx-border-color: rgba(255, 255, 255, 0.47);" +
                             "-fx-border-width: 1.8;");


        Label titleLbl = new Label("Mechanics");
        titleLbl.setFont(Font.font("Segoe UI", FontWeight.BOLD, 36));
        titleLbl.setTextFill(Color.WHITE);
        Label subtitleLbl = new Label("Mechanics is a fundamental branch of physics that studies the motion of objects" + "\n" +"and the forces that cause or change this motion.");
        subtitleLbl.setFont(Font.font("Segoe UI", FontWeight.NORMAL, 20));
        subtitleLbl.setTextFill(Color.WHITE);


        VBox headerText = new VBox(8);
        headerText.setPadding(new Insets(24, 24, 24, 24));
        headerText.setPrefHeight(700);
        headerText.setStyle("-fx-background-radius: 32;"+
                        "-fx-background-color: linear-gradient(to bottom, #451387ff 60%, #160e1dcc 100%);");
        headerText.getChildren().addAll(titleLbl, subtitleLbl);
        headerText.setStyle("-fx-text-fill : white;"+
                         "-fx-font-weight: Bold;"+
                         "-fx-font-size : 14px"+
                         "-fx-background-radius : 25");
     

        headerText.setAlignment(Pos.CENTER);
        headerText.setBackground(new Background(backgroundImage));
        
        // List of Cards
        VBox list = new VBox(12);
        for (int i = 1; i <= 10; i++) {
            HBox item = new HBox(16);
            item.setAlignment(Pos.CENTER_LEFT);
            item.setPadding(new Insets(8));
            item.setStyle("-fx-background-color: white; -fx-background-radius: 18;");

            VBox imagePlaceholder = new VBox();
            imagePlaceholder.setPrefSize(60, 60);
            imagePlaceholder.setStyle("-fx-background-color: #eee; -fx-background-radius: 12;");
            Label imgIcon = new Label("\u25B2");
            imagePlaceholder.getChildren().add(imgIcon);

            VBox itemText = new VBox(4);
            Label listItemTitle = new Label("Sim " + i);
            listItemTitle.setFont(Font.font("Segoe UI", FontWeight.BOLD, 18));
            Label meta = new Label("Explore and visualize projectile trajectories in 2D physics. Experiment with angle, velocity, and gravity!");
            meta.setTextFill(Color.GRAY);
            meta.setFont(Font.font(13));

            itemText.setStyle("-fx-background-color: transparent;");
            itemText.getChildren().addAll(listItemTitle, meta);
            

            Region spacer = new Region();
            HBox.setHgrow(spacer, Priority.ALWAYS);

            VBox startbtn = new VBox(8);
            startbtn.setAlignment(Pos.TOP_RIGHT);
            Button startBtn = new Button("Get Started");
            startBtn.setStyle("-fx-background-color: linear-gradient(to right, #9b08f0ff,#185a9d); -fx-text-fill: white;" +"-fx-font-size: 16px;");
            startBtn.setOnMouseEntered(e ->startBtn.setStyle("-fx-background-color: #0e020aff; -fx-text-fill: #9b08f0ff;"+"-fx-font-size: 16px;"));
            startBtn.setOnMouseExited(e -> startBtn.setStyle("-fx-background-color: linear-gradient(to right, #3c0067ff,#185a9d); -fx-text-fill: white;"+"-fx-font-size: 16px;"));
            startbtn.getChildren().addAll(startBtn);

            item.getChildren().addAll(imagePlaceholder, itemText, spacer, startbtn);
            list.getChildren().add(item);
        }
        list.setBackground(new Background(new BackgroundFill(
                           new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,
                           new Stop(0, Color.web("#312645ff")), new Stop(1, Color.web("#130418ff"))),
                           new CornerRadii(32), Insets.EMPTY)));

        ScrollPane scrollPane = new ScrollPane(list);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        // Compose Main Content Area
        mainContent.getChildren().addAll(headerText,scrollPane);

        // Layout Sidebar + Main Content
        HBox root = new HBox( mainContent);
        root.setAlignment(Pos.BOTTOM_CENTER);
        root.setPadding(new Insets(40));
        root.setBackground(new Background(new BackgroundFill(
                           new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,
                           new Stop(0, Color.web("#312645ff")), new Stop(1, Color.web("#130418ff"))),
                           CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(root, 999, 665);
        headerStage.setScene(scene);
        headerStage.setTitle("Main Header Expansion");
        headerStage.setResizable(false);
        headerStage.show();
    }

}
