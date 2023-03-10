package fr.ensicaen.lv223.presenter.planet;

import fr.ensicaen.lv223.model.environment.cells.Cell;
import fr.ensicaen.lv223.model.environment.planet.Planet;
import fr.ensicaen.lv223.presenter.IPresenter;
import fr.ensicaen.lv223.view.CellView;

import java.util.ArrayList;
import java.util.List;

public class PlanetPresenter {
    private IPresenter view;
    private final Planet planet;

    public PlanetPresenter(IPresenter view, Planet planet) {
        this.view = view;
        this.planet = planet;
    }

    public void drawPlanet() {
        List<List<Cell>> cells = planet.getCells();
        List<List<CellView>> cellsView = new ArrayList<>();

        for (int i = 0; i < cells.size(); i++) {
            cellsView.add(new ArrayList<>(cells.get(0).size()));
            for (int j = 0; j < cells.get(i).size(); j++) {
                cellsView.get(i).add(
                    new CellView(view.getSceneWidth() / 21.0,
                    view.getSceneHeight() / 21.0,
                    cells.get(i).get(j).getType().name())
                );
            }
        }

        view.setCellsView(cellsView);
        view.draw();
    }

    public void setView(IPresenter view) {
        this.view = view;
    }
}
