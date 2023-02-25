package fr.ensicaen.lv223.model.logic.agentInterface;

import fr.ensicaen.lv223.model.agent.robot.Robot;

/**
 * The {@code RobotInterface} class is an interface that represents a way to
 * interact with the robot. For instance, in the case of the planet the robot interface represent
 * what the planet can see and what it can do about this specific robot.
 */
public class RobotInterface implements AgentInterface {
    private final Robot robot;

    public RobotInterface(Robot robot, int x, int y) {
        this.robot = robot;
    }
}
