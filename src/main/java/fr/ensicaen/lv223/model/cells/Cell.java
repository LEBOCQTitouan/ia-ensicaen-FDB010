package fr.ensicaen.lv223.model.cells;

import fr.ensicaen.lv223.model.CellType;

/**
 * A cell on the planet. The type of the cell is one of the following values:
 * - CellType.BASE: the cell where the spatial ship has landed;
 * - CellType.BOUNDARY: a cell on the boundary;
 * - CellType.DESERT: a desert cell;
 * - CellType.DRY_GRASS: a cell with a dry grass land;
 * - CellType.FOOD: a cell with some food;
 * - CellType.FOREST: a cell with a forest on it;
 * - CellType.GRASS: a cell with a normal grass land;
 * - CellType.IMPENETRABLE: an impenetrable cell, except by cartographer
 * agents;
 * - CellType.LAKE: a cell that contains some water (e.g. lake) and that is
 * a part of the exoskeleton of the planet;
 * - CellType.ORE: a cell that contains some ore and that is a part of the
 * exoskeleton of the planet;
 * - CellType.STONE: a cell from the exoskeleton;
 * - CellType.WET_GRASS: a cell with a wet grass land.
 */
public class Cell implements EnvironmentCell, Comparable {
    private final int x;
    private final int y;

    private final CellType type;
    private final double intensityOfMetamorphosis;
    private int intensityOfWave;

    /** Indicates if the cell is a part of the exoskeleton of the planet */
    private final boolean isExoskeleton;

    /**
     * Creates a new cell on the planet with a coordinate, a cell type, and an
     * initial intensity of metamorphosis.
     * @param x The column of the cell
     * @param y The row of the cell
     * @param type The type of the cell
     * @param intensity The intensity of metamorphosis
     */
    public Cell(int x, int y, CellType type, double intensity) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.intensityOfMetamorphosis = intensity;
        this.intensityOfWave = 0;
        this.isExoskeleton = type == CellType.BASE || type == CellType.LAKE || type == CellType.STONE || type == CellType.ORE || type == CellType.IMPENETRABLE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean hasBeenWaved() {
        return intensityOfWave != 0;
    }

    public int getIntensityOfWave() {
        return intensityOfWave;
    }

    public void setIntensityOfWave(int value) {
        this.intensityOfWave = value;
    }

    public boolean isExoskeleton() {
        return isExoskeleton;
    }

    @Override
    public CellType getType() {
        return type;
    }
    
    @Override
    public double getIntensity() {
        return intensityOfMetamorphosis;
    }

    /**
     * Compares the intensity of waves between two cells.
     *
     * @param o Another cell
     * @return 1 if intensity is higher, -1 if intensity is lower and 0
     * otherwise
     */
    public int compareTo(Object o) {
        Cell other = (Cell) o;
        return Integer.compare(intensityOfWave, other.getIntensityOfWave());
    }

    public String toString() {
        return "" + intensityOfWave;
    }
}
