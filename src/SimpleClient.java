import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SimpleClient {
	
	public static void main(String [] args) {
		
		SimpleClient use = new SimpleClient();
		use.establishClient();
	}
	
	public void establishClient() {
		
		// field
		int port = 1254;
		String host = "localhost";
		DataInputStream in;
		DataOutputStream out;
		Socket socket;
		double aNumber = 38;

		try {
			socket = new Socket(host, port); //establish end-point client side and assign registered port
			in = new DataInputStream (socket.getInputStream()); // receive data
			out = new DataOutputStream(socket.getOutputStream()); // send data
			out.writeDouble(aNumber);
			System.out.println(in.readDouble()); // read data
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		}

}
