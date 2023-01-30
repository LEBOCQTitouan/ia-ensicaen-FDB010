package fr.ensicaen.lv223.model;

import java.util.ArrayList;
import java.util.List;

import fr.ensicaen.lv223.model.cells.Cell;
import fr.ensicaen.lv223.model.cells.CellFactory;
import fr.ensicaen.lv223.model.cells.EnvironmentCell;
import fr.ensicaen.lv223.planetloader.JsonLoader;
import fr.ensicaen.lv223.planetloader.PlanetData;
import fr.ensicaen.lv223.planetloader.PlanetLoader;

public class Planet implements Environment {
    private final List<List<Cell>> cells;
    private int age;

    public Planet() {
        PlanetLoader planetLoader = new JsonLoader("/json/planet.json");
        PlanetData[] planetData = planetLoader.load();

        age = 0;

        cells = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            cells.add(new ArrayList<>());
            for (int j = 0; j < 21; j++) {
                cells.get(i).add(CellFactory.factory("IMPENETRABLE", -1, i, j));
            }
        }

        for (PlanetData planetDatum : planetData) {
            for (int j = 0; j < planetDatum.getCellPos().length; j++) {
                int x = planetDatum.getCellPos()[j].getX();
                int y = planetDatum.getCellPos()[j].getY();

                cells.get(x).set(y, CellFactory.factory(planetDatum.getType(),
                        -1,
                        planetDatum.getCellPos()[j].getX(),
                        planetDatum.getCellPos()[j].getY()));

            }
        }
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public int getAge() {
        return age;
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
