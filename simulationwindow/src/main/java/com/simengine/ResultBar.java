package com.simengine;

import javafx.geometry.*;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ResultBar extends VBox {

    // Private labels for the metric values
    private final Label rangeValue   = new Label("0.00m");
    private final Label periodValue = new Label("0.00s");
    private final Label heightValue  = new Label("0.00m");

    public ResultBar() {
        // Header label
        Label header = new Label("\u2699 Resulting Outcomes");
        header.setFont(Font.font("Segoe UI", FontWeight.BOLD, 15));
        header.setTextFill(Color.WHITE);
        header.setPadding(new Insets(0, 0, 11, 0));

        // Value label style
        setMetricStyle(rangeValue,   "#2196F3");
        setMetricStyle(periodValue, "#43ea90");
        setMetricStyle(heightValue,  "#be5de2");

        // Metric names
        Label rangeLabel   = makeDimmedLabel("Maximum Range");
        Label periodLabel = makeDimmedLabel("Period Taken");
        Label heightLabel  = makeDimmedLabel("Height Attained");

        // Metric containers
        HBox rangeBox   = new HBox(2, rangeValue,   rangeLabel);   rangeBox.setAlignment(Pos.CENTER);
        HBox periodBox = new HBox(2, periodValue, periodLabel); periodBox.setAlignment(Pos.CENTER);
        HBox heightBox  = new HBox(2, heightValue,  heightLabel);  heightBox.setAlignment(Pos.CENTER);

        VBox metrics = new VBox(43, rangeBox, periodBox, heightBox);
        metrics.setAlignment(Pos.TOP_LEFT);

        setPadding(new Insets(24, 33, 18, 33));
        setBackground(new Background(new BackgroundFill(
            Color.web("#403d58", 0.91),
            new CornerRadii(18), Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(
            Color.rgb(110,110,135, 0.17), BorderStrokeStyle.SOLID,
            new CornerRadii(18), new BorderWidths(1)
        )));
        setSpacing(5);
        getChildren().addAll(header, metrics);
    }

    private void setMetricStyle(Label label, String color) {
        label.setFont(Font.font("Segoe UI", FontWeight.BOLD, 22));
        label.setTextFill(Color.web(color));
    }

    private Label makeDimmedLabel(String text) {
        Label lbl = new Label(text);
        lbl.setFont(Font.font("Segoe UI", 12));
        lbl.setTextFill(Color.rgb(220, 221, 248, 0.87));
        lbl.setOpacity(0.69);
        return lbl;
    }

    // PUBLIC methods to update value fields:
    public void setRange(double r)     { rangeValue.setText(String.format("%.2fm", r)); }
    public void setPeriod(double p)   { periodValue.setText(String.format("%.2fs", p)); }
    public void setHeight(double h)    { heightValue.setText(String.format("%.1fm", h));}
}

