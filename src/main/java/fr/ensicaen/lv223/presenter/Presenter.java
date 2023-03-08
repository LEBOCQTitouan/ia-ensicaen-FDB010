package fr.ensicaen.lv223.presenter;

import fr.ensicaen.lv223.Main;
import fr.ensicaen.lv223.model.environment.planet.Planet;
import fr.ensicaen.lv223.model.logic.Sequencer;
import fr.ensicaen.lv223.presenter.colony.ColonyPresenter;
import fr.ensicaen.lv223.presenter.planet.PlanetPresenter;
import fr.ensicaen.lv223.presenter.vision.ColonyVisionPresenter;
import fr.ensicaen.lv223.presenter.vision.VisionPresenter;
import fr.ensicaen.lv223.view.PlanetView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.Semaphore;

/**
 * The {@code Presenter} class is responsible for coordinating the interactions
 * between the model ({@link Planet}) and the view ({@link ViewModificator}). It
 * implements the simulation logic and updates the view accordingly.
 */
public class Presenter {
    private ViewModificator view;
    private final PlanetPresenter planetPresenter;
    private final ColonyPresenter colonyPresenter;
    private final VisionPresenter visionPresenter;
    private final Sequencer sequencer;
    private final Semaphore semaphore = new Semaphore(1);

    /**
     * Constructs a new {@code Presenter} instance.
     */
    public Presenter(Stage stage) throws IOException {
        view = new PlanetView(this, Main.default_width, Main.default_height);
        loadView(stage);
        view.setOnclick();
        view.setChoicesOfNumberOfSteps();
        view.setChoicesOfVisionMode();
        view.setChoicesOfAgents();

        sequencer = new Sequencer(new Planet());
        planetPresenter = new PlanetPresenter(view, sequencer.planet);
        colonyPresenter = new ColonyPresenter(view, sequencer.mapper);
        visionPresenter = new ColonyVisionPresenter(view, sequencer.mapper);

        updateView();
    }

    private void loadView(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/board_view.fxml"));
        fxmlLoader.setController(view);

        Scene scene = new Scene(fxmlLoader.load(), Main.default_width, Main.default_height);
        scene.getRoot().setStyle("-fx-font-family: 'sans-serif'");
        stage.setScene(scene);
        stage.setTitle("Simulation FDB010");

        scene.getRoot().setStyle("-fx-font-family: 'sans-serif'");
        scene.widthProperty().addListener((observableValue, oldSceneWidth, newSceneWidth) -> {
            updateView();
        });
        scene.heightProperty().addListener((observableValue, oldSceneHeight, newSceneHeight) -> {
            view.setSceneHeight(newSceneHeight.intValue());
            view.setSceneWidth(newSceneHeight.intValue());

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

    public void updateView() {
        while (!semaphore.tryAcquire());
        try {
            drawPlanet();
            updateUI();
        } finally {
            semaphore.release();
        }
    }

    private void updateUI() {
        // TODO
    }

    private void drawPlanet(){
        planetPresenter.drawPlanet();
        colonyPresenter.drawColony();
        visionPresenter.createVisionFog();
    }
}
