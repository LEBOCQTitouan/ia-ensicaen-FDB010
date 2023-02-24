package fr.ensicaen.lv223.model.logic;

import fr.ensicaen.lv223.model.agent.command.Command;
import fr.ensicaen.lv223.model.agent.robot.Robot;
import fr.ensicaen.lv223.model.environment.planet.Planet;

import java.util.ArrayList;
import java.util.List;

public class Sequencer {
    public final Planet planet;
    public final List<Robot> robots;

    public Sequencer(Planet planet, List<Robot> robots) {
        this.planet = planet;
        this.robots = robots;
    }

    public void step() {
        ArrayList<Command> commands = new ArrayList<>();
        for (Robot robot : robots) {
            robot.compute();
        }
        for (Robot robot : robots) {
            for (Command command : robot.compute()) {
                commands.add(command);
            }
        }
        for (Command command: commands) {
            command.apply();
        }
    }
}
