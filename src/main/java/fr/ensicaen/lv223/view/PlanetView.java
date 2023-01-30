package fr.ensicaen.lv223.view;

import java.util.ArrayList;
import java.util.List;

import fr.ensicaen.lv223.presenter.IPresenter;
import fr.ensicaen.lv223.presenter.Presenter;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class PlanetView implements IPresenter {
    @FXML
    private GridPane _grid;

    @FXML
    private Button _button;

    @FXML
    private Button _list;

    @FXML
    private ChoiceBox<String> _choice;

    @FXML
    private ChoiceBox<String> _tolerance;

    @FXML
    private Label _age;

    @FXML
    private Label _healthStatus;

    @FXML
    private Label _foodStock;

    @FXML
    private Label _waterStock;

    @FXML
    private Label _oreStock;

    @FXML
    private Label _robots;

    private int sceneWidth;
    private int sceneHeight;
    private final Presenter presenter;
    private List<List<CellView>> cellsView = null;

    /** It allows to choose the number of steps of the simulation */
    private final Observable items = FXCollections.observableArrayList("1",
            "10", "100");

    private final Observable tolerances = FXCollections.observableArrayList(
            "Hostile", "Adaptative", "Tolérante");

    public PlanetView(Presenter presenter, int x, int y) {
        this.presenter = presenter;
        this.sceneWidth = x;
        this.sceneHeight = y;
    }

    public int getSceneWidth() {
        return sceneWidth;
    }

    public int getSceneHeight() {
        return sceneHeight;
    }

    @Override
    public void setSceneWidth(int sceneWidth) {
        this.sceneWidth = sceneWidth;
    }

    @Override
    public void setSceneHeight(int sceneHeight) {
        this.sceneHeight = sceneHeight;
    }

    public void setOnclick() {
        _button.setOnAction(event -> presenter.simulate(Integer.parseInt(_choice.getValue())));
        _tolerance.setOnAction(event -> {
            switch (_tolerance.getValue()) {
                case "Hostile":
                    presenter.setTolerance(1.0);
                    break;
                case "Adaptative":
                    presenter.setTolerance(1.5);
                    break;
                case "Tolérante":
                    presenter.setTolerance(2.0);
                    break;
                default:
                    break;
            }
        });
    }

    public void setChoiceBox() {
        _choice.setItems((ObservableList<String>) items);
        _choice.setValue("1");
        _tolerance.setItems((ObservableList<String>) tolerances);
        _tolerance.setValue("Tolérante");
    }

    @Override
    public void finish() {
        _button.setDisable(true);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText("Fin de la simulation !");
        alert.showAndWait();
    }

    @Override
    public void draw() {
        _grid.getChildren().clear();
        for (int i = 0; i < cellsView.size(); i++) {
            for (int j = 0; j < cellsView.get(i).size(); j++) {
                _grid.add(cellsView.get(i).get(j).getPane(), i, j);
            }
        }
    }

    @Override
    public void setCellsView(List<List<CellView>> cellsView) {
        this.cellsView = cellsView;
    }

    @Override
    public List<List<CellView>> getCellView() {
        return cellsView;
    }

    public void updateStatus(int age, String healthStatus, double foodStock,
                             double waterStock, double oreStock, int nbRobots) {
        _age.setText("Âge de la planète : " + age + " an(s)");
        _healthStatus.setText("Santé de la planète : " + healthStatus);
        _foodStock.setText("Stock de nourriture : " + foodStock);
        _waterStock.setText("Stock d'eau : " + waterStock);
        _oreStock.setText("Stock de minerai : " + oreStock);
        _robots.setText("Nombre de robots : " + nbRobots);
    }
}
