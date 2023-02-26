package fr.ensicaen.lv223.model.environment.planet.behavior;

import fr.ensicaen.lv223.model.environment.cells.Cell;

import java.util.List;

/**
 * Transform the case into other case
 */
public class Transformer {
    private final List<List<Cell>> cells;
    public Transformer(List<List<Cell>> cells){
        this.cells = cells;
    }

    public void transform(Cell currenCell) {
        Cell temp = currenCell.transformation();
        for(List<Cell> list: this.cells){
            if(list.contains(currenCell)){
                list.set(list.indexOf(currenCell), temp);
            }
        }
    }

    public void transform(int x, int y) {
        for(List<Cell> list: this.cells){
            list.forEach(cell -> {
                if(cell.getX() == x && cell.getY() == y){
                    Cell temp = cell.transformation();
                    list.set(list.indexOf(cell), temp);
                }
            });
        }
    }
}
