package fr.ensicaen.lv223;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import fr.ensicaen.lv223.presenter.IPresenter;
import fr.ensicaen.lv223.presenter.Presenter;
import fr.ensicaen.lv223.view.PlanetView;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        int x;
        int y;
        Presenter presenter;
        IPresenter view;
        FXMLLoader fxmlLoader;
        Scene scene;

        x = 500;
        y = 500;
        presenter = new Presenter();
        view = new PlanetView(presenter, x, y);
        presenter.setView(view);

        fxmlLoader = new FXMLLoader(Main.class.getResource("/board_view.fxml"));
        fxmlLoader.setController(view);

        scene = new Scene(fxmlLoader.load(), x, y);
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        stage.setScene(scene);

        view.setOnclick();
        view.setChoiceBox();
        scene.getRoot().setStyle("-fx-font-family: 'serif'");
        presenter.drawPlanet();

        scene.widthProperty().addListener((observableValue, oldSceneWidth, newSceneWidth) -> {
            presenter.drawPlanet();
            presenter.updateRobotPositionOnView();
        });
        scene.heightProperty().addListener((observableValue, oldSceneHeight, newSceneHeight) -> {
            view.setSceneHeight(newSceneHeight.intValue());
            view.setSceneWidth(newSceneHeight.intValue());

            presenter.drawPlanet();
            presenter.updateRobotPositionOnView();
        });

        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}