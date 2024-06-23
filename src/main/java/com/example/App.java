
// Calculator code: needs some Impv
package com.example;


public class App {

  public static void main(String[] args) {

    Integer a = 12;
    System.out.println(a);
    // Call calc class with method add
    System.out.println("Addition: " + calc.add(5555, 3333));

    // Call calc class with method sub
    System.out.println("Subtraction: " + calc.sub(5555, 3333));

    // Call calc class with method mul
    System.out.println("Multiplication: " + calc.mul(5555, 3333));

    // Call calc class with method div
    System.out.println("Division: " + calc.div(5555, 3333));
  }

}


class calc {

  public static int add(int a, int b) {
    return a + b;
  }

  public static int sub(int a, int b) {
    return a - b;
  }

  public static int mul(int a, int b) {
    return a * b;
  }

  public static float div(int a, int b) {
    return a / b;
  }

}
