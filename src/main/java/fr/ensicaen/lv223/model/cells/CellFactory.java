package fr.ensicaen.lv223.model.cells;

import fr.ensicaen.lv223.model.CellType;

import java.util.Optional;

public class CellFactory {
    private CellFactory() {}

    public static Optional<Cell> factory(String type, double intensity, int x, int y) {
        Cell c = null;
        switch (type) {
            case "BASE":
                c = new Cell(x, y, CellType.BASE, intensity);
                break;
            case "DESERT":
                c = new Cell(x, y, CellType.DESERT, intensity);
                break;
            case "DRY_GRASS":
                c = new Cell(x, y, CellType.DRY_GRASS, intensity);
                break;
            case "FOOD":
                c = new Cell(x, y, CellType.FOOD, intensity);
                break;
            case "FOREST":
                c = new Cell(x, y, CellType.FOREST, intensity);
                break;
            case "GRASS":
                c = new Cell(x, y, CellType.GRASS, intensity);
                break;
            case "IMPENETRABLE":
                c = new Cell(x, y, CellType.IMPENETRABLE, intensity);
                break;
            case "LAKE":
                c = new Cell(x, y, CellType.LAKE, intensity);
                break;
            case "ORE":
                c = new Cell(x, y, CellType.ORE, intensity);
                break;
            case "STONE":
                c = new Cell(x, y, CellType.STONE, intensity);
                break;
            case "WET_GRASS":
                c = new Cell(x, y, CellType.WET_GRASS, intensity);
                break;
            default:
                return null;
        }
        return Optional.ofNullable(c);
    }
}
