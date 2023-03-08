package fr.ensicaen.lv223.model.agent.command.implementations.edition;

import fr.ensicaen.lv223.model.agent.command.Command;
import fr.ensicaen.lv223.model.agent.robot.Robot;
import fr.ensicaen.lv223.model.environment.construction.WaterPipe;
import fr.ensicaen.lv223.model.environment.planet.Planet;
import fr.ensicaen.lv223.model.logic.localisation.Coordinate;
import fr.ensicaen.lv223.model.logic.localisation.RobotMapper;

public class InstallPipeCommand extends Command {
    private final Planet planet;
    private WaterPipe pipe;

    public InstallPipeCommand(Robot robot, RobotMapper robotMapper, int value, Planet planet) {
        super(robot, robotMapper, value);
        this.planet = planet;
    }

    @Override
    public void apply() {
        // TODO water pipe apply
    }

    @Override
    public void unapply() {
        // TODO water pipe unapply
    }
}
