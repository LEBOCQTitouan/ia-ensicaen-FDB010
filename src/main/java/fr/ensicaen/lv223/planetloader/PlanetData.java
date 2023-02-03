package fr.ensicaen.lv223.planetloader;

/**
 * The {@code PlanetData} class contains the data of a planet with its type and
 * cell positions.
 */
public class PlanetData {
    private String type;
    private CellPosition[] cellPos;

    public String getType() {
        return type;
    }

    public CellPosition[] getCellPos() {
        return cellPos;
    }
}
