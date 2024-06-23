// Tic Tac Toe Terminal Game:
package com.example;

import java.util.Scanner;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) {

    if (true) {
      Scanner reader = new Scanner(System.in);
      System.out.println("Press 1 to start the game and 0 to exit!: ");
      int input = reader.nextInt();

      if (input == 0) {
        reader.close();
        return;
      }
      logic();

      reader.close();

    }

  }

  static void pattern() {

    char[][] matrix = new char[3][3];

    for (int row = 0; row < matrix.length; row++) {

      System.out.println("-------------");
      // for every row, run the col:
      for (int col = 0; col < matrix[row].length; col++) {

        System.out.print("|" + row + "," + col);
      }
      System.out.println("|");

    }

    System.out.println("-------------");
  }

  static void logic() {
    Scanner reader = new Scanner(System.in);

    System.out.println("Logic Initiated!");
    System.out.println("X will get the first chance to play the game!");
    pattern();

    System.out.println("Enter the coordinated where you want to put X in the format (row col): ");
    int r = reader.nextInt();
    int c = reader.nextInt();
    System.out.println("You chose: " + r + ", " + c);
    pattern();

    reader.close();
  }

}
