import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DateClient {
	private PrintWriter socketOut;
	private Socket dateSocket;
	private BufferedReader stdIn;
	private BufferedReader socketIn;

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

    public static void main(String[] args) throws IOException  {
		DateClient aClient = new DateClient("localhost", 9090);
		aClient.communicate();
	}

}