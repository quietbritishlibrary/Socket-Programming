import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    
    public static void main(String[] args) {
        SimpleServer use = new SimpleServer();
        use.establishServer();
    }

    public void establishServer() {
        int port = 1254;
        String reply = "[SYN, ACK]!";

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("( Server is up and running david! )> ( >␣o)");

            while (true) {
                try (
                    Socket socket = server.accept();
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream())
                ) {
                    System.out.println("ClientHater1002 Connected!");
                    String client = in.readUTF();
                    out.writeUTF(reply);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
