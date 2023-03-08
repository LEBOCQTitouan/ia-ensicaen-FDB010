package fr.ensicaen.lv223.model.environment.cells;

import fr.ensicaen.lv223.model.environment.EnvironmentCell;
import fr.ensicaen.lv223.model.environment.construction.WaterPipe;

/**
 * The {@code Cell} class represents a cell in a two-dimensional grid, with
 * properties such as x and y coordinates, cell type, intensity of metamorphosis,
 * intensity of wave, and whether it is part of the exoskeleton or not.
 * <p>
 * It implements {@code EnvironmentCell} and {@code Comparable} interfaces.
 * @see EnvironmentCell
 * @see Comparable
 */
public abstract class Cell implements EnvironmentCell {
    private final int x;
    private final int y;
    protected CellType type;
    private WaterPipe pipe;
    private double metamorphosisIntensity;
    private final boolean isExoskeleton;

    /**
     * Constructs a new {@code Cell} object with given x and y coordinates,
     * cell type, and intensity of metamorphosis. The intensity of wave is
     * initialized to 0 and isExoskeleton is set based on the cell type.
     * @param x the x coordinate of the cell
     * @param y the y coordinate of the cell
     * @param type the type of cell
     * @param intensity the intensity of metamorphosis
     */
    public Cell(int x, int y, CellType type, double intensity) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.metamorphosisIntensity = intensity;
        this.isExoskeleton = type == CellType.BASE
                || type == CellType.LAKE || type == CellType.STONE
                || type == CellType.ORE || type == CellType.IMPENETRABLE;
    }

    /**
     * Returns the x coordinate of the cell.
     * @return the x coordinate of the cell
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the y coordinate of the cell.
     * @return the y coordinate of the cell
     */
    public int getY() {
        return y;
    }

    /**
     * Returns whether the cell is a part of the exoskeleton or not.
     * @return true if the cell is a part of the exoskeleton, false otherwise
     */
    public boolean isExoskeleton() {
        return isExoskeleton;
    }

    /**
     * Returns the type of the cell.
     * @return the type of the cell
     */
    @Override
    public CellType getType() {
        return type;
    }

    /**
     * Returns the intensity of metamorphosis for the cell.
     * @return the intensity of metamorphosis for the cell
     */
    @Override
    public double getMetamorphosisIntensity() {
        return metamorphosisIntensity;
    }

    /**
     * Sets the intensity of metamorphosis of the cell.
     * @param intensity the intensity of metamorphosis of the cell
     */
    @Override
    public void setMetamorphosisIntensity(double intensity) {
        metamorphosisIntensity = intensity;
    }

    /**
     * Returns whether the cell has a water pipe or not.
     * @return true if the cell has a water pipe, false otherwise
     */
    public boolean hasWaterPipe() {
        return pipe != null;
    }

    /**
     * Method to put a water pipe in the cell.
     * @param pipe the water pipe to put in the cell
     * @return true if the pipe has been put, false if a pipe is already in the cell
     */
    public boolean putWaterPipe(WaterPipe pipe) {
        if (hasWaterPipe()) {
            return false;
        }
        this.pipe = pipe;
        return true;
    }

    @Override
    public String toString() {
        return "Cell{" +
            "x=" + x +
            ", y=" + y +
            ", type=" + type +
            ", pipe=" + pipe +
            ", metamorphosisIntensity=" + metamorphosisIntensity +
            ", isExoskeleton=" + isExoskeleton +
        '}';
    }
}
