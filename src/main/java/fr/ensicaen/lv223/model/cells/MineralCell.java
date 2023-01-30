package fr.ensicaen.lv223.model.cells;

import fr.ensicaen.lv223.model.CellType;

public class MineralCell extends ExtractableCell {
    public MineralCell(int x, int y, CellType type, double intensity, double quantity) {
        super(x, y, type, intensity, quantity);
    }
}
