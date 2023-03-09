package fr.ensicaen.lv223.model.environment.cells.specials.extractable;

import fr.ensicaen.lv223.model.environment.cells.CellType;

/**
 * The {@code OreCell} class extends the {@link ExtractableCell} class and
 * represents a cell with some minerals that can be extracted.
 */
 public class OreCell extends ExtractableCell {
    public OreCell(int x, int y, double intensity, double quantity) {
        super(x, y, CellType.ORE, intensity, quantity);
    }
}
