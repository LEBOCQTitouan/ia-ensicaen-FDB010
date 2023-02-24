package fr.ensicaen.lv223.model.environment.planet;

import javafx.scene.control.Alert;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.JFuzzyLogic;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class FuzzyLogic {

    private String filename;
    private FunctionBlock functionBlock;

    public FuzzyLogic(){
        this.filename = getClass().getClassLoader().getResource("planet-transformation.fcl").getPath();
        this.functionBlock = loadFisFile();
    }
    private FunctionBlock loadFisFile() {
        FIS fis = FIS.load(this.filename, true);
        if (fis == null) {
            System.err.println("Impossible to charge this file '" + this.filename + "'");
            System.exit(1);
        }
        return fis.getFunctionBlock(null);
    }

    public void execute(double extraction, double emotion, double sampling){
        setVariables(extraction,emotion,sampling);
        this.functionBlock.evaluate();
    }

    public double getValueVariable(String name){
        return this.functionBlock.getVariable(name).getValue();
    }

    private void setVariables(double extraction, double emotion, double sampling) {
        try {
            this.functionBlock.setVariable("extraction", extraction);
            this.functionBlock.setVariable("emotion", emotion);
            this.functionBlock.setVariable("prelevement", sampling);

        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.showAndWait();
        }
    }


    public void viewAllChart(){
        JFuzzyChart.get().chart(functionBlock);
    }


}
