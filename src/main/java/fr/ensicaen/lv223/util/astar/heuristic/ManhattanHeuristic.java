package fr.ensicaen.lv223.util.astar.heuristic;

public class ManhattanHeuristic implements Heuristic {
    @Override
    public double compute(int startX, int startY, int endX, int endY) {
        // TODO more accurate heuristic
        return Math.abs(startX - endX) + Math.abs(startY - endY);
    }
}
