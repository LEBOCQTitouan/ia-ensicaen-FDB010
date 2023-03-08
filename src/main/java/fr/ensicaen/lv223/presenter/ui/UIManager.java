package fr.ensicaen.lv223.presenter.ui;

import fr.ensicaen.lv223.model.logic.Sequencer;
import fr.ensicaen.lv223.presenter.ViewModificator;

public class UIManager {
    private ViewModificator view;
    private Sequencer sequencer;

    public UIManager(ViewModificator view, Sequencer sequencer) {
        this.view = view;
        this.sequencer = sequencer;
    }

    public void update() {
        view.updateAge(sequencer.getDays());
        view.updateNbRobots(sequencer.mapper.getRobots().size());
        view.updateStock(sequencer.planet.getStockFood(), sequencer.planet.getStockWater(), sequencer.planet.getStockMineral());
        view.updateHealthStatus(sequencer.planet.getCurrentHealthStatus());
    }
}
