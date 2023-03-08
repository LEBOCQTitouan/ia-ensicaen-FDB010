package fr.ensicaen.lv223.presenter.simulationGrid.planet;

import fr.ensicaen.lv223.model.environment.cells.Cell;
import fr.ensicaen.lv223.model.environment.planet.Planet;
import fr.ensicaen.lv223.presenter.ViewEffector;
import fr.ensicaen.lv223.presenter.ViewModificator;
import fr.ensicaen.lv223.view.image.CellView;

import java.util.List;

public class PlanetPresenter extends ViewEffector {
    private final Planet planet;

    public PlanetPresenter(ViewModificator view, Planet planet) {
        super(view);
        this.planet = planet;
    }

    public void updatePlanet() {
        List<List<Cell>> cells = planet.getCells();

        for (int i = 0; i < cells.size(); i++) {
            for (int j = 0; j < cells.get(i).size(); j++) {
                Cell cell = cells.get(i).get(j);
                CellView cellView = view.getCellView().get(i).get(j);

                cellView.setSize(Math.max(view.getSceneWidth(), view.getSceneHeight()) / cells.size());
                cellView.setType(cell.getType());
            }
        }
    }
}
