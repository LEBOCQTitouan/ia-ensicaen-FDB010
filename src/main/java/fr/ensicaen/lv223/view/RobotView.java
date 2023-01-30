package fr.ensicaen.lv223.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class RobotView {
    private Color color;

    private final Circle shape;

    public RobotView(double cellWidth) {
        this.shape = new Circle();
        this.shape.setRadius(cellWidth / 3);
        this.shape.setSmooth(true);
    }

    public void setVisible() {
        this.shape.setVisible(true);
    }

    public void hide() {
        this.shape.setVisible(false);
    }

    public void setColor(String type) {
        switch (type) {
            case "CARTOGRAPHER":
                this.shape.setFill(Color.DODGERBLUE);
                break;
            case "FOOD_RETRIEVER":
                this.shape.setFill(Color.DARKORANGE);
                break;
            case "FARMER":
                this.shape.setFill(Color.CORNSILK);
                break;
            case "PIPELINE_BUILDER":
                this.shape.setFill(Color.DARKSEAGREEN);
                break;
            case "ORE_EXTRACTOR":
                this.shape.setFill(Color.DARKMAGENTA);
                break;
            default:
                this.shape.setFill(Color.TRANSPARENT);
                break;
        }
    }

    public Circle getShape() {
        return shape;
    }
}
