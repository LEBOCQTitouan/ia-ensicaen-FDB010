package fr.ensicaen.lv223.model.environment.planet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.ensicaen.lv223.model.agent.Agent;
import fr.ensicaen.lv223.model.environment.cells.Cell;
import fr.ensicaen.lv223.model.environment.cells.CellFactory;
import fr.ensicaen.lv223.model.environment.Environment;
import fr.ensicaen.lv223.model.environment.EnvironmentCell;
import fr.ensicaen.lv223.model.environment.Coordinate;
import fr.ensicaen.lv223.model.environment.cells.CellType;
import fr.ensicaen.lv223.planetloader.JsonLoader;
import fr.ensicaen.lv223.planetloader.PlanetData;
import fr.ensicaen.lv223.planetloader.PlanetLoader;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

/**
 * The {@code Planet} class implements the {@link Environment} interface and
 * represents a 2-dimensional grid of cells in our simulation.
 * The planet is created using data loaded from a JSON file, which is passed
 * to a {@link PlanetLoader} object. This data is then processed to create a
 * two-dimensional grid of cells using the {@link CellFactory} class. The grid
 * is stored as a list of lists of {@link Cell} objects.
 * The age of the planet since the arrival of the colony can be accessed,
 * such as the width and height of the grid. Additionally, individual cells can
 * be retrieved or set using a {@link Coordinate} object to specify their
 * position in the grid.
 */


/**
 * toDo emotions with planet
 * Generate around the Centralisator cases with probalities random
 */
public class Planet implements Environment {
    private final List<List<Cell>> cells;
    private int ageSinceTheArrivalOfTheColony;

    private List<Agent> listAgents;

    private FuzzyLogic fuzzyLogic;

    private Transformer transformer;

    private PlanetEmotion currentEmotion;
    public Planet() {
        this.ageSinceTheArrivalOfTheColony = 0;
        this.currentEmotion = PlanetEmotion.HAPPY;
        this.cells = new ArrayList<>();
        this.listAgents = new ArrayList<>();
        this.fuzzyLogic = new FuzzyLogic();
        this.transformer = new Transformer(this.cells);
        this.fuzzyLogic.viewAllChart();

        PlanetLoader planetLoader = new JsonLoader("/json/planet.json");
        PlanetData[] planetData = planetLoader.load();


        for (int i = 0; i < 21; i++) {
            this.cells.add(new ArrayList<>());
            for (int j = 0; j < 21; j++) {
                Optional<Cell> o = CellFactory.factory("IMPENETRABLE", -1, i,
                        j);
                this.cells.get(i).add(o.get());
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

                this.cells.get(x).set(y, o.get());
            }
        }
        typeCells();
    }

    @Override
    public List<List<Cell>> getCells() {
        return cells;
    }

    @Override
    public void setEmotion( PlanetEmotion planetEmotion ) {
        this.currentEmotion = planetEmotion;
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

    public void play(){
        if (!listAgents.isEmpty()){
            for(Agent ag : listAgents){
                if(!ag.equals(null)){
                    ag.compute();
                }
            }
        }
    }

    public void typeCells(){
        for(List<Cell> list : this.cells){
            for(Cell c : list){
                if(c.getType() == CellType.FOOD){
                    System.out.println(c.getIntensity());
                }

            }
        }
    }
}
