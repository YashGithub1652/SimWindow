package com.simengine;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.application.Application;

public class Simulation extends Application {

    private boolean simulationRunning = false;
    private Timeline simulationTimeline;

    @Override
    public void start(Stage SimulationStage) {
       
        Text simName = new Text("Simulation Engine");
        simName.setFont(Font.font("Segoe UI", FontWeight.BOLD, 28));
        simName.setFill(Color.WHITE);
       
        Text status = new Text("Status: Ready");
        status.setFont(Font.font("Segoe UI", 16));
        status.setFill(Color.LIGHTGRAY);
      
        Button startButton = new Button("Start Simulation");
        startButton.setStyle("-fx-background-color: linear-gradient(to right, #43cea2,#185a9d); -fx-text-fill: white;");
        startButton.setAlignment(Pos.BOTTOM_CENTER);
        startButton.setOnMouseEntered(e -> startButton.setStyle("-fx-background-color: #185a9d; -fx-text-fill: #43cea2;"));
        startButton.setOnMouseExited(e -> startButton.setStyle("-fx-background-color: linear-gradient(to right, #43cea2,#185a9d); -fx-text-fill: white;"));
        startButton.setOnAction(e -> toggleSimulation(status, startButton));

        Button shareButton = new Button("Share Simulation");
        shareButton.setStyle("-fx-background-color: linear-gradient(to right, #43cea2,#185a9d); -fx-text-fill: white;");
        shareButton.setAlignment(Pos.BOTTOM_CENTER);
        shareButton.setOnMouseEntered(e -> shareButton.setStyle("-fx-background-color: #185a9d; -fx-text-fill: #43cea2;"));
        shareButton.setOnMouseExited(e -> shareButton.setStyle("-fx-background-color: linear-gradient(to right, #43cea2,#185a9d); -fx-text-fill: white;"));
        shareButton.setOnAction(e -> toggleSimulation(null, shareButton));

        Button favButton = new Button("Favourite Simulation");
        favButton.setStyle("-fx-background-color: linear-gradient(to right, #43cea2,#185a9d); -fx-text-fill: white;");
        favButton.setAlignment(Pos.BOTTOM_CENTER);
        favButton.setOnMouseEntered(e -> favButton.setStyle("-fx-background-color: #185a9d; -fx-text-fill: #43cea2;"));
        favButton.setOnMouseExited(e -> favButton.setStyle("-fx-background-color: linear-gradient(to right, #43cea2,#185a9d); -fx-text-fill: white;"));
        favButton.setOnAction(e -> toggleSimulation(null, favButton));

        HBox controls = new HBox(14, startButton,shareButton,favButton);
        controls.setAlignment(Pos.BOTTOM_CENTER);
        controls.setPadding(new Insets(35));
        controls.setStyle(
            "-fx-background-radius: 18; " +
            "-fx-background-color: rgba(30,30,45,0.87);" +
            "-fx-effect: dropshadow(gaussian, #185a9d88, 10,0.7,0,4);"
        );
                        
        Slider velocitySlider = new Slider(100, 400, 273);
        Label velocityLabel = new Label();
        velocityLabel.setStyle("-fx-text-fill : white;"+
                         "-fx-font-weight: Bold;"+
                         "-fx-font-size : 14px");

        velocityLabel.setText("Initial Velocity: " + (int) velocitySlider.getValue() + "m/s");
            velocitySlider.valueProperty().addListener((obs, oldV, newV) ->
            velocityLabel.setText("Initial Velocity: " + newV.intValue() + "m/s")
        );

        Slider angleSlider = new Slider(20,80,45);
        Label AngleLabel = new Label();
        AngleLabel.setStyle("-fx-text-fill : white;"+
                         "-fx-font-weight: Bold;"+
                         "-fx-font-size : 14px");

        AngleLabel.setText("Set Angle: " + (int) angleSlider.getValue() + "°");
            angleSlider.valueProperty().addListener((obs, oldV, newV) ->
            AngleLabel.setText("Set Angle: " + newV.intValue() + "°")
        );

        Slider heightSlider = new Slider(100, 400, 273);
        Label HeightLabel = new Label();
        HeightLabel.setStyle("-fx-text-fill : white;"+
                         "-fx-font-weight: Bold;"+
                         "-fx-font-size : 14px");

        HeightLabel.setText("From Height: " + (int) heightSlider.getValue() + "px");
            heightSlider.valueProperty().addListener((obs, oldV, newV) ->
            HeightLabel.setText("From Height: " + newV.intValue() + "px")
        );

        VBox parameter = new VBox(14,velocityLabel,velocitySlider,AngleLabel,angleSlider,HeightLabel,heightSlider);
        parameter.setAlignment(Pos.TOP_LEFT);
        parameter.setMinWidth(100); 
        parameter.setPrefHeight(750);
        parameter.setPadding(new Insets(40));
        parameter.setBackground(new Background(new BackgroundFill(
                                new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,
                                new Stop(0, Color.web("#8357a4ff")), new Stop(1, Color.web("#18081fff"))),
                                new CornerRadii(25), 
                                Insets.EMPTY
                                )));

        ResultBar resultBar = new ResultBar();
        // resultBar.setRange(simFinalRange);
        // resultBar.setPeriod(simFinalPeriod);
        // resultBar.setHeight(simFinalHeight);

        Region spacer1 = new Region();
        HBox.setHgrow(spacer1, Priority.ALWAYS);

        VBox results = new VBox(14,spacer1,resultBar);
        results.setAlignment(Pos.TOP_LEFT);
        results.setPadding(new Insets(40));
        parameter.setBackground(new Background(new BackgroundFill(
                                new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,
                                new Stop(0, Color.web("#1b0a24ff")), new Stop(1, Color.web("#741e94ff"))),
                                new CornerRadii(25), 
                                Insets.EMPTY
                                )));

        Region spacer2 = new Region();
        HBox.setHgrow(spacer2, Priority.ALWAYS);

        HBox Base = new HBox(10,parameter,spacer2,results);

        VBox root = new VBox(25,Base, controls);
        root.setAlignment(Pos.BOTTOM_CENTER);
        root.setPadding(new Insets(40));
        root.setBackground(new Background(new BackgroundFill(
                           new LinearGradient(0,0,1,1,true, CycleMethod.NO_CYCLE,
                           new Stop(0, Color.web("#463d58ff")), new Stop(1, Color.web("#0b030fff"))),
                           CornerRadii.EMPTY, Insets.EMPTY)));

   
        Scene scene = new Scene(root, 999, 665);
        SimulationStage.setTitle("Simulation Main Window");
        SimulationStage.setScene(scene);
        SimulationStage.setResizable(false);
        SimulationStage.show();
    }

    private void toggleSimulation(Text status, Button shareButton) {
        if (!simulationRunning) {
            status.setText("Status: Running...");
            shareButton.setText("Stop Simulation");
            startSimulationAnimation(status);
        } else {
            status.setText("Status: Ready");
            shareButton.setText("Run Simulation");
            if (simulationTimeline != null) simulationTimeline.stop();
        }
        simulationRunning = !simulationRunning;
    }

    private void startSimulationAnimation(Text status) {
        simulationTimeline = new Timeline(
            new KeyFrame(javafx.util.Duration.seconds(1), evt -> {
                String txt = status.getText();
                int count = txt.matches(".*\\d+") ? Integer.parseInt(txt.replaceAll("\\D+","")) : 0;
                status.setText("Status: Running... Step " + (count + 1));
            })
        );
        simulationTimeline.setCycleCount(Animation.INDEFINITE);
        simulationTimeline.play();
    }

    public void step() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'step'");
    }
}