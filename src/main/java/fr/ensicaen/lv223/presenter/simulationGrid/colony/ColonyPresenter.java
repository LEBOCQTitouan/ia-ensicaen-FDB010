package fr.ensicaen.lv223.presenter.simulationGrid.colony;

import fr.ensicaen.lv223.model.agent.robot.Robot;
import fr.ensicaen.lv223.model.logic.localisation.Coordinate;
import fr.ensicaen.lv223.model.logic.localisation.RobotMapper;
import fr.ensicaen.lv223.presenter.ViewEffector;
import fr.ensicaen.lv223.presenter.ViewModificator;
import fr.ensicaen.lv223.view.image.CellView;

import java.util.ArrayList;
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

    public void updateColony() {
        List<List<CellView>> cellViews = view.getCellView();
        List<Coordinate> robotCoordinates = new ArrayList<>();
        for (Robot robot : robotMapper.getRobots()) {
            robotCoordinates.add(robotMapper.getCoordinate(robot));
        }
        for (int i = 0; i < cellViews.size(); i++) {
            List<CellView> cellViewRow = cellViews.get(i);
            for (int j = 0; j < cellViewRow.size(); j++) {
                CellView cellView = cellViewRow.get(j);
                Coordinate coordinate = new Coordinate(i, j);
                if (robotCoordinates.contains(coordinate)) {
                    cellView.getRobotView().setRobotType(robotMapper.getRobot(coordinate).type);
                    cellView.getRobotView().setVisible();
                } else {
                    cellView.getRobotView().hide();
                }
            }
        }
    }

    public void updateStatus() {
        view.updateNbRobots(robotMapper.getRobots().size());
    }
}
