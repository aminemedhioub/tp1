package clientPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Je suis un client pas encore connecté…");

            Socket socket = new Socket("localhost", 1234);
            System.out.println("je suis un client connecté");

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);

            int x;
            do {
                System.out.print("Entrez un entier (0 pour arrêter) : ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Veuillez entrer un entier valide : ");
                    scanner.next();
                }
                x = scanner.nextInt();

                dos.writeInt(x);
                dos.flush();

                if (x != 0) {
                    int result = dis.readInt();
                    System.out.println("Résultat reçu : " + result);
                } else {
                    System.out.println("Communication arrêtée");
                }

            } while (x != 0);

            dis.close();
            dos.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
