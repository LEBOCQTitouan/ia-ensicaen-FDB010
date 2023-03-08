package fr.ensicaen.lv223.model.environment;

import fr.ensicaen.lv223.model.environment.cells.CellType;
import fr.ensicaen.lv223.model.environment.construction.WaterPipe;

/**
 * The {@code EnvironmentCell} interface represents a cell in an environment.
 */
public interface EnvironmentCell {
    /**
     * Returns the type of this cell.
     * @return the type of this cell
     */
    CellType getType();

    /**
     * Returns the intensity of metamorphosis for this cell.
     * @return the intensity of metamorphosis for this cell
     */
    double getMetamorphosisIntensity();

    /**
     * Sets the intensity of metamorphosis for this cell.
     * @param intensity the intensity of metamorphosis for this cell
     */
    void setMetamorphosisIntensity(double intensity);

    /**
     * Returns whether this cell has a water pipe or not.
     * @return true if this cell has a water pipe, false otherwise
     */
    public boolean hasWaterPipe();

    /**
     * Method to put a water pipe in this cell.
     * @param pipe the water pipe to put in this cell
     * @return true if the pipe has been put, false if a pipe is already in this cell
     */
    public boolean putWaterPipe(WaterPipe pipe);
}
