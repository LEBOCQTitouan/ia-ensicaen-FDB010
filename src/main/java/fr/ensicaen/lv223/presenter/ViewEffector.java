package fr.ensicaen.lv223.presenter;

import fr.ensicaen.lv223.model.logic.Sequencer;

public abstract class ViewEffector {
    protected final ViewModification view;
    protected final Sequencer sequencer;

    public ViewEffector(ViewModification view, Sequencer sequencer) {
        this.view = view;
        this.sequencer = sequencer;
    }

    public abstract void updateView();
}
