package fr.ensicaen.lv223.presenter.colony;

import fr.ensicaen.lv223.model.agent.robot.Robot;
import fr.ensicaen.lv223.model.logic.localisation.Coordinate;
import fr.ensicaen.lv223.model.logic.localisation.RobotMapper;
import fr.ensicaen.lv223.presenter.ViewEffector;
import fr.ensicaen.lv223.presenter.ViewModificator;
import fr.ensicaen.lv223.view.CellView;

import java.util.List;

/**
 * The colony presenter is responsible for coordinating the interactions between
 * the model ({@link Robot}) and the view ({@link ViewModificator}). It implements
 * the simulation logic and updates the view accordingly. It is responsible for
 * the drawing the robots and to blur non-visible cases.
 */
public class ColonyPresenter extends ViewEffector {
    private final RobotMapper robotMapper;

    public ColonyPresenter(ViewModificator view, RobotMapper robotMapper) {
        super(view);
        this.robotMapper = robotMapper;
    }

    public void drawColony() {
        List<List<CellView>> cellViews = view.getCellView();
        for (Robot robot : robotMapper.getRobots()) {
            Coordinate robotCoordinate = robotMapper.getCoordinate(robot);
            cellViews.get(robotCoordinate.x).get(robotCoordinate.y).getRobotView().setRobotType(robot.type);
            cellViews.get(robotCoordinate.x).get(robotCoordinate.y).getRobotView().setVisible();
        }
    }

    public void updateStatus() {
        view.updateNbRobots(robotMapper.getRobots().size());
    }
}
