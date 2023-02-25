package fr.ensicaen.lv223.model.agent.command;

import fr.ensicaen.lv223.model.environment.planet.Planet;
import fr.ensicaen.lv223.model.logic.localisation.RobotMapper;

public class CommandFactory {
    private final Planet planet;
    private final RobotMapper robotMapper;

    public CommandFactory(Planet planet, RobotMapper robotMapper) {
        this.planet = planet;
        this.robotMapper = robotMapper;
    }

    public Command createCommand(CommandType type) {
        return null;
    }
}
