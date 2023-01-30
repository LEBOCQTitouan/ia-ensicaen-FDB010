package fr.ensicaen.lv223.model.cells;

import fr.ensicaen.lv223.model.CellType;

public class Cell implements EnvironmentCell, Comparable {
    private final int x;
    private final int y;
    private final CellType type;
    private final double intensityOfMetamorphosis;
    private int intensityOfWave;
    private final boolean isExoskeleton;

    public Cell(int x, int y, CellType type, double intensity) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.intensityOfMetamorphosis = intensity;
        this.intensityOfWave = 0;
        this.isExoskeleton = type == CellType.BASE || type == CellType.LAKE || type == CellType.STONE || type == CellType.ORE || type == CellType.IMPENETRABLE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean hasBeenWaved() {
        return intensityOfWave != 0;
    }

    public int getIntensityOfWave() {
        return intensityOfWave;
    }

    public void setIntensityOfWave(int value) {
        this.intensityOfWave = value;
    }

    public boolean isExoskeleton() {
        return isExoskeleton;
    }

    public String toString() {
        return "" + intensityOfWave;
    }

    @Override
    public CellType getType() {
        return type;
    }
    
    @Override
    public double getIntensity() {
        return intensityOfMetamorphosis;
    }

    /**
     * Compares the intensity of waves between two cells.
     *
     * @param o Another cell
     * @return 1 if intensity is higher, -1 if intensity is lower and 0
     * otherwise
     */
    public int compareTo(Object o) {
        Cell other = (Cell) o;
        return Integer.compare(intensityOfWave, other.getIntensityOfWave());
    }
}
