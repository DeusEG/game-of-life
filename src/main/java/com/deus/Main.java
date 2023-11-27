package com.deus;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[][] testGrid = {{"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                                {"-", "-", "-", "*", "*", "-", "-", "-", "-", "-"},
                                {"-", "-", "-", "-", "*", "-", "-", "-", "-", "-"},
                                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}};

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! is a GameOfLife. " + "\n" +
                "Please, input number:" + "\n" +
                "1 - template life grid" + "\n" +
                "2 - u want input grid yourself");
        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1: {
 //               Game game = new Game(3, 3, testGrid);
                Game game = new Game(5, 10, testGrid);
                game.showGrid(game.getGenGrid());
                game.showNextGenGrid();
                break;
            }
            case 2: {
                System.out.println("Input number of rows:");
                int row = scanner.nextInt();
                System.out.println("Input number of columns:");
                int col = scanner.nextInt();
                String[][] genGrid = new String[row][col];
                Game game = new Game(row, col, genGrid);
                game.inputGenGrid();
                game.showGrid(game.getGenGrid());
                game.showNextGenGrid();
                break;
            }
            default: {
                System.out.println("Неверный ввод");
                break;
            }
        }
    }
}
