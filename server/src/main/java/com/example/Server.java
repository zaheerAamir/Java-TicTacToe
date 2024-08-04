package com.example;

import com.google.gson.Gson;

import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;

public class Server implements Runnable {

  private static Socket socket = null;
  private static ServerSocket server = null;
  private static ArrayList<Socket> sockets = new ArrayList<Socket>();
  private int threadNo = 0;
  // Maximum number of threads in thread pool
  static final int MAX_T = 4;
  private static HashMap<Integer, String> users = new HashMap<>();

  public Server(int threadNo) {
    this.threadNo = threadNo;

  }

  public void clientServerComm(Socket socket) {

    try {
      System.out.println(socket);
      DataOutputStream ps = null;
      DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

      String line = "";

      // reads message from client until "Over" is sent
      while (!line.equals("Over")) {
        try {


          line = in.readUTF();

          // Ensure thread safety while accessing shared resources
          synchronized (sockets) {
            for (Socket s : sockets) {
              try {
                /*
                 * will take message from each socket (s) and will write to all the other sockets
                 * client. then client will read the writeUTF sent from server and print it to
                 * System.out so that each client can see other connected client message.this will
                 * be done for each thread. synchronized because all the threads will access this
                 * block of code to broadcast message so to make each thread use this block of one
                 * thread at a time.
                 */
                ps = new DataOutputStream(s.getOutputStream());
                ps.writeUTF(users.get(socket.getPort()) + " " + socket.getPort() + " " + line);
                ps.flush();
              } catch (IOException e) {
                System.err.println("Error sending message to client: " + e.getMessage());
              }
            }
          }


          if (users.containsKey(socket.getPort())) {
            System.out.println("[" + users.get(socket.getPort()) + "]:> " + line + " [thread "
                + this.threadNo + "]");

          }


        } catch (IOException x) {
          System.out.println(x);
        }
      }


      System.out.println("Closing connection for " + users.get(socket.getPort()));

      // close connection
      socket.close();
      in.close();


    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  @Override
  public void run() {

    clientServerComm(sockets.get(this.threadNo));

  }

  public static void main(String[] args) {


    try {

      ExecutorService pool = Executors.newFixedThreadPool(MAX_T);

      server = new ServerSocket(5000);
      System.out.println("Server Started!");

      System.out.println("Waiting for client ....");

      for (int i = 0; i < 4; i++) {
        socket = server.accept();
        System.out.println("Enter User Name: ");

        DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

        String user = in.readUTF();

        System.out.println("Client " + user + " accepted");
        sockets.add(socket);
        users.put(socket.getPort(), user);

        Server server = new Server(i);
        pool.execute(server);

      }

      pool.shutdown();

    } catch (Exception e) {
      System.err.println(e);
    }

  }

}
