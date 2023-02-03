package fr.ensicaen.lv223.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.ensicaen.lv223.model.cells.Cell;
import fr.ensicaen.lv223.model.cells.CellFactory;
import fr.ensicaen.lv223.model.cells.EnvironmentCell;
import fr.ensicaen.lv223.planetloader.JsonLoader;
import fr.ensicaen.lv223.planetloader.PlanetData;
import fr.ensicaen.lv223.planetloader.PlanetLoader;

/**
 * The {@code Planet} class implements the Environment interface and represents
 * a 2-dimensional grid of cells in our simulation.
 * The planet is constructed using data loaded from a JSON file, which is passed
 * to a PlanetLoader object. This data is then processed to create a grid of
 * cells using the CellFactory class. The grid is stored as a list of lists of
 * Cell objects.
 * The age of the planet can be accessed and the width and height of the grid
 * can be queried. Additionally, individual cells can be retrieved or set using
 * a Coordinate object to specify their position in the grid.
 */
public class Planet implements Environment {
    private final List<List<Cell>> cells;
    private int ageSinceTheArrivalOfTheColony;

    public Planet() {
        PlanetLoader planetLoader = new JsonLoader("/json/planet.json");
        PlanetData[] planetData = planetLoader.load();

        ageSinceTheArrivalOfTheColony = 0;

        cells = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            cells.add(new ArrayList<>());
            for (int j = 0; j < 21; j++) {
                Optional<Cell> o = CellFactory.factory("IMPENETRABLE", -1, i,
                        j);
                cells.get(i).add(o.get());
            }
        }

        for (PlanetData planetDatum : planetData) {
            for (int j = 0; j < planetDatum.getCellPos().length; j++) {
                int x = planetDatum.getCellPos()[j].getX();
                int y = planetDatum.getCellPos()[j].getY();
                Optional<Cell> o = CellFactory.factory(planetDatum.getType(),
                        -1,
                        planetDatum.getCellPos()[j].getX(),
                        planetDatum.getCellPos()[j].getY());

                cells.get(x).set(y, o.get());
            }
        }
    }

    @Override
    public List<List<Cell>> getCells() {
        return cells;
    }

    public int getAgeSinceTheArrivalOfTheColony() {
        return ageSinceTheArrivalOfTheColony;
    }

    @Override
    public int getWidth() {
        return cells.size();
    }

    @Override
    public int getHeight() {
        return cells.get(0).size();
    }

    @Override
    public EnvironmentCell getCell(Coordinate c) {
        return cells.get(c.getX()).get(c.getY());
    }

    @Override
    public void setCell(Coordinate c, EnvironmentCell cell) {
        this.getCells().get(c.getX()).set(c.getY(), (Cell) cell);
    }
}
