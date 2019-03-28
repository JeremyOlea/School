import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Takes inputs from user to send to Server
 * @author M. Moshirpour, Michael Jeremy Olea
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
    private Socket aSocket;
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
			aSocket = new Socket(serverName, portNumber);
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
			socketOut = new PrintWriter((aSocket.getOutputStream()), true);
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
    }

    /**
	 * Reads messages from Server and asks user to enter inputs to send to Server
	 */
    public void communicate() {
        boolean noReply = false;
        try {
            while(true) {
                String read = "";

                while(true) {
                    read = socketIn.readLine();
                    if(read.contains("BOARD")) {
                        noReply = true;
                        read = read.replace("BOARD", "");
                    } else if(read.contains("THE GAME IS OVER:")) {
                        noReply = true;
                    } else if(read.contains("INVALID:")) {
                        noReply = true;
                    }

                    if(read.contains("\0")) {
                        read = read.replace("\0", "");
                        System.out.println(read);
                        break;
                    }

                    if(read.equals("QUIT")) {
                        return;
                    }

                    System.out.println(read);
                }

                if(!noReply) {
                    read = stdIn.readLine();
                    socketOut.println(read);
                    socketOut.flush();
                }
                noReply = false;
            }
        } catch(IOException e) {
            System.out.println("Error in communicate");
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