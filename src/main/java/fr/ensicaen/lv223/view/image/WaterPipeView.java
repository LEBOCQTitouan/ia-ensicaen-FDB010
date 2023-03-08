package fr.ensicaen.lv223.view.image;

import fr.ensicaen.lv223.model.environment.construction.ConstructionType;
import fr.ensicaen.lv223.util.Util;
import fr.ensicaen.lv223.util.loader.viewloader.ImageLoader;
import javafx.scene.image.ImageView;

public class WaterPipeView extends ImageViewElement {
    /**
     * Creates a new instance of the {@code WaterPipeView} class.
     *
     * @param size the width and height of the robot
     */
    public WaterPipeView(double size) {
        super(size);
        loadImage();
        hide();
    }

    @Override
    public void updateSize() {
        loadImage();
    }

    @Override
    protected void loadImage() {
        try {
            this.displayElement.setImage(ImageLoader.getInstance(size, size).getConstructionImage(ConstructionType.PIPE));
        } catch (Exception e) {
            Util.LOGGER.severe("Error while loading robot image: " + e.getMessage());
        }
    }
}
