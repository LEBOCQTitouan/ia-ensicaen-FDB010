package fr.ensicaen.lv223.presenter.simulationDisplay.colony;

import fr.ensicaen.lv223.model.agent.robot.Robot;
import fr.ensicaen.lv223.model.logic.Sequencer;
import fr.ensicaen.lv223.presenter.ViewEffector;
import fr.ensicaen.lv223.presenter.ViewModification;

/**
 * The colony presenter is responsible for coordinating the interactions between
 * the model ({@link Robot}) and the view ({@link ViewModification}). It implements
 * the simulation logic and updates the view accordingly. It is responsible for
 * the drawing the robots and to blur non-visible cases.
 */
public class ColonyPresenter extends ViewEffector {
    public ColonyPresenter(ViewModification view, Sequencer sequencer) {
        super(view, sequencer);
    }

    @Override
    public void updateView() {

    }
}
