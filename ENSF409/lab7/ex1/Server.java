import java.io.IOException;
import java.net.*;
//import java.util.*;
import java.io.*;

public class Server {
    private ServerSocket serverSocket;
    private PrintWriter socketOut;
	private Socket clientSocket;
	private BufferedReader socketIn;
    
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

    public void communicate() {
        while(true) {
            try {
                String word = socketIn.readLine();
                char[] wordChars = word.toCharArray();
                boolean isPalindrome = true;
                //ArrayList<Character> reverse = new ArrayList<Character>();
                for(int i = 0; i < wordChars.length; i++) {
                    if(wordChars[i] != wordChars[wordChars.length - i - 1]) {
                        isPalindrome = false;
                    }
                }
                if(isPalindrome == true) {
                    socketOut.println(word + " is a palindrome\n");
                }
                else {
                    socketOut.println(word + " is not a palindrome\n");
                }
    
            } catch(IOException e) {
                System.out.println("error in communicate");
            }
        }
        
    }
    public static void main(String[] args) {
        Server myServer = new Server(8099);
        myServer.communicate();

        try {
            //serverSocket.close();
            myServer.socketOut.close();
            myServer.socketIn.close();
        } catch(IOException e) {
            System.out.println("error in closing");
        }
    }
}