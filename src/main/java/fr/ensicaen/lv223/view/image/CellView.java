package fr.ensicaen.lv223.view.image;

import fr.ensicaen.lv223.model.environment.cells.CellType;
import fr.ensicaen.lv223.util.Util;
import fr.ensicaen.lv223.util.loader.viewloader.ImageLoader;
import fr.ensicaen.lv223.view.View;
import javafx.scene.Node;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code CellView} class is a visual representation of a {@code Cell} in
 * the simulation.
 * It contains information about the width, height and color of the cell, and
 * it's corresponding {@code RobotView} object.
 */
public class CellView extends ImageViewElement implements View {
    private CellType type;
    private ImageView imageView;
    private final RobotView robotView;
    private final WaterPipeView waterPipeView;
    private final StackPane pane;

    /**
     * Creates a new instance of the {@code CellView} class.
     *
     * @param size the width and height of the cell
     * @param type the type of the cell
     */
    public CellView(double size, CellType type) {
        super(size);
        this.type = type;

        loadImage();
        robotView = new RobotView(size);
        waterPipeView = new WaterPipeView(size);

        this.pane = new StackPane();
        this.pane.getChildren().add(robotView.getNode());
        this.pane.getChildren().add(imageView);
        this.pane.getChildren().add(waterPipeView.getNode());
    }

    /**
     * Sets the {@code CellView} to a % of a blurred state.
     * @param percentage
     */
    public void setBlurred(int percentage) {
        GaussianBlur blur = new GaussianBlur(percentage);
        this.pane.setEffect(blur);
    }

    /**
     * Changes the type of the cell.
     * @param type The new type of the cell.
     */
    public void setType(CellType type) {
        this.type = type;
        loadImage();
    }

    /**
     * Returns the {@link RobotView} instance associated with this cell.
     *
     * @return The {@code RobotView} instance associated with this cell.
     */
    public RobotView getRobotView() {
        return robotView;
    }

    /**
     * Returns the {@link WaterPipeView} instance associated with this cell.
     * @return The {@code WaterPipeView} instance associated with this cell.
     */
    public WaterPipeView getWaterPipeView() {
        return waterPipeView;
    }

    @Override
    protected void loadImage() {
        try {
            Image image = ImageLoader.getInstance(size, size).getCellImage(type);
            imageView = new ImageView(image);
        } catch (Exception e) {
            Util.LOGGER.severe("Error while loading cell image: " + e.getMessage());
        }
    }

    @Override
    public void updateSize() {
        loadImage();
    }

    @Override
    public List<Node> getNodes() {
        List<Node> nodes = new ArrayList<>();
        nodes.add(pane);
        return nodes;
    }
}
