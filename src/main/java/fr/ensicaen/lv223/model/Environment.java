package fr.ensicaen.lv223.model;

import fr.ensicaen.lv223.model.cells.EnvironmentCell;

public interface Environment {
    int getWidth();

    int getHeight();

    EnvironmentCell getCell(Coordinate c);

    void setCell(Coordinate c, EnvironmentCell cell);
}
