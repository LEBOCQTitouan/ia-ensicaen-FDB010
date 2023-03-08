package fr.ensicaen.lv223.presenter.vision;

import fr.ensicaen.lv223.model.logic.localisation.RobotMapper;
import fr.ensicaen.lv223.presenter.ViewEffector;
import fr.ensicaen.lv223.presenter.ViewModificator;

public abstract class VisionPresenter extends ViewEffector {
    protected final RobotMapper robotMapper;

    public VisionPresenter(ViewModificator view, RobotMapper robotMapper) {
        super(view);
        this.robotMapper = robotMapper;
    }

    public abstract void updateFog();
}
