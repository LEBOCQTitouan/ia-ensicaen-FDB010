package fr.ensicaen.lv223.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * A visual representation of a robot in the simulation. The robot is
 * displayed as a circle shape. The circle is filled with a color that depends
 * on the type of the robot.
 */
public class RobotView {
    /** The color of the robot */
    private Color color;

    /** The circle shape representing the robot */
    private final Circle shape;

    /**
     * Creates a new instance of the {@code RobotView} class.
     *
     * @param cellWidth the width of the cell in which the robot is displayed
     */
    public RobotView(double cellWidth) {
        this.shape = new Circle();
        this.shape.setRadius(cellWidth / 3);
        this.shape.setSmooth(true);
    }

    /**
     * Makes the robot visible in the simulation.
     */
    public void setVisible() {
        this.shape.setVisible(true);
    }

    /**
     * Hides the robot in the simulation.
     */
    public void hide() {
        this.shape.setVisible(false);
    }

    /**
     * Sets the color of the robot based on its type.
     *
     * @param type the type of the robot
     */
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

    public void setColor(Color color) {
        this.shape.setFill(color);
    }

    /**
     * Returns the circle shape representing the robot.
     *
     * @return the circle shape representing the robot
     */
    public Circle getShape() {
        return shape;
    }
}
