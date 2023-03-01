package fr.ensicaen.lv223.model.environment.planet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import fr.ensicaen.lv223.model.agent.Agent;
import fr.ensicaen.lv223.model.environment.cells.Cell;
import fr.ensicaen.lv223.model.environment.cells.CellFactory;
import fr.ensicaen.lv223.model.environment.Environment;
import fr.ensicaen.lv223.model.environment.EnvironmentCell;
import fr.ensicaen.lv223.model.environment.cells.specials.ExtractableCell;
import fr.ensicaen.lv223.model.logic.localisation.Coordinate;
import fr.ensicaen.lv223.model.environment.cells.CellType;
import fr.ensicaen.lv223.util.loader.planetloader.JsonLoader;
import fr.ensicaen.lv223.util.loader.planetloader.PlanetData;
import fr.ensicaen.lv223.util.loader.planetloader.PlanetLoader;

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

    private final FuzzyLogic fuzzyLogic;

    private PlanetEmotion currentEmotion;
    private Dispatcher dispatcher;

    private PlanetHealthStatus currentHealthStatus;

    private double stockFood;
    private double stockMineral;
    private double stockWater;
    public Planet() {
        this.ageSinceTheArrivalOfTheColony = 0;
        Random r = new Random(System.currentTimeMillis());

        this.currentEmotion = PlanetEmotion.HAPPY;
        this.currentHealthStatus = PlanetHealthStatus.GOOD;

        this.cells = new ArrayList<>();
        this.listAgents = new ArrayList<>();
        this.fuzzyLogic = new FuzzyLogic();
        this.dispatcher = new Dispatcher(this.cells);

        PlanetLoader planetLoader = new JsonLoader("/json/planet.json");
        PlanetData[] planetData = planetLoader.load();


        for (int i = 0; i < 21; i++) {
            this.cells.add(new ArrayList<>());
            for (int j = 0; j < 21; j++) {
                Optional<Cell> o = CellFactory.factory("IMPENETRABLE", -1, i,
                        j,0);
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
                        planetDatum.getCellPos()[j].getY(),0);

                this.cells.get(x).set(y, o.get());
            }
        }
        this.stockFood      = Math.floor((100.0 - nbCaseType(CellType.FOOD))*r.nextDouble() +nbCaseType(CellType.FOOD));
        this.stockMineral   = Math.floor((100.0 - nbCaseType(CellType.ORE))*r.nextDouble()  +nbCaseType(CellType.ORE));
        this.stockWater     = Math.floor((100.0 - nbCaseType(CellType.LAKE))*r.nextDouble() +nbCaseType(CellType.LAKE));
        dispatcher.dispatched(CellType.FOOD,this.stockFood);
        dispatcher.dispatched(CellType.ORE,this.stockFood);
        dispatcher.dispatched(CellType.LAKE,this.stockFood);

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
    public EnvironmentCell getCell( int x, int y ) {
        return null;
    }

    @Override
    public void setCell(Coordinate c, EnvironmentCell cell) {
        this.getCells().get(c.getX()).set(c.getY(), (Cell) cell);
    }

    public void play(){
        if (!listAgents.isEmpty()){
            for(Agent ag : listAgents){
                ag.compute();
            }
        }
    }


    public PlanetEmotion getCurrentEmotion() {
        return currentEmotion;
    }

    public PlanetHealthStatus getCurrentHealthStatus() {
        return currentHealthStatus;
    }

    public double getStockFood() {
        return stockFood;
    }

    public double getStockMineral() {
        return stockMineral;
    }

    public double getStockWater() {
        return stockWater;
    }

    public List<Agent> getListAgents() {
        return listAgents;
    }
    public double nbCaseType(CellType cellType){
        double cpt = 0;
        for(List<Cell> list : this.cells){
            for(Cell a : list){
                if(a.getType() == cellType){
                    cpt++;
                }
            }
        }
        return cpt;
    }



}
