import java.util.Scanner;
import java.util.Random;


public class Game {

    Scanner scanner = new Scanner(System.in);
//    Random random = new Random();
    private int row;
    private int col;
    private String[][] genGrid;
    private static final String aliveCell = "*";
//    private static final String deadCell = "-";

    public String[][] getGenGrid() {
        return genGrid;
    }

    public Game(int row, int col, String[][] genGrid) {
        this.row = row;
        this.col = col;
        this.genGrid = genGrid;
    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }


    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    // show u first gen grid
    public void showGrid(String[][] genGrid) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(genGrid[i][j]);
            }
            System.out.println(" ");
        }
    }

    // input next gen grid
    public void inputGenGrid() {
        row = getRow();
        col = getCol();
        System.out.println("Create your first gen, enter line by line");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                genGrid[i][j] = scanner.next();
            }
        }
    }

    // prints next generation table
    public void showNextGenGrid() {
        String cell;
        row = getRow();
        col = getCol();
        String[][] nextGenGrid = new String[row][col];
        boolean isAlive;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cell = getStatusOfCell(i, j);
                nextGenGrid[i][j] = cell;
            }
        }
        showGrid(nextGenGrid);
    }

    // checks cells around the current cell
    public String getStatusOfCell (int row, int col) {
        String cell = "!";
        int countAliveCells = 0;
        //checking the upper left position
        if (row == 0 && col == 0) {
            if (aliveCell.equals(genGrid[row + 1][col + 1])) {
                countAliveCells += 1;
            }
			if (aliveCell.equals(genGrid[row + 1][col])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row][col + 1])) {
                countAliveCells += 1;
            }
            //  checking the upper right position
        } else if (row == 0 && col == getCol() - 1) {
            if (aliveCell.equals(genGrid[row][col - 1])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row + 1][col])) {
                countAliveCells += 1;
            }
			if (aliveCell.equals(genGrid[row + 1][col - 1])) {
                countAliveCells += 1;
            }
            // checking the down left position
        } else if (row == getRow() - 1 && col == 0) {
			if (aliveCell.equals(genGrid[row][col + 1])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row - 1][col])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row - 1][col + 1])) {
                countAliveCells += 1;
            }
            // checking the down right position
        } else if (row == getRow() - 1 && col == getCol() - 1) {
			if (aliveCell.equals(genGrid[row][col - 1])) {
                countAliveCells += 1;
            }
			if (aliveCell.equals(genGrid[row - 1][col - 1])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row - 1][col])) {
                countAliveCells += 1;
            }
            // checking first row position
        } else if (row == 0) {
			if (aliveCell.equals(genGrid[row][col - 1])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row][col + 1])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row + 1][col + 1])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row + 1][col])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row + 1][col - 1])) {
                countAliveCells += 1;
            }
            // checking first col position
        } else if (col == 0) {       
            if (aliveCell.equals(genGrid[row - 1][col])) {
                countAliveCells += 1;
            }
			if (aliveCell.equals(genGrid[row][col + 1])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row - 1][col + 1])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row + 1][col + 1])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row + 1][col])) {
                countAliveCells += 1;
            }
            // checking last row position
        } else if (row == getRow() - 1) {
            if (aliveCell.equals(genGrid[row - 1][col - 1])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row - 1][col + 1])) {
                countAliveCells += 1;
            }
			if (aliveCell.equals(genGrid[row][col + 1])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row][col - 1])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row - 1][col])) {
                countAliveCells += 1;
            }
            // checking last col position
        } else if (col == getCol() - 1) {
            if (aliveCell.equals(genGrid[row + 1][col - 1])) {
                countAliveCells += 1;
            }
			if (aliveCell.equals(genGrid[row + 1][col])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row - 1][col])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row][col - 1])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row - 1][col - 1])) {
                countAliveCells += 1;
            }
        } else {
            if (aliveCell.equals(genGrid[row - 1][col + 1])) {
                countAliveCells += 1;
            }
			if (aliveCell.equals(genGrid[row][col + 1])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row + 1][col - 1])) {
                countAliveCells += 1;
            }
			if (aliveCell.equals(genGrid[row - 1][col - 1])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row - 1][col])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row][col - 1])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row + 1][col])) {
                countAliveCells += 1;
            }
            if (aliveCell.equals(genGrid[row + 1][col + 1])) {
                countAliveCells += 1;
            }
        }
        // conditions for cells
        if (countAliveCells < 2) {
            cell = "-";
        } else if (countAliveCells == 2) {
            cell = genGrid[row][col];
        } else if (countAliveCells == 3) {
            cell = "*";
        } else if (countAliveCells > 3) {
            cell = "-";
        }

        return cell;
    }
}

