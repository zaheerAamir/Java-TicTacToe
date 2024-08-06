package com.example;

import java.io.*;
import java.net.*;

public class Client {

  // initialize socket and input output streams
  private Socket socket;
  private BufferedReader input;
  private DataOutputStream out;

  public Client(String address, int port) {

    try {
      socket = new Socket(address, port);
      System.out.println("Connected");

      input = new BufferedReader(new InputStreamReader(System.in));

      out = new DataOutputStream(socket.getOutputStream());

      if (out == null) {
        System.out.println("Output stream is not initialized");
      } else {
        System.out.println("Output initialized successfully!");
      }

      if (input == null) {
        System.out.println("Input stream is not initialized");
      } else {
        System.out.println("Input initialized successfully!");
      }


      // Start a new thread to listen for messages from the server
      Thread readThread = new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            DataInputStream bs = new DataInputStream(socket.getInputStream());
            String serverResponse;
            while ((serverResponse = bs.readUTF()) != null) {
              String[] user = serverResponse.split(" ", 3);
              if (user.length == 3 && Integer.parseInt(user[1]) != socket.getLocalPort()) {
                System.out.println("[" + user[0] + "]:> " + user[2]);

              }
            }
          } catch (IOException e) {
            System.err.println(e);
          }
        }
      });
      readThread.start();



      // String to read input message
      String line = "";

      System.out.println("Enter User Name: ");
      while (true) {
        try {

          line = input.readLine();

          if (line == null) {
            System.err.println("Input is null, ending loop!");
            break;
          }
          if (!line.equals("Over")) {
            if (out != null) {
              out.writeUTF(line);
              out.flush();
            } else {
              System.err.println("Output stream is null!");
            }

          } else {
            break;
          }

        } catch (IOException e) {
          System.err.println("Error sending message: " + e.getMessage());
        }
      }


      // Cleanup after "Over" is sent
      try {
        input.close();
        out.close();
        socket.close();
      } catch (IOException e) {
        System.err.println(e);
      }


    } catch (UnknownHostException u) {
      System.err.println(u);
      return;
    } catch (IOException i) {
      System.err.println(i);
      return;
    }

  }

  public static void main(String[] args) {
    Client client = new Client("server-container", 5000);

  }

}
