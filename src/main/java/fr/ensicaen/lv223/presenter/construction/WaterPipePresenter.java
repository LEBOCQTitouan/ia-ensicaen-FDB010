package fr.ensicaen.lv223.presenter.construction;

import fr.ensicaen.lv223.model.environment.cells.Cell;
import fr.ensicaen.lv223.model.environment.planet.Planet;
import fr.ensicaen.lv223.presenter.ViewEffector;
import fr.ensicaen.lv223.presenter.ViewModificator;
import fr.ensicaen.lv223.view.image.CellView;

import java.util.List;

public class WaterPipePresenter extends ViewEffector {
    private final Planet planet;
    public WaterPipePresenter(ViewModificator view, Planet planet) {
        super(view);
        this.planet = planet;
    }

    public void updateWaterPipes() {
        List<List<Cell>> cells = planet.getCells();
        List<List<CellView>> cellViews = view.getCellView();
        for (int i = 0; i < cells.size(); i++) {
            for (int j = 0; j < cells.get(i).size(); j++) {
                Cell cell = cells.get(i).get(j);
                if (cell.hasWaterPipe()) {
                    cellViews.get(i).get(j).getWaterPipeView().setVisible();
                }
            }
        }
    }
}
