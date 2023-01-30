package fr.ensicaen.lv223.presenter;

import java.util.ArrayList;
import java.util.List;

import fr.ensicaen.lv223.model.*;
import fr.ensicaen.lv223.model.cells.Cell;
import fr.ensicaen.lv223.view.CellView;
import javafx.scene.effect.GaussianBlur;

public class Presenter {
    private final Planet planet;

    private IPresenter view;

    private double tolerance;

    public Presenter() {
        // TO COMPLETE BY INSTANTIATING ALL YOU NEED
        planet = new Planet();
    }

    public void setView(IPresenter view) {
        this.view = view;
    }

    public void drawPlanet() {
        List<List<Cell>> cells = planet.getCells();
        List<List<CellView>> cellsView = new ArrayList<>();
        GaussianBlur blur = new GaussianBlur(60.0);

        for (int i = 0; i < cells.size(); i++) {
            cellsView.add(new ArrayList<>(cells.get(0).size()));
            for (int j = 0; j < cells.get(i).size(); j++) {
                cellsView.get(i).add(new CellView(view.getSceneWidth() / 21.0,
                        view.getSceneHeight() / 21.0,
                        cells.get(i).get(j).getType().name()));
                cellsView.get(i).get(j).getRobotView().hide();
                cellsView.get(i).get(j).getPane().setEffect(blur);
            }
        }

        GaussianBlur noBlur = new GaussianBlur(0.0);
        view.setCellsView(cellsView);
        view.draw();
    }

    public void simulate(int nbTurns) {
        boolean terminated = false;
        int i = 0;

        while (!terminated && i < nbTurns) {
            if (planet.getAge() == 8 * 365 || noMoreLivingRobots()) {
                view.finish();
                terminated = true;
            } else {
                simulateOneTurn();
                i++;
            }
        }
    }

    /**
     * {@code @todo} TO COMPLETE
     */
    public void simulateOneTurn() {
        // TO COMPLETE
        drawPlanet();
        updateRobotPositionOnView();
    }

    /**
     * {@code @todo} TO COMPLETE
     */
    public void updateRobotPositionOnView() {
    }

    public void setTolerance(double d) {
        this.tolerance = d;
    }

    /**
     * {@code @todo} TO COMPLETE
     * @return true if all robots died, false otherwise.
     */
    public boolean noMoreLivingRobots() {
        return false;
    }
}
