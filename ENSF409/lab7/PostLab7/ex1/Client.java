import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Takes inputs from user to send to Server
 * @author M. Moshirpour
 * @version 1.0
 * @since March 24th, 2019
 */
public class Client {
	/**
	 * PrintWriter used to send inputs to Server
	 */
	private PrintWriter socketOut;
	/**
	 * Socket of the Client
	 */
	private Socket palinSocket;
	/**
	 * BufferedReader to get user input from keyboard
	 */
	private BufferedReader stdIn;
	/**
	 * BufferedReader to get Strings from Server
	 */
	private BufferedReader socketIn;

	/**
	 * Constructor for Client
	 * @param serverName name of socket
	 * @param portNumber port number of socket
	 */
	public Client(String serverName, int portNumber) {
		try {
			palinSocket = new Socket(serverName, portNumber);
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			socketIn = new BufferedReader(new InputStreamReader(
					palinSocket.getInputStream()));
			socketOut = new PrintWriter((palinSocket.getOutputStream()), true);
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}

	/**
	 * Reads messages from Server and asks user to enter inputs to send to Server
	 */
	public void communicate()  {

		String line = "";
		String response = "";
		boolean running = true;
		while (running) {
			try {
				System.out.println("please enter a word: ");
				line = stdIn.readLine();
				if (!line.equals("QUIT")){
					System.out.println(line);
					socketOut.println(line);
					response = socketIn.readLine();
					System.out.println(response);	
				}else{
					running = false;
				}
				
			} catch (IOException e) {
				System.out.println("Sending error: " + e.getMessage());
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
		Client aClient = new Client("localhost", 8099);
		aClient.communicate();
	}
}