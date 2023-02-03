package fr.ensicaen.lv223.model.cells;

import fr.ensicaen.lv223.model.CellType;

/**
 * The {@code ExtractableCell} is a subclass of Cell that represents an
 * extractable resource in the simulation (food, water and mineral). It adds
 * two member variables:
 * - quantity, which represents the amount of the resource that is still
 * available, and
 * - initialQuantity, which represents the total amount of the resource that
 * was available at the start of the simulation.
 * The class provides methods to retrieve the quantity and initialQuantity as
 * well as a method to calculate the percentage of the resource that has been
 * extracted. The constructor for this class sets its member variables and
 * calls the constructor of its superclass.
 */
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
