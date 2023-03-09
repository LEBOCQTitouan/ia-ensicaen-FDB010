package fr.ensicaen.lv223.view.drawable;

public class DrawingMetrics {
    private int ratio;
    private int offsetX;
    private int offsetY;

    public DrawingMetrics(int ratio, int offsetX, int offsetY) {
        this.ratio = ratio;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public int getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        this.ratio = ratio;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }
}
