package fr.ensicaen.lv223.presenter.simulationDisplay.vision;

import fr.ensicaen.lv223.model.logic.Sequencer;
import fr.ensicaen.lv223.presenter.ViewEffector;
import fr.ensicaen.lv223.presenter.ViewModification;

public abstract class VisionPresenter extends ViewEffector {
    public VisionPresenter(ViewModification view, Sequencer sequencer) {
        super(view, sequencer);
    }

    @Override
    public void updateView() {
        updateFog();
    }

    public abstract void updateFog();
}
