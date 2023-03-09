package fr.ensicaen.lv223.presenter;

import fr.ensicaen.lv223.Main;
import fr.ensicaen.lv223.model.environment.planet.Planet;
import fr.ensicaen.lv223.model.logic.Sequencer;
import fr.ensicaen.lv223.presenter.simulationDisplay.colony.ColonyPresenter;
import fr.ensicaen.lv223.presenter.simulationDisplay.construction.WaterPipePresenter;
import fr.ensicaen.lv223.presenter.simulationDisplay.planet.PlanetPresenter;
import fr.ensicaen.lv223.presenter.simulationDisplay.vision.ColonyVisionPresenter;
import fr.ensicaen.lv223.presenter.simulationDisplay.vision.VisionPresenter;
import fr.ensicaen.lv223.presenter.ui.UIManager;
import fr.ensicaen.lv223.view.PlanetView;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The {@code Presenter} class is responsible for coordinating the interactions
 * between the model ({@link Planet}) and the view ({@link ViewModification}). It
 * implements the simulation logic and updates the view accordingly.
 */
public class Presenter {
    private final ViewModification view;
    private final PlanetPresenter planetPresenter;
    private final ColonyPresenter colonyPresenter;
    private final VisionPresenter visionPresenter;
    private final WaterPipePresenter waterPipePresenter;
    private final UIManager uiManager;
    private final Sequencer sequencer;

    /**
     * Constructs a new {@code Presenter} instance.
     */
    public Presenter(Stage stage) throws Exception {
        this.view = new PlanetView(this);
        this.sequencer = new Sequencer(new Planet());

        this.planetPresenter = new PlanetPresenter(view, sequencer);
        this.colonyPresenter = new ColonyPresenter(view, sequencer);
        this.visionPresenter = new ColonyVisionPresenter(view, sequencer);
        this.waterPipePresenter = new WaterPipePresenter(view, sequencer);
        this.uiManager = new UIManager(view, sequencer);

        loadView(stage);
    }

    private void loadView(Stage stage) throws IOException {
        Scene scene = new Scene(view.getRoot());
        scene.getRoot().setStyle("-fx-font-family: 'sans-serif'");
        // setup stage
        stage.setScene(scene);
        stage.setTitle("Simulation FDB010");
        stage.widthProperty().addListener((observableValue, oldSceneWidth, newSceneWidth) -> {
            updateView();
        });
        stage.heightProperty().addListener((observableValue, oldSceneHeight, newSceneHeight) -> {
            updateView();
        });
        stage.setMaximized(true);
        stage.show();
    }

    /**
     * Simulates the evolution of the planet for a given number of turns.
     * @param nbTurns the number of turns to simulate
     */
    public void simulate(int nbTurns) {
        if (nbTurns < 0) {
            throw new IllegalArgumentException("The number of turns must be positive.");
        }

        // TODO implement the choice to see the turn or not
        if (nbTurns == 0 || sequencer.hasHumansArrived()) {
            updateView();
            return;
        }
        sequencer.step();

        simulate(nbTurns - 1);
    }

    /**
     * Updates the view.
     */
    public void updateView() {
        uiManager.updateView();
        planetPresenter.updateView();
        colonyPresenter.updateView();
        waterPipePresenter.updateView();
        visionPresenter.updateView();
    }
}
