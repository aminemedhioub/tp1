package serverPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            // Création du serveur sur le port 1234
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("attendre la connexion d'un client");

            Socket clientSocket = serverSocket.accept();
            System.out.println("client est connecte");
            clientSocket.close();
            serverSocket.close();
            System.out.println("Connexion fermée");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
