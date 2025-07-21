// --- ResultBar.java (component) ---
package com.simengine;

import javafx.geometry.*;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class demo extends VBox {

    private final Label timeValue = new Label("0.00s");
    private final Label periodValue = new Label("3.31s");
    private final Label angleValue = new Label("45.0°");
    private final Label energyValue = new Label("0.00J");

    public demo() {
        setPadding(new Insets(16));
        setSpacing(12);
        setBackground(new Background(new BackgroundFill(
            Color.web("#403d58", 0.89),
            new CornerRadii(17),
            Insets.EMPTY
        )));
        setBorder(new Border(new BorderStroke(
            Color.rgb(80,80,120,0.2), BorderStrokeStyle.SOLID, new CornerRadii(17),
            new BorderWidths(1)
        )));

        // Header
        Label header = new Label("\u2699 Real-time Metrics"); // Unicode for settings-gear
        header.setFont(Font.font("Segoe UI", FontWeight.BOLD, 15));
        header.setTextFill(Color.WHITE);

        // Metric values and labels
        formatMetric(timeValue, "#2196F3", FontWeight.BOLD);      // Blue
        formatMetric(periodValue, "#43ea90", FontWeight.BOLD);   // Green
        formatMetric(angleValue, "#be5de2", FontWeight.BOLD);    // Purple
        formatMetric(energyValue, "#ff9900", FontWeight.BOLD);   // Orange

        Label timeLabel = new Label("Time");
        Label periodLabel = new Label("Period");
        Label angleLabel = new Label("Angle");
        Label energyLabel = new Label("Energy");

        for (Label l : new Label[]{timeLabel, periodLabel, angleLabel, energyLabel}) {
            l.setFont(Font.font("Segoe UI", 13));
            l.setTextFill(Color.web("#ddd"));
            l.setOpacity(0.75);
        }

        VBox timeBox = new VBox(2, timeValue, timeLabel);
        timeBox.setAlignment(Pos.CENTER);
        VBox periodBox = new VBox(2, periodValue, periodLabel);
        periodBox.setAlignment(Pos.CENTER);
        VBox angleBox = new VBox(2, angleValue, angleLabel);
        angleBox.setAlignment(Pos.CENTER);
        VBox energyBox = new VBox(2, energyValue, energyLabel);
        energyBox.setAlignment(Pos.CENTER);

        HBox metrics = new HBox(34, timeBox, periodBox, angleBox, energyBox);
        metrics.setAlignment(Pos.CENTER_LEFT);
        metrics.setPadding(new Insets(5, 0, 0, 8));

        getChildren().addAll(header, metrics);
    }

    // --- Utility to apply color and font to value labels
    private void formatMetric(Label label, String color, FontWeight w) {
        label.setFont(Font.font("Segoe UI", w, 22));
        label.setTextFill(Color.web(color));
    }

    // --- Methods to update result values ---
    public void setTime(double t) { timeValue.setText(String.format("%.2fs", t)); }
    public void setPeriod(double p) { periodValue.setText(String.format("%.2fs", p)); }
    public void setAngle(double a) { angleValue.setText(String.format("%.1f°", a)); }
    public void setEnergy(double e) { energyValue.setText(String.format("%.2fJ", e)); }
}
