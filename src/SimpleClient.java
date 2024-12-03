import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SimpleClient {

    public static void main(String[] args) {
        SimpleClient use = new SimpleClient();
        use.establishClient();
    }

    public void establishClient() {
        int port = 1254;
        String host = "localhost";
        String request = "[SYN]!";

        try (Socket socket = new Socket(host, port);
             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

            out.writeUTF(request);
            System.out.println("ClientHater1002: " + request);
            String response = in.readUTF();
            System.out.println("ServerLover2001: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
