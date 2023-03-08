package fr.ensicaen.lv223.model.agent.robot.specials;

import fr.ensicaen.lv223.model.agent.command.CommandFactory;
import fr.ensicaen.lv223.model.agent.robot.Robot;
import fr.ensicaen.lv223.model.agent.robot.RobotType;
import fr.ensicaen.lv223.model.agent.robot.message.Message;
import fr.ensicaen.lv223.model.logic.agentInterface.PlanetInterface;

public class Centralizer extends Robot {
    public Centralizer(CommandFactory commandFactory, PlanetInterface captors) {
        super(RobotType.CENTRALIZER, commandFactory, captors);
    }

    @Override
    public boolean isAvailable(Message m) {
        return false;
    }
}
