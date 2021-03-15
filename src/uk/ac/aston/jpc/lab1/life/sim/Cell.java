package uk.ac.aston.jpc.lab1.life.sim;
import java.util.ArrayList;

/**
 * Represents a cell in Conway's Game of Life. The cell may be alive or dead,
 * and it will have a certain set of neighbours in the {@link World} it belongs
 * to.
 *
 * @author Lewis Mitchell
 * @since 1.0
 */

public class Cell {
    private boolean isAlive;
    private World world;
    private int column;
    private int row;

    public Cell(World world, int row, int column) {
        this.world = world;
        this.row = row;
        this.column = column;
    }

    public World getWorld() {
        return world;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public ArrayList<Cell> getNeighbours() {
        ArrayList<Cell> neighbours = new ArrayList<>();
        // There is a cell above and to the left of this cell.
        if(row > 0 && column > 0) {
            neighbours.add(world.getCell(row - 1, column - 1));
        }
        // There is a cell above this cell.
        if(row > 0) {
            neighbours.add(world.getCell(row - 1, column));
        }
        // There is a cell above and to the right of this cell.
        if(row > 0 && column + 1 < world.getColumns()) {
            neighbours.add(world.getCell(row - 1, column + 1));
        }

        // There is a cell to the left of this cell.
        if(column > 0) {
            neighbours.add(world.getCell(row, column - 1));
        }
        // There is a cell to the right of this cell.
        if(column + 1 < world.getColumns()) {
            neighbours.add(world.getCell(row, column + 1));
        }

        // There is a cell below and to the left of this cell.
        if(row + 1 < world.getRows() && column > 0) {
            neighbours.add(world.getCell(row + 1, column - 1));
        }
        // There is a cell below this cell.
        if(row + 1 < world.getRows()) {
            neighbours.add(world.getCell(row + 1, column));
        }
        // There is a cell below and to the right of this cell.
        if(row + 1 < world.getRows() && column + 1 < world.getColumns()) {
            neighbours.add(world.getCell(row + 1, column + 1));
        }
        return neighbours;
    }

    public int countAliveNeighbours() {
        int aliveCount = 0;
        for(Cell neighbour: getNeighbours()) {
            if(neighbour.isAlive) {
                aliveCount += 1;
            }
        }
        return aliveCount;
    }

    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public String toString() {
        return isAlive ? "x" : " ";
    }
}
