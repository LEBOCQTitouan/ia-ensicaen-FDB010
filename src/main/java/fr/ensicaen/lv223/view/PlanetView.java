package fr.ensicaen.lv223.view;

import fr.ensicaen.lv223.model.environment.planet.state.PlanetHealthStatus;
import fr.ensicaen.lv223.presenter.ViewModificator;
import fr.ensicaen.lv223.presenter.Presenter;
import fr.ensicaen.lv223.presenter.util.NumberOfSteps;
import fr.ensicaen.lv223.presenter.util.VisionMode;
import fr.ensicaen.lv223.view.image.CellView;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.List;

/**
 * {@code PlanetView} is a JavaFX class that represents the visual aspect of
 * the planet and its simulation.
 * The class implements the {@code ViewModificator} interface and contains methods
 * to interact with the user and display the simulation status.
 * @version 1.0
 * @since 01/12/2023
 */
public class PlanetView implements ViewModificator {
    /**
     * The {@code gridOfPlanet} is a {@link GridPane} object used to display
     * the cells of the planet simulation.
     */
    @FXML
    private GridPane planetGrid;

    /**
     * The {@code buttonToStartOneOrMoreSteps} is a {@link Button} object used
     * to initiate a certain number of steps for the simulation.
     */
    @FXML
    private Button stepButton;

    /**
     * The {@code choiceOfNumberOfSteps} is a {@link ChoiceBox} object used to
     * choose the number of steps when pushing the simulation button (1, 10
     * or 100 steps).
     */
    @FXML
    private ChoiceBox<NumberOfSteps> choiceOfNumberOfSteps;

    /**
     * The {@code choiceOfVisionMode} is a {@link ChoiceBox} object used to
     * choose the vision mode of the simulation (default, ...).
     */
    @FXML
    private ChoiceBox<VisionMode> choiceOfVisionMode;

    /**
     * The {@code buttonToStartOneOrMoreSteps} is a {@link Button} object used
     * to initiate a certain number of steps for the simulation.
     */
    @FXML
    private ChoiceBox<String> agentsChoiceBox;

    /**
     * The label to display the age of the planet since the arrival of the
     * colony
     */
    @FXML
    private Label ageSinceTheArrivalOfTheColony;

    /** The label to display the health status of the planet */
    @FXML
    private Label healthStatusOfThePlanet;

    /** The label to display the food stock of the colony */
    @FXML
    private Label foodStockOfTheColony;

    /** The label to display the water stock of the colony */
    @FXML
    private Label waterStockOfTheColony;

    /** The label to display the ore stock of the colony */
    @FXML
    private Label oreStockOfTheColony;

    /** The label to display the current number of robots of the colony */
    @FXML
    private Label currentNumberOfRobots;

    /** The width of the scene */
    private int sceneWidth;

    /** The height of the scene */
    private int sceneHeight;

    /** A reference to the presenter of the simulation */
    private final Presenter presenter;

    /**
     * The 2D list of {@code CellView} objects to represent the cells within the
     * simulation grid
     */
    private List<List<CellView>> cellsView = null;

    /**
     * An Observable list of items to select the number of steps of the simulation
     */
    private final Observable nbTurnsItems = FXCollections.observableArrayList(NumberOfSteps.values());

    /**
     * An Observable list of items to select the vision mode of the simulation
     */
    private final Observable visionModeItems = FXCollections.observableArrayList(VisionMode.values());

    /**
     * An Observable list of items to select the agents of the simulation
     */
    private final Observable agentsItems = FXCollections.observableArrayList("ALL");

    /**
     * Constructs a new {@code PlanetView} object with a reference to the
     * presenter and the width and height of the scene.
     * @param presenter a reference to the presenter of the simulation
     * @param width the width of the scene
     * @param height the height of the scene
     */
    public PlanetView(Presenter presenter, int width, int height) {
        this.presenter = presenter;
        this.sceneWidth = width;
        this.sceneHeight = height;
    }

    /**
     * Gets the width of the scene.
     * @return the width of the scene
     */
    public int getSceneWidth() {
        return sceneWidth;
    }

    /**
     * Gets the height of the scene.
     * @return the height of the scene
     */
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

    /**
     * Sets the action when the user clicks on the button to simulate.
     */
    public void setOnclick() {
        stepButton.setOnAction(
            (event) -> {
                presenter.simulate(choiceOfNumberOfSteps.getValue().getValue());
            }
        );
    }

    /**
     * Sets the items of the choice boxe to select the number of steps of the
     * simulation.
     */
    public void setChoicesOfNumberOfSteps() {
        choiceOfNumberOfSteps.getItems().setAll(NumberOfSteps.values());
        choiceOfNumberOfSteps.setValue(NumberOfSteps.ONE);
    }

    /**
     * Sets the items of the choice boxe to select the vision mode of the
     * simulation.
     */
    public void setChoicesOfVisionMode() {
        choiceOfVisionMode.getItems().setAll(VisionMode.values());
        choiceOfVisionMode.setValue(VisionMode.DEFAULT);
    }

    /**
     * Sets the items of the choice boxe to select the agents of the
     * simulation.
     */
    public void setChoicesOfAgents() {
        agentsChoiceBox.setDisable(true);
        agentsChoiceBox.setValue("ALL");
    }

    @Override
    public void draw() {
        planetGrid.getChildren().clear();
        for (int i = 0; i < cellsView.size(); i++) {
            for (int j = 0; j < cellsView.get(i).size(); j++) {
                for (Node node : cellsView.get(i).get(j).getNodes()) {
                    planetGrid.add(node, j, i);
                }
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

    @Override
    public void updateAge(int age) {
        ageSinceTheArrivalOfTheColony.setText("Âge de la planète : " + age + " jour(s)");
    }

    @Override
    public void updateStock(double foodStock, double waterStock, double oreStock) {
        foodStockOfTheColony.setText("Food Stock : " + foodStock);
        waterStockOfTheColony.setText("Water-Stock : " + waterStock + " Km3");
        oreStockOfTheColony.setText("Ore Stock : " + oreStock);
    }

    @Override
    public void updateNbRobots(int nbRobots) {
        currentNumberOfRobots.setText("Nombre de robots : " + nbRobots);
    }

    @Override
    public void updateHealthStatus(PlanetHealthStatus healthStatus) {
        healthStatusOfThePlanet.setText("État de santé de la planète : " + healthStatus);
    }
}
