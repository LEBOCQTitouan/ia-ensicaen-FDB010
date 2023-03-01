package fr.ensicaen.lv223.model.environment.planet.reaction;

import fr.ensicaen.lv223.model.environment.EnvironmentCell;
import fr.ensicaen.lv223.model.environment.cells.Cell;
import fr.ensicaen.lv223.model.environment.planet.Planet;
import fr.ensicaen.lv223.model.logic.localisation.Coordinate;
import fr.ensicaen.lv223.util.Util;
import javafx.scene.input.ScrollEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class ShockWave {
    private Stack<List<EnvironmentCell>> steps;
    private int amplitude;
    private int speed;
    private Planet planet;

    public ShockWave(Planet planet, Coordinate coordinate, int amplitude, int speed) {
        this.amplitude = amplitude;
        this.speed = speed;
        this.planet = planet;
        steps = new Stack<>();
        // TODO : create the shockwave steps
        List<Coordinate> visited = new ArrayList<>();
        List<Coordinate> current = new ArrayList<>();

        current.add(coordinate);
        propagateShockWave(planet, amplitude + 1, visited, current);
    }

    public void update() {
        for (int i = 0; i < speed; i++) {
            if (!steps.isEmpty()) {
                List<EnvironmentCell> cells = steps.pop();
                // TODO : update the cells
            }
        }
    }

    public static Optional<ShockWave> createShockWave(Planet planet, Coordinate coord, ExtractionType type) {
        switch (type) {
            case SMALL:
                return Optional.of(new ShockWave(planet, coord, 2, 2));
            case MEDIUM:
                return Optional.of(new ShockWave(planet, coord, 3, 2));
            case GREAT:
                return Optional.of(new ShockWave(planet, coord, 4, 3));
        }
        return Optional.empty();
    }

    public static Optional<ShockWave> createShockWave(Planet planet, Coordinate coord, SamplingType type) {
        switch (type) {
            case NEGLIGIBLE:
            case SMALL:
            case MEDIUM:
                return Optional.of(new ShockWave(planet, coord, 1, 1));
            case GREAT:
                return Optional.of(new ShockWave(planet, coord, 2, 2));
        }
        return Optional.empty();
    }

    public boolean isFinished() {
        return steps.isEmpty();
    }

    private void addToSteps(List<Coordinate> coordinates, Planet planet) {
        List<EnvironmentCell> cells = new ArrayList<>();
        for (Coordinate c : coordinates) {
            cells.add(planet.getCell(c));
        }
        steps.add(cells);
    }

    private void propagateShockWave(Planet planet, int n, List<Coordinate> visited, List<Coordinate> visit) {
        if (n < 0) {
            return;
        }

        addToSteps(visit, planet);
        List<Coordinate> toVisit = new ArrayList<>();
        for (Coordinate c : visit) {
            visited.add(c);
            for (Coordinate neighbor : Util.getNeighbors(c, planet.getWidth(), planet.getHeight())) {
                if (!visited.contains(neighbor)) {
                    toVisit.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        propagateShockWave(planet, n - 1, visited, toVisit);
    }
}
