package fr.ensicaen.lv223.model.cells;

import fr.ensicaen.lv223.model.CellType;

public abstract class ExtractableCell extends Cell {
    protected double quantity;
    protected final double initialQuantity;

    protected ExtractableCell(int x, int y, CellType type, double intensity,
                       double quantity) {
        super(x, y, type, intensity);
        this.quantity = quantity;
        this.initialQuantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getInitialQuantity() {
        return initialQuantity;
    }

    public double getPercentageExtraction() {
        return 100 - (quantity / initialQuantity) * 100;
    }
}
