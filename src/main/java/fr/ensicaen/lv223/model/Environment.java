package fr.ensicaen.lv223.model;

import fr.ensicaen.lv223.model.cells.Cell;
import fr.ensicaen.lv223.model.cells.EnvironmentCell;

import java.util.List;

/**
 * The interface {@code Environment} defines methods that must be implemented
 * by any class that wants to represent an environment.
 */
public interface Environment {
    /**
     * Gets the width of the environment.
     * @return the width of the environment
     */
    int getWidth();

    /**
     * Gets the height of the environment.
     * @return the height of the environment
     */
    int getHeight();

    /**
     * Gets the cell located at the specified coordinate.
     * @param c the coordinate of the cell
     * @return the cell located at the specified coordinate
     */
    EnvironmentCell getCell(Coordinate c);

    /**
     * Sets the cell located at the specified coordinate.
     * @param c the coordinate of the cell
     * @param cell the cell to be set at the specified coordinate
     */
    void setCell(Coordinate c, EnvironmentCell cell);

    /**
     * Gets the list of cells from the environment.
     * @return The list of cells
     */
    List<List<Cell>> getCells();
}
