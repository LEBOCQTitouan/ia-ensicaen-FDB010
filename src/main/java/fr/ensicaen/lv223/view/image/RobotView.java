package fr.ensicaen.lv223.view.image;

import fr.ensicaen.lv223.model.agent.robot.RobotType;
import fr.ensicaen.lv223.util.Util;
import fr.ensicaen.lv223.util.loader.viewloader.ImageLoader;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 * A visual representation of a robot in the simulation. The robot is
 * displayed as a circle shape. The circle is filled with a color that depends
 * on the type of the robot.
 */
public class RobotView extends ImageViewElement {
    private RobotType type;

    /**
     * Creates a new instance of the {@code RobotView} class.
     *
     * @param size the width and height of the robot
     */
    public RobotView(double size) {
        super(size);
        type = RobotType.NONE;
        loadImage();
        hide();
    }

    /**
     * Changes the type of the robot.
     * @param type The new type of the robot.
     */
    public void setRobotType(RobotType type) {
        this.type = type;
        loadImage();
    }

    @Override
    public void updateSize() {
        loadImage();
    }

    @Override
    protected void loadImage() {
        try {
            this.displayElement.setImage(ImageLoader.getInstance(size, size).getRobotImage(type));
        } catch (Exception e) {
            Util.LOGGER.severe("Error while loading robot image: " + e.getMessage());
        }
    }
}
