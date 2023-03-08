package fr.ensicaen.lv223.model.agent.robot.specials;

import fr.ensicaen.lv223.model.agent.command.Command;
import fr.ensicaen.lv223.model.agent.command.CommandFactory;
import fr.ensicaen.lv223.model.agent.command.CommandType;
import fr.ensicaen.lv223.model.agent.robot.Robot;
import fr.ensicaen.lv223.model.agent.robot.RobotType;
import fr.ensicaen.lv223.model.agent.robot.message.Message;
import fr.ensicaen.lv223.model.logic.agentInterface.PlanetInterface;

import java.util.List;

public class FoodRetriever extends Robot {
    public FoodRetriever(CommandFactory commandFactory, PlanetInterface captors) {
        super(RobotType.FOOD_RETRIEVER, commandFactory, captors);
    }

    @Override
    public List<Command> compute() {
        List<Command> commands = super.compute();
        commands.add(commandFactory.createAction(this, CommandType.MOVE, 1));
        return commands;
    }

    @Override
    public boolean isAvailable(Message m) {
        return false;
    }

}
