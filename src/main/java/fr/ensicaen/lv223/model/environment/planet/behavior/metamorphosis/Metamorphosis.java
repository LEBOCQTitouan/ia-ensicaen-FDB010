package fr.ensicaen.lv223.model.environment.planet.behavior.metamorphosis;

import fr.ensicaen.lv223.model.environment.cells.Cell;
import fr.ensicaen.lv223.model.environment.cells.CellFactory;
import fr.ensicaen.lv223.model.environment.cells.CellType;
import fr.ensicaen.lv223.model.environment.planet.Planet;
import fr.ensicaen.lv223.model.logic.localisation.Coordinate;

import java.util.Random;

public abstract class Metamorphosis {
    protected Cell affectedCell;
    protected Planet planet;
    public abstract void transform();

    public Metamorphosis(Cell affectedCell, Planet planet) {
        this.affectedCell = affectedCell;
        this.planet = planet;
    }

    protected void setNewCell(CellType type) {
        Coordinate coordinate = new Coordinate(affectedCell.getX(), affectedCell.getY());
        Cell cell = CellFactory.factory(type, affectedCell.getMetamorphosisIntensity(), coordinate.x, coordinate.y).get();
        planet.setCell(coordinate, cell);
    }

    protected int getRandomInt() {
        Random random = new Random();
        return random.nextInt(101);
    }

    protected boolean getRandBool() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
