// Tic Tac Toe Terminal Game:
package com.example;

import java.util.Scanner;

/**
 * Main
 */
public class Main {

  private static String[][] matrix = new String[3][3];
  private static boolean exitLoop = false;

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    System.out.println("Press 1 to start the game and 0 to exit!: ");
    int input = reader.nextInt();
    System.out.println();

    while (!exitLoop) {
      if (input == 0) {
        reader.close();
        System.out.println("Game Ended!");
        exitLoop = true;
        return;
      }

      System.out.println("Game Started!🎮");
      logic();
      pattern();
    }


  }

  public static String[][] logic() {
    System.out.println("-------------");
    // assume matrix = [[1,2], [2,3], [3,4]]
    for (int row = 0; row < matrix.length; row++) {

      // for every row, run the col:
      for (int col = 0; col < matrix[row].length; col++) {

        if (matrix[row][col] == "X" || matrix[row][col] == "O") {

          System.out.print("| " + matrix[row][col] + " ");
        } else {
          matrix[row][col] = row + "," + col;
          System.out.print("|" + matrix[row][col]);
        }
      }
      System.out.println("|");

    }
    System.out.println("-------------");
    return matrix;
  }

  public static boolean checkWonOrDraw(String choise) {
    // Horizontal:
    if (matrix[0][0].equals(choise) && matrix[0][1].equals(choise) && matrix[0][2].equals(choise)) {
      System.out.println("Game Ended " + choise + " Won!");

      return true;
    }
    if (matrix[1][0].equals(choise) && matrix[1][1].equals(choise) && matrix[1][2].equals(choise)) {
      System.out.println("Game Ended " + choise + " Won!");

      return true;
    }
    if (matrix[2][0].equals(choise) && matrix[2][1].equals(choise) && matrix[2][2].equals(choise)) {
      System.out.println("Game Ended " + choise + " Won!");

      return true;
    }
    // Vertical:
    if (matrix[0][0].equals(choise) && matrix[1][0].equals(choise) && matrix[2][0].equals(choise)) {
      System.out.println("Game Ended " + choise + " Won!");

      return true;
    }
    if (matrix[0][1].equals(choise) && matrix[1][1].equals(choise) && matrix[2][1].equals(choise)) {
      System.out.println("Game Ended " + choise + " Won!");

      return true;
    }
    if (matrix[0][2].equals(choise) && matrix[1][2].equals(choise) && matrix[2][2].equals(choise)) {
      System.out.println("Game Ended " + choise + " Won!");

      return true;
    }
    // Diagonal:
    if (matrix[0][0].equals(choise) && matrix[1][1].equals(choise) && matrix[2][2].equals(choise)) {
      System.out.println("Game Ended " + choise + " Won!");

      return true;
    }
    if (matrix[0][2].equals(choise) && matrix[1][1].equals(choise) && matrix[2][0].equals(choise)) {
      System.out.println("Game Ended " + choise + " Won!");

      return true;
    }
    return false;
  }

  public static void pattern() {
    Scanner reader = new Scanner(System.in);

    System.out.println("Enter the coordinates where you want to put X in the format (row col): ");
    int r = reader.nextInt();
    int c = reader.nextInt();

    if (r > 2 || c > 2) {
      System.out.println("row or col no. not found!");
      System.out.println();

      System.out.println("Enter the coordinates where you want to put X in the format (row col): ");
      r = reader.nextInt();
      c = reader.nextInt();
    }

    // Checking if X or O exist at r,c or not. if not then add O.
    if (!matrix[r][c].equals("X") && !matrix[r][c].equals("O")) {
      matrix[r][c] = "X";
    } else {
      System.out.println(matrix[r][c] + " already exists at " + r + "," + c);
      System.out.println("Please choose a different position!");
      System.out.println();

      System.out.println("Enter the coordinates where you want to put X in the format (row col): ");
      r = reader.nextInt();
      c = reader.nextInt();

      matrix[r][c] = "X";

    }
    logic();

    // check won or draw
    boolean resX = checkWonOrDraw("X");
    if (resX) {
      exitLoop = true;
      return;
    }

    int countX = 0;
    // Check for Draw:
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {

        if (matrix[row][col] == "X" || matrix[row][col] == "O" && countX != 9) {
          countX = countX + 1;

        }

      }

    }
    if (countX == 9) {
      System.out.println("Match is Draw!");
      exitLoop = true;
      return;

    }


    System.out.println("Enter the coordinates where you want to put O in the format (row col): ");
    r = reader.nextInt();
    c = reader.nextInt();

    if (r > 2 || c > 2) {
      System.out.println("row or col no. not found!");
      System.out.println();

      System.out.println("Enter the coordinates where you want to put O in the format (row col): ");
      r = reader.nextInt();
      c = reader.nextInt();
    }

    // Checking if X or O exist at r,c or not. if not then add O.
    if (!matrix[r][c].equals("X") && !matrix[r][c].equals("O")) {
      matrix[r][c] = "O";
    } else {
      System.out.println(matrix[r][c] + " already exists at " + r + "," + c);
      System.out.println("Please choose a different position!");
      System.out.println();

      System.out.println("Enter the coordinates where you want to put O in the format (row col): ");
      r = reader.nextInt();
      c = reader.nextInt();

      matrix[r][c] = "O";

    }
    logic();

    // Check won or draw
    boolean resO = checkWonOrDraw("O");
    if (resO) {
      exitLoop = true;
      return;
    }

    int count = 0;
    // Check for Draw:
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {

        if (matrix[row][col] == "X" || matrix[row][col] == "O" && count != 9) {
          count = count + 1;

        }

      }

    }

    if (count == 9) {
      System.out.println("Game Ended Match Draw!");
      exitLoop = true;
      return;

    }

  }

}
