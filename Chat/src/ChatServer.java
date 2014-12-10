import java.io.*;
import java.net.*;

public class ChatServer {

  public static void main(String[] args) throws IOException {
    System.out.println("Welcome to Server side");
    BufferedReader in = null;
    PrintWriter    out= null;

    ServerSocket servers = null;
    Socket       fromclient = null;
    // create server socket
      servers = new ServerSocket(4444);
      System.out.print("Waiting for a client...");
      fromclient= servers.accept();
      System.out.println("Client connected");
    in  = new BufferedReader(new 
     InputStreamReader(fromclient.getInputStream()));
    out = new PrintWriter(fromclient.getOutputStream(),true);
    String         input,output;

    System.out.println("Wait for messages");
    while ((input = in.readLine()) != null) {
     if (input.equalsIgnoreCase("exit")) break;
     out.println("Server ::: "+ input);
     System.out.println(input);
    }
    out.close();
    in.close();
    fromclient.close();
    servers.close();
  }
}