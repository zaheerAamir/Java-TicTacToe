package com.example.socket;

import java.io.*;
import java.net.*;

public class Client {

  // initialize socket and input output streams
  private Socket socket = null;
  private BufferedReader input = null;
  private DataOutputStream out = null;

  public Client(String address, int port) {

    try {
      socket = new Socket(address, port);
      System.out.println("Connected");

      input = new BufferedReader(new InputStreamReader(System.in));

      out = new DataOutputStream(socket.getOutputStream());



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

      while (!line.equals("Over")) {
        try {
          line = input.readLine();
          out.writeUTF(line);

        } catch (IOException i) {
          System.err.println(i);
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
    Client client = new Client("127.0.0.1", 5000);

  }

}
