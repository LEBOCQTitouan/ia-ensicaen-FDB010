package fr.ensicaen.lv223.model.logic.agentInterface;

import fr.ensicaen.lv223.model.environment.planet.Planet;

/**
 * The {@code PlanetInterface} class is an interface that represents a way to
 * interact with the planet. For instance, in the case of a robot the planet interface represent
 * what the robot can see and what it can do.
 */
public class PlanetInterface implements AgentInterface {
    private static PlanetInterface instance;

    public static PlanetInterface getInstance(Planet planet) {
        if (instance == null) {
            instance = new PlanetInterface(planet);
        }
        return instance;
    }
    private final Planet planet;

    private PlanetInterface(Planet planet) {
        this.planet = planet;
    }
}
