package fr.ensicaen.lv223.model.environment.planet.behavior.metamorphosis;

import fr.ensicaen.lv223.model.environment.cells.Cell;
import fr.ensicaen.lv223.model.environment.planet.Planet;

public abstract class Metamorphosis {
    private Cell affectedCell;
    private Planet planet;
    public abstract void transform();
}
