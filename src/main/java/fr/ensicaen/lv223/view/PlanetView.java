package fr.ensicaen.lv223.view;

import fr.ensicaen.lv223.model.environment.planet.state.PlanetHealthStatus;
import fr.ensicaen.lv223.model.logic.Sequencer;
import fr.ensicaen.lv223.presenter.Presenter;
import fr.ensicaen.lv223.presenter.ViewModification;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;

public class PlanetView implements ViewModification {
    private Canvas canvas;
    private Presenter presenter;

    public PlanetView(Presenter presenter) {
        this.presenter = presenter;
        this.canvas = new Canvas();
    }

    @Override
    public void setNbRobots(int nbRobotsDead, int nbRobotsAlive) {

    }

    @Override
    public void updateHealthStatus(PlanetHealthStatus status) {

    }

    @Override
    public void updateNbDays(int nbDays) {

    }

    @Override
    public void updateStocks(int nbWater, int nbFood, int nbMinerals) {

    }

    @Override
    public void updateSimulationDisplay(Sequencer sequencer) {

    }

    @Override
    public Parent getRoot() {
        HBox root = new HBox();
        root.getChildren().add(canvas);
        return root;
    }
}
