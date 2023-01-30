package fr.ensicaen.lv223.model.cells;

import fr.ensicaen.lv223.model.CellType;

public interface EnvironmentCell {
    CellType getType();

    double getIntensity();
}
