package fr.ensicaen.lv223.util.loader.viewloader.image;

import fr.ensicaen.lv223.model.agent.robot.RobotType;
import fr.ensicaen.lv223.model.environment.cells.CellType;
import fr.ensicaen.lv223.model.environment.construction.ConstructionType;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

public class ImageLoader {
    private static ImageLoader instance;
    private final HashMap<RobotType, String> robotTypeImagesPath;
    private final HashMap<CellType, String> cellTypeImagesPath;
    private final HashMap<ConstructionType, String> constructionTypeImagesPath;
    private final HashMap<RobotType, Image> robotTypeImages;
    private final HashMap<CellType, Image> cellTypeImages;
    private final HashMap<ConstructionType, Image> constructionTypeImages;
    private double width;
    private double height;
    private static final String ressourcePath = "/display/img/";

    private ImageLoader(double width, double height) {
        robotTypeImagesPath = new HashMap<>();
        cellTypeImagesPath = new HashMap<>();
        constructionTypeImagesPath = new HashMap<>();
        robotTypeImages = new HashMap<>();
        cellTypeImages = new HashMap<>();
        constructionTypeImages = new HashMap<>();

        this.width = width;
        this.height = height;

        for (RobotType type : RobotType.values()) {
            String path = ressourcePath + "robot/ROBOT_" + type.name().toUpperCase() + ".png";
            robotTypeImagesPath.put(type, path);
        }

        for (CellType type : CellType.values()) {
            String path = ressourcePath + "tile/TILE_" + type.name().toUpperCase() + ".png";
            cellTypeImagesPath.put(type, path);
        }

        for (ConstructionType type : ConstructionType.values()) {
            String path = ressourcePath + "construction/CONSTRUCTION_" + type.name().toUpperCase() + ".png";
            constructionTypeImagesPath.put(type, path);
        }
    }

    public static ImageLoader getInstance(double width, double height) {
        if (instance == null) {
            instance = new ImageLoader(width, height);
        }
        if (instance.getWidth() != width || instance.getHeight() != height) {
            instance.clearCache();
            instance.setWidth(width);
            instance.setHeight(height);
        }
        return instance;
    }

    private boolean imageIsLoaded(RobotType type) {
        return robotTypeImages.containsKey(type);
    }

    private boolean imageIsLoaded(CellType type) {
        return cellTypeImages.containsKey(type);
    }

    private boolean imageIsLoaded(ConstructionType type) {
        return constructionTypeImages.containsKey(type);
    }

    public Image getRobotImage(RobotType type) throws FileNotFoundException, URISyntaxException {
        if (imageIsLoaded(type))
            return robotTypeImages.get(type);

        URI imgURI = getClass().getResource(robotTypeImagesPath.get(type)).toURI();
        File imgFile = new File(imgURI);
        robotTypeImages.put(
                type,
                new Image(new FileInputStream(imgFile), width, height, true, true)
        );
        return robotTypeImages.get(type);
    }

    public Image getCellImage(CellType type) throws FileNotFoundException, URISyntaxException {
        if (imageIsLoaded(type))
            return cellTypeImages.get(type);

        URI imgURI = getClass().getResource(cellTypeImagesPath.get(type)).toURI();
        File imgFile = new File(imgURI);
        cellTypeImages.put(
                type,
                new Image(new FileInputStream(imgFile), width, height, true, true)
        );
        return cellTypeImages.get(type);
    }

    public Image getConstructionImage(ConstructionType type) throws FileNotFoundException, URISyntaxException {
        if (imageIsLoaded(type))
            return constructionTypeImages.get(type);

        URI imgURI = getClass().getResource(constructionTypeImagesPath.get(type)).toURI();
        File imgFile = new File(imgURI);
        constructionTypeImages.put(
                type,
                new Image(new FileInputStream(imgFile), width, height, true, true)
        );
        return constructionTypeImages.get(type);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    protected void setWidth(double width) {
        this.width = width;
    }

    protected void setHeight(double height) {
        this.height = height;
    }

    public void clearCache() {
        robotTypeImages.clear();
        cellTypeImages.clear();
    }
}
