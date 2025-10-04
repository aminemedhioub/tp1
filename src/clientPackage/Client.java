package clientPackage;
import java.io.IOException;
import java.net.Socket;
public class Client {
    public static void main (String args[]){
        try {
            Socket socket = new Socket("localhost", 1234);
            System.out.println("client connecte");

            socket.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

