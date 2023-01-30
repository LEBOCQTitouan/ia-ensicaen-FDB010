package fr.ensicaen.lv223.model.cells;

import fr.ensicaen.lv223.model.CellType;

public class CellFactory {
    private CellFactory() {}

    public static Cell factory(String type, double intensity, int x, int y) {
        switch (type) {
            case "LAKE":
                return new LakeCell(x, y, CellType.LAKE, intensity, 200000);
            case "ORE":
                return new MineralCell(x, y, CellType.ORE, intensity, 100);
            case "BASE":
                return new Cell(x, y, CellType.BASE, intensity);
            case "STONE":
                return new Cell(x, y, CellType.STONE, intensity);
            case "FOREST":
                return new Cell(x, y, CellType.FOREST, intensity);
            case "DRY_GRASS":
                return new Cell(x, y, CellType.DRY_GRASS, intensity);
            case "GRASS":
                return new Cell(x, y, CellType.GRASS, intensity);
            case "WET_GRASS":
                return new Cell(x, y, CellType.WET_GRASS, intensity);
            case "DESERT":
                return new Cell(x, y, CellType.DESERT, intensity);
            case "FOOD":
                return new FoodCell(x, y, CellType.FOOD, intensity, 100);
            case "IMPENETRABLE":
                return new Cell(x, y, CellType.IMPENETRABLE, intensity);
            default:
                return null;
        }
    }
}
