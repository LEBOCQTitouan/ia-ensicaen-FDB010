package fr.ensicaen.lv223.model.agent.robot;

import fr.ensicaen.lv223.teams.ProjectTeam;
import fr.ensicaen.lv223.teams.copilot.robots.*;
import fr.ensicaen.lv223.teams.jamesbond.robot.robots.*;

public class RobotFactory {
    public RobotFactory() {}
    public Robot createRobot(RobotType type, ProjectTeam team){
        switch (type) {
            case CARTOGRAPHER -> {
                if (team == ProjectTeam.JAMES_BOND)
                    return new CartographerJB(RobotType.CARTOGRAPHER);
                return new CartographerCopilot(RobotType.CARTOGRAPHER);
            }
            case FOOD_RETRIEVER -> {
                if (team == ProjectTeam.JAMES_BOND)
                    return new FoodRetrieverJB(RobotType.FOOD_RETRIEVER);
                return new FoodRetrieverCopilot(RobotType.FOOD_RETRIEVER);
            }
            case FARMER -> {
                if (team == ProjectTeam.JAMES_BOND)
                    return new FarmerJB(RobotType.FARMER);
                return new FarmerCopilot(RobotType.FARMER);
            }
            case PIPELINE_BUILDER -> {
                if (team == ProjectTeam.JAMES_BOND)
                    return new PipelineBuilderJB(RobotType.PIPELINE_BUILDER);
                return new PipelineBuilderCopilot(RobotType.PIPELINE_BUILDER);
            }
            case ORE_EXTRACTOR -> {
                if (team == ProjectTeam.JAMES_BOND)
                    return new OreExtractorJB(RobotType.ORE_EXTRACTOR);
                return new OreExtractorCopilot(RobotType.ORE_EXTRACTOR);
            }
            case CENTRALIZER -> {
                if (team == ProjectTeam.JAMES_BOND)
                    return new CentralizerJB(RobotType.CENTRALIZER);
                return new CentralizerCopilot(RobotType.CENTRALIZER);
            }
            default -> throw new IllegalArgumentException("Unexpected value: " + type);
        }
    }
}
