package fr.ensicaen.lv223.model.agent.robot;

import fr.ensicaen.lv223.model.agent.command.CommandFactory;
import fr.ensicaen.lv223.model.agent.robot.specials.*;
import fr.ensicaen.lv223.model.environment.planet.Planet;
import fr.ensicaen.lv223.model.logic.agentInterface.PlanetInterface;
import fr.ensicaen.lv223.model.logic.localisation.RobotMapper;

public class RobotFactory {
    private final CommandFactory factory;
    private final Planet planet;
    private final RobotMapper robotMapper;

    public RobotFactory(CommandFactory factory, Planet planet, RobotMapper robotMapper) {
        this.factory = factory;
        this.planet = planet;
        this.robotMapper = robotMapper;
    }

    public Robot createRobot(RobotType type){
        switch (type) {
            case CARTOGRAPHER -> {
                return new Cartographer(factory, new PlanetInterface(planet, robotMapper));
            }
            case FOOD_RETRIEVER -> {
                return new FoodRetriever(factory, new PlanetInterface(planet, robotMapper));
            }
            case FARMER -> {
                return new Farmer(factory, new PlanetInterface(planet, robotMapper));
            }
            case PIPELINE_BUILDER -> {
                return new PipelineBuilder(factory, new PlanetInterface(planet, robotMapper));
            }
            case ORE_EXTRACTOR -> {
                return new OreExtractor(factory, new PlanetInterface(planet, robotMapper));
            }
            case CENTRALIZER -> {
                return new Centralizer(factory, new PlanetInterface(planet, robotMapper));
            }
            default -> throw new IllegalArgumentException("Unexpected value: " + type);
        }
    }
}
