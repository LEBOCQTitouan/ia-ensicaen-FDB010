package fr.ensicaen.lv223.view.image;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public abstract class ImageViewElement {
    /**
     * The size of the element. The size is the width and height of the element.
     */
    protected double size;
    /**
     * The element holding the image displayed on the screen.
     */
    protected final ImageView displayElement;

    /**
     * Creates a new instance of the {@code ImageViewElement} class.
     *
     * @param size the width and height of the element
     */
    public ImageViewElement(double size) {
        this.size = size;
        this.displayElement = new ImageView();
    }

    /**
     * Gets the size of the element.
     *
     * @return the size of the element
     */
    public double getSize() {
        return size;
    }

    /**
     * Sets the size of the element.
     *
     * @param size the new size of the element
     */
    public void setSize(double size) {
        if (size != this.size) {
            this.size = size;
            updateSize();
        }
    }

    /**
     * Gets the node that is used to display the element on the screen.
     *
     * @return the node that is used to display the element on the screen
     */
    public Node getNode() {
        return displayElement;
    }

    /**
     * Actions to perform when the size of the element is changed.
     */
    protected abstract void updateSize();

    /**
     * Loads the image to display.
     */
    protected abstract void loadImage();

    /**
     * Shows the element on the screen.
     */
    public void setVisible() {
        this.displayElement.setVisible(true);
    }

    /**
     * Hides the element on the screen.
     */
    public void hide() {
        this.displayElement.setVisible(false);
    }
}
