package fr.ensicaen.lv223.model.robotsAlpha;

import javafx.scene.paint.Color;

public enum RobotType {
    CARTOGRAPHER(Color.DODGERBLUE),
    FOOD_RETRIEVER(Color.DARKORANGE),
    FARMER(Color.CORNSILK),
    PIPELINE_BUILDER(Color.DARKSEAGREEN),
    ORE_EXTRACTOR(Color.DARKMAGENTA),
    NONE(Color.TRANSPARENT);

    private final Color color;
    RobotType(Color color)
    {
        this.color = color;
    }
    public Color getColor()
    {
        return color;
    }
}
