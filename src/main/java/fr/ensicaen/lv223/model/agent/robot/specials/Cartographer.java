package fr.ensicaen.lv223.model.agent.robot.specials;

import fr.ensicaen.lv223.model.agent.robot.Robot;
import fr.ensicaen.lv223.model.agent.robot.RobotType;

public abstract class Cartographer extends Robot {
    public Cartographer(RobotType type) {
        super(type);
    }
}
