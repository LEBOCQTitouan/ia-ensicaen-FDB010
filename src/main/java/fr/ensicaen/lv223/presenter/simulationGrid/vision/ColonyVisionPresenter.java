package fr.ensicaen.lv223.presenter.simulationGrid.vision;

import fr.ensicaen.lv223.model.agent.robot.Robot;
import fr.ensicaen.lv223.model.logic.localisation.Coordinate;
import fr.ensicaen.lv223.model.logic.localisation.RobotMapper;
import fr.ensicaen.lv223.presenter.ViewModificator;
import fr.ensicaen.lv223.view.image.CellView;

import java.util.ArrayList;
import java.util.List;

public class ColonyVisionPresenter extends VisionPresenter {
    public ColonyVisionPresenter(ViewModificator view, RobotMapper robotMapper) {
        super(view, robotMapper);
    }

    @Override
    public void updateFog() {
        List<Coordinate> visibleCoordinates = new ArrayList<>();
        for (Robot robot : robotMapper.getRobots()) {
            visibleCoordinates.add(robotMapper.getCoordinate(robot));
        }
        List<Coordinate> newVisibleCoordinates = new ArrayList<>();
        for (Coordinate coordinate : visibleCoordinates) {
            for (Coordinate neighbor : coordinate.getNeighbors(robotMapper.getWidth(), robotMapper.getHeight())) {
                if (!visibleCoordinates.contains(neighbor) && !newVisibleCoordinates.contains(neighbor)) {
                    newVisibleCoordinates.add(neighbor);
                }
            }
        }
        visibleCoordinates.addAll(newVisibleCoordinates);

        List<List<CellView>> cellViews = view.getCellView();
        for (int i = 0; i < cellViews.size(); i++) {
            for (int j = 0; j < cellViews.get(i).size(); j++) {
                if (!visibleCoordinates.contains(new Coordinate(i, j))) {
                    cellViews.get(i).get(j).setBlurred(0);
                } else {
                    cellViews.get(i).get(j).setBlurred(0);
                }
            }
        }
    }
}
