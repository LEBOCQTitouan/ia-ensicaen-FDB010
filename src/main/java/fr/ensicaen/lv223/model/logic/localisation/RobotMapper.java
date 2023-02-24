package fr.ensicaen.lv223.model.logic.localisation;

import fr.ensicaen.lv223.model.agent.robot.Robot;
import fr.ensicaen.lv223.model.environment.planet.Planet;

import java.util.HashMap;
import java.util.List;

public class RobotMapper {
    private final HashMap<Robot, Coordinate> robotMap;
    private final Planet planet;

    public RobotMapper(Planet planet) {
        this.planet = planet;
        robotMap = new HashMap<>();
    }

    public Robot getRobot(int x, int y) {
        for (Robot robot : robotMap.keySet()) {
            Coordinate coordinate = robotMap.get(robot);
            if (coordinate.x == x && coordinate.y == y) {
                return robot;
            }
        }
        return null;
    }

    public Coordinate getCoordiante(Robot robot) {
        return robotMap.get(robot);
    }

    public int getHeigth() {
        return planet.getHeight();
    }

    public int getWidth() {
        return planet.getWidth();
    }

    public List<Robot> getRobots() {
        return robotMap.keySet().stream().toList();
    }
}
