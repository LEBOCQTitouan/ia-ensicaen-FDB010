package fr.ensicaen.lv223.model.logic.localisation;

import java.util.ArrayList;
import java.util.List;

public class Coordinate {
    public final int x;
    public final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Coordinate that = (Coordinate) obj;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Coordinate(x, y);
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Coordinate> getNeighbors(int width, int height) {
        ArrayList<Coordinate> neighbors = new ArrayList<>();
        if (x > 0) {
            neighbors.add(new Coordinate(x - 1, y));
            if (y > 0) {
                neighbors.add(new Coordinate(x - 1, y - 1));
            }
            if (y < width - 1) {
                neighbors.add(new Coordinate(x - 1, y + 1));
            }
        }
        if (x < height - 1) {
            neighbors.add(new Coordinate(x + 1, y));
            if (y > 0) {
                neighbors.add(new Coordinate(x + 1, y - 1));
            }
            if (y < width - 1) {
                neighbors.add(new Coordinate(x + 1, y + 1));
            }
        }
        if (y > 0) {
            neighbors.add(new Coordinate(x, y - 1));
        }
        if (y < width - 1) {
            neighbors.add(new Coordinate(x, y + 1));
        }
        return neighbors;
    }
}
