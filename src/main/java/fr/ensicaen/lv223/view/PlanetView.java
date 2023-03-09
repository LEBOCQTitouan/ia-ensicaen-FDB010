package fr.ensicaen.lv223.view;

import fr.ensicaen.lv223.model.environment.planet.state.PlanetHealthStatus;
import fr.ensicaen.lv223.model.logic.Sequencer;
import fr.ensicaen.lv223.presenter.Presenter;
import fr.ensicaen.lv223.presenter.ViewModification;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

/**
 * {@code PlanetView} is a JavaFX class that represents the visual aspect of
 * the planet and its simulation.
 * The class implements the {@code ViewModification} interface and contains methods
 * to interact with the user and display the simulation status.
 * @version 1.0
 * @since 01/12/2023
 */
public class PlanetView implements ViewModification {
    // JavaFX elements
    /**
     * The root of the view.
     */
    @FXML
    private AnchorPane root;
    /**
     * The canvas of the simulation.
     */
    @FXML
    private Canvas simulationCanvas;

    // MVP elements
    /**
     * The presenter of the view.
     */
    private final Presenter presenter;

    public PlanetView(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setNbRobots(int nbRobotsDead, int nbRobotsAlive) {
        // TODO
    }

    @Override
    public void updateHealthStatus(PlanetHealthStatus status) {
        // TODO
    }

    @Override
    public void updateNbDays(int nbDays) {
        // TODO
    }

    @Override
    public void updateStocks(int nbWater, int nbFood, int nbMinerals) {
        // TODO
    }

    @Override
    public void updateSimulationDisplay(Sequencer sequencer) {
        // TODO
    }
}
