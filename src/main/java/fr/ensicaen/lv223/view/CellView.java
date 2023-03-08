package fr.ensicaen.lv223.view;

import fr.ensicaen.lv223.Main;
import fr.ensicaen.lv223.model.environment.cells.CellType;
import fr.ensicaen.lv223.model.environment.construction.ConstructionType;
import fr.ensicaen.lv223.util.Util;
import fr.ensicaen.lv223.util.loader.viewloader.ImageLoader;
import javafx.scene.Node;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code CellView} class is a visual representation of a {@code Cell} in
 * the simulation.
 * It contains information about the width, height and color of the cell, and
 * it's corresponding {@code RobotView} object.
 */
public class CellView implements View {
    private final double width;
    private final double height;
    private Image image;
    private final RobotView robotView;
    private final StackPane pane;

    /**
     * Constructs a new {@code CellView} instance with specified {@code width
     * }, {@code height}, and {@code type} parameters.
     *
     * @param width The width of the cell.
     * @param height The height of the cell.
     * @param type The type of cell, used to determine its color.
     */
    public CellView(double width, double height, CellType type, int x, int y) {
        this.pane = new StackPane();
        this.width = width;
        this.height = height;

        try {
            Image image = ImageLoader.getInstance(width, height).getCellImage(type);
            ImageView imageView = new ImageView(image);
            this.pane.getChildren().add(imageView);
        } catch (Exception e) {
            Util.LOGGER.severe("Error while loading cell image: " + e.getMessage());
            // TODO no loading mode
        }

        robotView = new RobotView(this.width);
        this.pane.getChildren().add(robotView.getNode());
    }

    /**
     * Returns the {@link RobotView} instance associated with this cell.
     *
     * @return The {@code RobotView} instance associated with this cell.
     */
    public RobotView getRobotView() {
        return robotView;
    }

    @Override
    public List<Node> getNodes() {
        List<Node> nodes = new ArrayList<>();
        nodes.add(pane);
        return nodes;
    }

    /**
     * Sets the {@code CellView} to a % of a blurred state.
     * @param percentage
     */
    public void setBlurred(int percentage) {
        GaussianBlur blur = new GaussianBlur(percentage);
        this.pane.setEffect(blur);
    }
}
