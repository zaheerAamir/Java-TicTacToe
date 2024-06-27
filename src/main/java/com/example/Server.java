package com.example;

import java.net.*;
import java.io.*;

/**
 * Server
 */
public class Server {

  // initialize socket and input stream
  private Socket socket = null;
  private Socket socket2 = null;
  private ServerSocket server = null;
  private DataInputStream in = null;

  // constructor with port:
  public Server(int port) {

    // Starts the server and wait for connection
    try {
      server = new ServerSocket(port);
      System.out.println("Server Started 🛜");

      System.out.println("Waiting for a client....");

      socket = server.accept();
      System.out.println("Client1 Accepted" + socket.toString());
      System.out.println("Thread Count: " + Thread.activeCount());

      socket2 = server.accept();
      System.out.println("Client2 Accepted" + socket2.toString());
      System.out.println("Thread Count: " + Thread.activeCount());

      // takes input from client socket:
      in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

      String line = "";

      // reads message from client until "Over" is sent

      while (!line.equals("Over")) {
        try {

          line = in.readUTF();
          System.out.println(line);

        } catch (IOException i) {
          System.out.println(i);
        }

      }
      socket.close();
      socket2.close();
      in.close();

    } catch (IOException i) {
      System.out.println(i);
    }

  }

  public static void main(String[] args) {
    Server server = new Server(5000);

  }

}
