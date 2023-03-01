package fr.ensicaen.lv223.model.environment.construction;

import java.util.ArrayList;
import java.util.List;

public class WaterPipe {

    public static final List<WaterPipe> waterPipes = new ArrayList<>();
    private int x;
    private int y;

    public WaterPipe(int x, int y) {
        this.x = x;
        this.y = y;

        waterPipes.add(this);
    }
}
