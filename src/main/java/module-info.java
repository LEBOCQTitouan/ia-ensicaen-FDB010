module fr.ensicaen.lv223 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jackson.databind;
    requires jFuzzyLogic;
    requires java.logging;

    opens fr.ensicaen.lv223 to javafx.fxml;
    exports fr.ensicaen.lv223;
    opens fr.ensicaen.lv223.planetloader to jackson.databind;
    opens fr.ensicaen.lv223.view to javafx.fxml;
}