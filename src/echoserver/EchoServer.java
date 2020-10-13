package echoserver;

import java.net.*;
import java.io.*;

public class EchoServer {
  public static final int portNumber = 6013;

  public static void main(String[] args) {
    try {
      // Start listening on the specified port
      ServerSocket sock = new ServerSocket(portNumber);

      // Run forever, which is common for server style services
      while (true) {
        // Wait until someone connects, thereby requesting a date
        Socket client = sock.accept();

        InputStream input = client.getInputStream();
        OutputStream output = client.getOutputStream();

        int byteIn;

        while((byteIn = input.read()) != -1){
          output.write(byteIn);
          output.flush();
          System.out.flush();
        }
        
        output.flush();
        System.out.flush();

        // Close the client socket since we're done.
        client.close();
      }
    // *Very* minimal error handling.
    } catch (IOException ioe) {
      System.out.println("We caught an unexpected exception");
      System.err.println(ioe);
    }
  }
}