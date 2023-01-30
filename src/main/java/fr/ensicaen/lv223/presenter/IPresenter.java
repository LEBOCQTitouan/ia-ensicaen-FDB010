package fr.ensicaen.lv223.presenter;

import fr.ensicaen.lv223.view.CellView;

import java.util.List;

public interface IPresenter {
    void setCellsView(List<List<CellView>> cellsView);

    List<List<CellView>> getCellView();

    int getSceneWidth();

    int getSceneHeight();

    void setSceneHeight(int height);

    void setSceneWidth(int width);

    void draw();

    void updateStatus(int age, String healthStatus, double foodStock,
                      double waterStock, double oreStock, int nbRobots);

    void setOnclick();

    void setChoiceBox();

    void finish();
}