package serverPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("attendre la connexion d'un client");

            Socket clientSocket = serverSocket.accept();
            System.out.println("client est connecte");

            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

            int x;
            do {
                x = dis.readInt();
                System.out.println("Reçu du client: " + x);

                if (x != 0) {
                    int result = x * 5;
                    dos.writeInt(result);
                    System.out.println("Envoyé au client: " + result);
                }

            } while (x != 0);

            System.out.println("Client a envoyé 0 ");
            dis.close();
            dos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
