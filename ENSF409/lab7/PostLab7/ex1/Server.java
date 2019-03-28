import java.io.IOException;
import java.net.*;
import java.io.*;
/**
 * Recieves word from Server and checks if it is a Palindrome
 * @author Michael Jeremy Olea
 * @version 1.0
 * @since March 24th, 2019
 */
public class Server {
    /**
     * the Socket used to connect the server with the client
     */
    private ServerSocket serverSocket;
    /**
     * PrintWriter used to print to the client
     */
    private PrintWriter socketOut;
    /**
     * Socket to client
     */
    private Socket clientSocket;
    /**
     * BufferedReader used to revieve input from client
     */
	private BufferedReader socketIn;
    
    /**
     * Constructor for the server
     * @param portNumber the port number for the server-client connection
     */
    public Server(int portNumber) {
        try {
            serverSocket = new ServerSocket(portNumber);
            clientSocket = serverSocket.accept();
            System.out.println("Server in now running...");
            socketOut = new PrintWriter(clientSocket.getOutputStream(), true);
            socketIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch(IOException e) {
            System.out.println("error in constructor");
        }
    }

    /**
     * infinite loop to wait for Client input
     */
    public void communicate() {
        String word;
        while (true) {
          try {
            word = socketIn.readLine();
            if (word == null) {
              socketOut.println("Goodbye!");
              break;
            }
            if (checkPalindrome(word)) {
              socketOut.println(word + " is a palindrome!");
            } else {
              socketOut.println(word + " is NOT a palindrome.");
            }
          } catch(IOException e) {
            System.err.println(e.getMessage());
          }
        }
    }

    /**
     * Calculates if a given string is a Palindrome
     * @param word The string to be check if it is a Paliondrome
     * @return true if the string is a palindrome, false otherwise
     */
    public boolean checkPalindrome(String word) {
        char[] wordChars = word.toCharArray();
        for(int i = 0; i < wordChars.length; i++) {
            if(wordChars[i] != wordChars[wordChars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Starts the Server
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Server myServer = new Server(8099);
        myServer.communicate();

        try {
            myServer.socketOut.close();
            myServer.socketIn.close();
        } catch(IOException e) {
            System.out.println("error in closing");
        }
    }
}