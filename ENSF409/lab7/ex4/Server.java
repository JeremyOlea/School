//import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
     * A thread pool to hold multiple threads
     */
    private ExecutorService pool;

    /**
     * Constructor for the server
     * @param portNumber the port number for the server-client connection
     */
    public Server(int portNumber) {
        try {
            serverSocket = new ServerSocket(portNumber);
            pool = Executors.newCachedThreadPool();
        } catch(IOException e) {
            System.out.println("Error in constructor");
        }
    }

    /**
     * infinite loop to wait for Client input
     */
    public void communicate() {
        try {
            while(true) {
                Player xPlayer = new Player(serverSocket.accept(), 'X');
                Player oPlayer = new Player(serverSocket.accept(), 'O');
                Referee theRef = new Referee();
                theRef.setxPlayer(xPlayer);
                theRef.setoPlayer(oPlayer);

                //BufferedReader stdIn;
                Game theGame = new Game();
                theGame.appointReferee(theRef);

                System.out.println("Game is starting...");

                pool.execute(theGame);
            }
        } catch(IOException e) {
            e.printStackTrace();
            pool.shutdown();
        }
        pool.shutdown();
    }

    /**
     * Starts the Server
     * @param args Command line arguments
     */
    public static void main(String[] args) throws IOException {
        Server server = new Server(8099);
        System.out.println("Server is running");
        server.communicate();
    }
}