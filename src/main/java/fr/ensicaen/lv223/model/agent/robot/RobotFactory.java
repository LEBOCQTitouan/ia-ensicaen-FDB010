package fr.ensicaen.lv223.model.agent.robot;

import fr.ensicaen.lv223.model.agent.command.CommandFactory;
import fr.ensicaen.lv223.teams.ProjectTeam;
import fr.ensicaen.lv223.teams.copilot.robots.*;
import fr.ensicaen.lv223.teams.jamesbond.robot.robots.*;

public class RobotFactory {
    private CommandFactory factory;
    public RobotFactory(CommandFactory factory) {
        this.factory = factory;
    }
    public Robot createRobot(RobotType type, ProjectTeam team){
        switch (type) {
            case CARTOGRAPHER -> {
                if (team == ProjectTeam.JAMES_BOND)
                    return new CartographerJB(RobotType.CARTOGRAPHER, factory);
                return new CartographerCopilot(RobotType.CARTOGRAPHER, factory);
            }
            case FOOD_RETRIEVER -> {
                if (team == ProjectTeam.JAMES_BOND)
                    return new FoodRetrieverJB(RobotType.FOOD_RETRIEVER, factory);
                return new FoodRetrieverCopilot(RobotType.FOOD_RETRIEVER, factory);
            }
            case FARMER -> {
                if (team == ProjectTeam.JAMES_BOND)
                    return new FarmerJB(RobotType.FARMER, factory);
                return new FarmerCopilot(RobotType.FARMER, factory);
            }
            case PIPELINE_BUILDER -> {
                if (team == ProjectTeam.JAMES_BOND)
                    return new PipelineBuilderJB(RobotType.PIPELINE_BUILDER, factory);
                return new PipelineBuilderCopilot(RobotType.PIPELINE_BUILDER, factory);
            }
            case ORE_EXTRACTOR -> {
                if (team == ProjectTeam.JAMES_BOND)
                    return new OreExtractorJB(RobotType.ORE_EXTRACTOR, factory);
                return new OreExtractorCopilot(RobotType.ORE_EXTRACTOR, factory);
            }
            case CENTRALIZER -> {
                if (team == ProjectTeam.JAMES_BOND)
                    return new CentralizerJB(RobotType.CENTRALIZER, factory);
                return new CentralizerCopilot(RobotType.CENTRALIZER, factory);
            }
            default -> throw new IllegalArgumentException("Unexpected value: " + type);
        }
    }
}
