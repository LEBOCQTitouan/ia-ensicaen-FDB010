package fr.ensicaen.lv223.util;

import fr.ensicaen.lv223.model.logic.localisation.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Util {
    public final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static List<Coordinate> getNeighbors(Coordinate coord, int width, int height) {
        ArrayList<Coordinate> neighbors = new ArrayList<>();
        int x = coord.x;
        int y = coord.y;
        if (x > 0) {
            neighbors.add(new Coordinate(x - 1, y));
            if (y > 0) {
                neighbors.add(new Coordinate(x - 1, y - 1));
            }
            if (y < width - 1) {
                neighbors.add(new Coordinate(x - 1, y + 1));
            }
        }
        if (x < height - 1) {
            neighbors.add(new Coordinate(x + 1, y));
            if (y > 0) {
                neighbors.add(new Coordinate(x + 1, y - 1));
            }
            if (y < width - 1) {
                neighbors.add(new Coordinate(x + 1, y + 1));
            }
        }
        if (y > 0) {
            neighbors.add(new Coordinate(x, y - 1));
        }
        if (y < width - 1) {
            neighbors.add(new Coordinate(x, y + 1));
        }
        return neighbors;
    }
}
