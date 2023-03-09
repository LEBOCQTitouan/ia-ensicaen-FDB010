package fr.ensicaen.lv223.view.drawable;

import javafx.scene.canvas.GraphicsContext;

public interface Drawable {
    void draw(GraphicsContext gc, DrawingMetrics metrics);
}
