package fr.ensicaen.lv223.model.environment.cells.specials.extractable;

import fr.ensicaen.lv223.model.environment.cells.CellType;

/**
 * This class extends the {@link ExtractableCell} class and represents a
 * cell containing water in the environment (e.g. a lake).
 */
public class LakeCell extends ExtractableCell {
    public LakeCell(int x, int y, double intensity, double quantity) {
        super(x, y, CellType.LAKE, intensity, quantity);
    }
}
