package fr.ensicaen.lv223.view;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CellView {
    private final double width;
    private final double height;
    private final Color color;
    private final Rectangle shape;
    private RobotView robotView;
    private StackPane pane;

    public CellView(double width, double height, String type) {
        this.pane = new StackPane();
        this.width = width;
        this.height = height;
        this.color = getColor(type);

        shape = new Rectangle(width, height);
        shape.setFill(color);
        this.pane.getChildren().add(shape);

        robotView = new RobotView(this.width);
        this.pane.getChildren().add(robotView.getShape());
    }

    public Rectangle getShape() {
        return shape;
    }

    private Color getColor(String type) {
        switch (type) {
            case "BASE":
                return Color.DARKBLUE;
            case "DESERT":
                return Color.LEMONCHIFFON;
            case "DRY_GRASS":
                return Color.YELLOWGREEN;
            case "FOOD":
                return Color.TOMATO;
            case "FOREST":
                return Color.FORESTGREEN;
            case "GRASS":
                return Color.MEDIUMSEAGREEN;
            case "IMPENETRABLE":
                return Color.BLACK;
            case "LAKE":
                return Color.MEDIUMAQUAMARINE;
            case "ORE":
                return Color.GOLD;
            case "STONE":
                return Color.GREY;
            case "WET_GRASS":
                return Color.DARKGREEN;
            default:
                return null;
        }
    }

    public RobotView getRobotView() {
        return robotView;
    }

    public void setRobotView(RobotView robotView) {
        this.robotView = robotView;
    }

    public StackPane getPane() {
        return pane;
    }

    public void setPane(StackPane pane) {
        this.pane = pane;
    }
}
