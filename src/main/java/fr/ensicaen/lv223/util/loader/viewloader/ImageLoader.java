package fr.ensicaen.lv223.util.loader.viewloader;

import fr.ensicaen.lv223.model.agent.robot.RobotType;
import fr.ensicaen.lv223.model.environment.cells.CellType;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class ImageLoader {
    private static ImageLoader instance;
    private HashMap<RobotType, Image> robotTypeImagesPath;
    private HashMap<CellType, Image> cellTypeImagesPath;

    private static final String ressourcePath = "display/img/";

    private ImageLoader() throws Exception {
        robotTypeImagesPath = new HashMap<>();
        cellTypeImagesPath = new HashMap<>();

        for (RobotType type : RobotType.values()) {
            String path = RobotType.class.getResource( ressourcePath + "robot/ROBOT_" + type.name().toUpperCase() + ".png").getPath();
            if (path == null)
                throw new Exception("The image loader do not have access to the ressources files please check your configuration");
            robotTypeImagesPath.put(type, new Image(path));
        }

        for (CellType type : CellType.values()) {
            String path = CellType.class.getResource(ressourcePath + "tile/TILE_" + type.name().toUpperCase() + ".png").getPath();
            if (path == null)
                throw new Exception("The image loader do not have access to the ressources files please check your configuration");
            cellTypeImagesPath.put(type, new Image(path));
        }
    }

    public static ImageLoader getInstance() throws Exception {
        if (instance == null) {
            instance = new ImageLoader();
        }
        return instance;
    }

    public Image getRobotImage(RobotType type) {
        return robotTypeImagesPath.get(type);
    }

    public Image getCellImage(CellType type) {
        return cellTypeImagesPath.get(type);
    }
}
