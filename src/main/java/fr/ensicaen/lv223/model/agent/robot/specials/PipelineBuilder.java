package fr.ensicaen.lv223.model.agent.robot.specials;

import fr.ensicaen.lv223.model.agent.command.Command;
import fr.ensicaen.lv223.model.agent.command.CommandFactory;
import fr.ensicaen.lv223.model.agent.command.CommandType;
import fr.ensicaen.lv223.model.agent.robot.Robot;
import fr.ensicaen.lv223.model.agent.robot.RobotType;
import fr.ensicaen.lv223.model.agent.robot.message.Message;
import fr.ensicaen.lv223.model.logic.agentInterface.PlanetInterface;

import java.util.List;
import java.util.Random;

public class PipelineBuilder extends Robot {
    public PipelineBuilder(CommandFactory commandFactory, PlanetInterface captors) {
        super(RobotType.PIPELINE_BUILDER, commandFactory, captors);
    }

    @Override
    public List<Command> compute() {
        List<Command> commands = super.compute();
        Random random = new Random();
        commands.add(commandFactory.createAction(this, CommandType.MOVE, 1));
        return commands;
    }

    @Override
    public boolean isAvailable(Message m) {
        return false;
    }
}
