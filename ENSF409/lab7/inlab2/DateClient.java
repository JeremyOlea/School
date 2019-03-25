import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Reads Strings from Server and asks for user inputs
 * @author Michael Jeremy Olea
 * @version 1.0
 * @since March 24th, 2019
 */
public class DateClient {
    /**
     * PrintWriter used to send inputs to Server
     */
    private PrintWriter socketOut;
    /**
	 * Socket of the Client
	 */
    private Socket dateSocket;
    /**
     * BufferedReader to get user input from keyboard
     */
    private BufferedReader stdIn;
    /**
     * BufferedReader to get user input from Server
     */
	private BufferedReader socketIn;

    /**
	 * Constructor for Client
	 * @param serverName name of socket
	 * @param portNumber port number of socket
	 */
	public DateClient(String serverName, int portNumber) {
		try {
			dateSocket = new Socket(serverName, portNumber);
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			socketIn = new BufferedReader(new InputStreamReader(dateSocket.getInputStream()));
			socketOut = new PrintWriter((dateSocket.getOutputStream()), true);
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
    }

    /**
	 * Reads messages from Server and asks user to enter inputs to send to Server
	 */
    public void communicate() {
        String input = "";
        String response = "";
        boolean running  = true;
        while(running) {
            try {
                System.out.println("Please select an option (DATE/TIME)");
                input = stdIn.readLine();
                socketOut.println(input);
                response = socketIn.readLine();
                if(response != null)
				    System.out.println(response);
            } catch(IOException e) {
                System.out.println("Sending error: " + e.getMessage());
            }
            if(input.equals("QUIT")) {
                System.out.println("GOODBYE!");
                running = false;
            }
        }

        try {
            stdIn.close();
            socketIn.close();
            socketOut.close();
        } catch (IOException e) {
            System.out.println("Closing error: " + e.getMessage());
        }
    }

    /**
	 * Starts the Client
	 * @param args Command line agruments
	 */
    public static void main(String[] args) throws IOException  {
		DateClient aClient = new DateClient("localhost", 9090);
		aClient.communicate();
	}

}