package fr.ensicaen.lv223.model.agent.robot.specials;

import fr.ensicaen.lv223.model.agent.command.CommandFactory;
import fr.ensicaen.lv223.model.agent.robot.Robot;
import fr.ensicaen.lv223.model.agent.robot.RobotType;

public abstract class Centralizer extends Robot {
    public Centralizer(RobotType type, CommandFactory commandFactory) {
        super(type, commandFactory);
    }
}
