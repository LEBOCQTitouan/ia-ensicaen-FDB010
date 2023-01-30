package fr.ensicaen.lv223.model.cells;

import fr.ensicaen.lv223.model.CellType;

public class LakeCell extends ExtractableCell {
    public LakeCell(int x, int y, CellType type, double intensity, double quantity) {
        super(x, y, type, intensity, quantity);
    }
}
