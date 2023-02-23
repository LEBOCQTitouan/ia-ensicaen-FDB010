package fr.ensicaen.lv223.util.astar.heuristic;

public interface Heuristic {
    double compute(int startX, int startY, int endX, int endY);
}
