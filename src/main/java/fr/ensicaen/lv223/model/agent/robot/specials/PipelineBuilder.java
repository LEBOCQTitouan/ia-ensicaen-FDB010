package fr.ensicaen.lv223.model.agent.robot.specials;

import fr.ensicaen.lv223.model.agent.command.CommandFactory;
import fr.ensicaen.lv223.model.agent.robot.Robot;
import fr.ensicaen.lv223.model.agent.robot.RobotType;

public abstract class PipelineBuilder extends Robot {
    public PipelineBuilder(RobotType type, CommandFactory commandFactory) {
        super(type, commandFactory);
    }
}
