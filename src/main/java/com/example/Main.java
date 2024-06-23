// Tic Tac Toe Terminal Game:
package com.example;

/**
 * Main
 */
public class Main {

  public static void main(String[] args) {

    pattern(3, 4);

  }

  static void pattern(int r, int c) {

    for (int row = 1; row <= r; row++) {

      System.out.println("-----------------");
      // for every row, run the col:
      for (int col = 1; col <= c; col++) {

        System.out.print("|    ");
      }
      System.out.println();

    }
    System.out.println("-----------------");
  }

}
