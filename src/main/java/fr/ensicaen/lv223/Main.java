package fr.ensicaen.lv223;

import fr.ensicaen.lv223.presenter.Presenter;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * {@code Main} class extends the {@link Application} class of JavaFX to
 * create the GUI application for our simulation.
 * It sets up the scene, size, style and behavior of the application.
 */
public class Main extends Application {
    /**
     * The default width and height of the application.
     */
    public static final int default_width = 600;
    /**
     * The default width and height of the application.
     */
    public static final int default_height = 600;

    /**
     * Override the start method of {@link Application} class to set up the GUI
     * elements and behaviors.
     *
     * @param stage the stage object used to show the application
     * @throws IOException when there is an error in loading the FXML file
     */
    @Override
    public void start(Stage stage) throws IOException {
        Presenter presenter = new Presenter(stage);
    }

    /**
     * Main method to launch the application.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
}
