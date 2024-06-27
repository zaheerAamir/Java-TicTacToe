package com.example;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 * Client
 */
public class Client {

  // initialize socket and input output streams
  // Use Scanner class to read input from terminal
  private Socket socket = null;
  private Scanner scanner = null;
  private DataOutputStream out = null;

  // constructor to put ip address and port
  public Client(String ip, int port) {

    try {

      socket = new Socket(ip, port);
      System.out.println("Connected!");

      // takes input from the terminal
      scanner = new Scanner(System.in);

      // sends output to the socket
      out = new DataOutputStream(socket.getOutputStream());

    } catch (UnknownHostException u) {

      System.out.println(u);
      return;

    } catch (IOException i) {

      System.out.println(i);
      return;

    }

    String line = "";

    // keep reading untill "Over" is input
    while (!line.equals("Over")) {
      try {

        line = scanner.nextLine();
        out.writeUTF(line);

      } catch (IOException i) {
        System.out.println(i);
      }

    }

    // Close the connection:
    try {

      scanner.close();
      out.close();
      socket.close();

    } catch (IOException e) {
      System.out.println(e);
    }

  }

  public static void main(String[] args) {
    Client client = new Client("127.0.0.1", 5000);
  }

}
