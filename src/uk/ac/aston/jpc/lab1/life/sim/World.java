package uk.ac.aston.jpc.lab1.life.sim;

public class World {
    private int nRows;
    private int nColumns;
    private Cell[] cells;

    public World(int rows, int columns) {
        this.nRows = rows;
        this.nColumns = columns;
        this.cells = new Cell[rows * columns];

        int iCell = 0;
        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                cells[iCell] = new Cell(this, row, column);
                iCell++;
            }
        }
    }

    //String... is a vararg
    public World(String... rows)
    {
        //String... returns an Array of Strings
        this(rows.length, rows[0].length());
        int iCell = 0;
        for(int row = 0; row < this.nRows; row++) {
            for (int column = 0; column < this.nColumns; column++) {
                char characterAtRowAndColumn = rows[row].charAt(column);
                if(characterAtRowAndColumn != ' ') {
                    cells[iCell].setAlive(true);
                }
                iCell++;
            }
        }
    }

    public World(World world) {
        this(world.getRows(), world.getColumns());
    }

    public Cell getCell(int row, int column) {
        return cells[row * nColumns + column];
    }

    public int getColumns() {
        return nColumns;
    }

    public int getRows() {
        return nRows;
    }

    public World nextGeneration() {
        World newWorld = new World(this);
        for(int row = 0; row < this.nRows; row++) {
            for(int column = 0; column < this.nColumns; column++) {
                Cell oldCell = this.getCell(row, column);
                Cell newCell = newWorld.getCell(row, column);
                int aliveNeighboursOfOldCell = oldCell.countAliveNeighbours();

                if(oldCell.isAlive()) {
                    if(aliveNeighboursOfOldCell == 2 || aliveNeighboursOfOldCell == 3) {
                        newCell.setAlive(true);
                    }
                } else {
                    if(aliveNeighboursOfOldCell == 3) {
                        newCell.setAlive(true);
                    }
                }
            }
        }
        return newWorld;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iColumn = 0;
        for(Cell cell: cells) {
            sb.append(cell.toString());
            iColumn++;
            if(iColumn == nColumns) {
                iColumn = 0;
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
