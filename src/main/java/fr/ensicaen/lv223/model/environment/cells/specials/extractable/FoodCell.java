package fr.ensicaen.lv223.model.environment.cells.specials.extractable;

import fr.ensicaen.lv223.model.environment.cells.CellType;

/**
 * The class {@code FoodCell} extends the class {@link ExtractableCell} and
 * represents a cell that contains some food in the simulation environment.
 */
public class FoodCell extends ExtractableCell {
    public FoodCell(int x, int y, double intensity, double quantity) {
        super(x, y, CellType.FOOD, intensity, quantity);
    }
}
