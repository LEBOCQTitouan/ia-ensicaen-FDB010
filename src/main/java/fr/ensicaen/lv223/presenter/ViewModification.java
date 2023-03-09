package fr.ensicaen.lv223.presenter;

import fr.ensicaen.lv223.model.environment.planet.state.PlanetHealthStatus;
import fr.ensicaen.lv223.model.logic.Sequencer;

/**
 * {@code ViewModification} interface specifies the methods that must be
 * implemented by the presenter of the view in a Model-View-Presenter (MVP)
 * architecture.
 */
public interface ViewModification {
    /**
     * Update the display of the number of Robots.
     * @param nbRobotsDead number of dead robots
     * @param nbRobotsAlive number of alive robots
     */
    void setNbRobots(int nbRobotsDead, int nbRobotsAlive);

    /**
     * Update the display of the planet health status.
     * @param status the new health status
     */
    void updateHealthStatus(PlanetHealthStatus status);

    /**
     * Update the display of the number of days since the beginning of the simulation.
     * @param nbDays the number of days
     */
    void updateNbDays(int nbDays);

    /**
     * Update the display of the stocks of the planet.
     * @param nbWater number of water on the planet
     * @param nbFood number of food on the planet
     * @param nbMinerals number of minerals on the planet
     */
    void updateStocks(int nbWater, int nbFood, int nbMinerals);

    /**
     * Update the display of the cells of the planet.
     * @param sequencer the sequencer of the simulation
     */
    void updateSimulationDisplay(Sequencer sequencer);
}