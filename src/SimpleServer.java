import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	
	// main
	public static void main(String [] args) {
		SimpleServer use = new SimpleServer();
		use.establishServer();
	}
 
	public void establishServer() {
		
	// field
	int port = 1254;
	DataInputStream in;
	DataOutputStream out;
	ServerSocket server;
	Socket socket;
	double aNumber = 17;

	try {
		server = new ServerSocket(port); // establish the server's socket and assign the port
		socket = server.accept(); // listen for communications
		in = new DataInputStream (socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());
		System.out.println(in.readDouble());
		out.writeDouble(aNumber);
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
	
	}
	
	
}
