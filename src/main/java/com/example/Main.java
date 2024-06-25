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
    System.out.println("Game Started!🎮");
    logic();

    while (!exitLoop) {
      if (input == 0) {
        reader.close();
        return;
      }
      System.out.println();
      pattern();
    }


  }

  static void logic() {
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
  }

  static void pattern() {
    Scanner reader = new Scanner(System.in);



    System.out.println("Enter the coordinates where you want to put X in the format (row col): ");
    int r = reader.nextInt();
    int c = reader.nextInt();

    if (r > 2 || c > 2) {
      System.out.println("row or col no. not found!");
      return;
    }

    matrix[r][c] = "X";
    logic();
    // Horizontal:
    if (matrix[0][0].equals("X") && matrix[0][1].equals("X") && matrix[0][2].equals("X")) {
      System.out.println("Game Ended X Won!");
      exitLoop = true;
      return;
    }
    if (matrix[1][0].equals("X") && matrix[1][1].equals("X") && matrix[1][2].equals("X")) {
      System.out.println("Game Ended X Won!");
      exitLoop = true;
      return;
    }
    if (matrix[2][0].equals("X") && matrix[2][1].equals("X") && matrix[2][2].equals("X")) {
      System.out.println("Game Ended X Won!");
      exitLoop = true;
      return;
    }
    // Vertical:
    if (matrix[0][0].equals("X") && matrix[1][0].equals("X") && matrix[2][0].equals("X")) {
      System.out.println("Game Ended X Won!");
      exitLoop = true;
      return;
    }
    if (matrix[0][1].equals("X") && matrix[1][1].equals("X") && matrix[2][1].equals("X")) {
      System.out.println("Game Ended X Won!");
      exitLoop = true;
      return;
    }
    if (matrix[0][2].equals("X") && matrix[1][2].equals("X") && matrix[2][2].equals("X")) {
      System.out.println("Game Ended X Won!");
      exitLoop = true;
      return;
    }
    // Diagonal:
    if (matrix[0][0].equals("X") && matrix[1][1].equals("X") && matrix[2][2].equals("X")) {
      System.out.println("Game Ended X Won!");
      exitLoop = true;
      return;
    }
    if (matrix[0][2].equals("X") && matrix[1][1].equals("X") && matrix[2][0].equals("X")) {
      System.out.println("Game Ended X Won!");
      exitLoop = true;
      return;
    }


    System.out.println("Enter the coordinates where you want to put O in the format (row col): ");
    r = reader.nextInt();
    c = reader.nextInt();

    if (r > 2 || c > 2) {
      System.out.println("row or col no. not found!");
      return;
    }

    matrix[r][c] = "O";
    logic();
    // Horizontal:
    if (matrix[0][0].equals("O") && matrix[0][1].equals("O") && matrix[0][2].equals("O")) {
      System.out.println("Game Ended O Won!");
      exitLoop = true;
      return;
    }
    if (matrix[1][0].equals("O") && matrix[1][1].equals("O") && matrix[1][2].equals("O")) {
      System.out.println("Game Ended O Won!");
      exitLoop = true;
      return;
    }
    if (matrix[2][0].equals("O") && matrix[2][1].equals("O") && matrix[2][2].equals("O")) {
      System.out.println("Game Ended O Won!");
      exitLoop = true;
      return;
    }
    // Vertical:
    if (matrix[0][0].equals("O") && matrix[1][0].equals("O") && matrix[2][0].equals("O")) {
      System.out.println("Game Ended O Won!");
      exitLoop = true;
      return;
    }
    if (matrix[0][1].equals("O") && matrix[1][1].equals("O") && matrix[2][1].equals("O")) {
      System.out.println("Game Ended O Won!");
      exitLoop = true;
      return;
    }
    if (matrix[0][2].equals("O") && matrix[1][2].equals("O") && matrix[2][2].equals("O")) {
      System.out.println("Game Ended O Won!");
      exitLoop = true;
      return;
    }
    // Diagonal:
    if (matrix[0][0].equals("O") && matrix[1][1].equals("O") && matrix[2][2].equals("O")) {
      System.out.println("Game Ended O Won!");
      exitLoop = true;
      return;
    }
    if (matrix[0][2].equals("O") && matrix[1][1].equals("O") && matrix[2][0].equals("O")) {
      System.out.println("Game Ended O Won!");
      exitLoop = true;
      return;
    }

  }

}
