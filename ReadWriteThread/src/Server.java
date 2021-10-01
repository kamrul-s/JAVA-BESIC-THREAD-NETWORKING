import java.io.*;
import java.net.*;
public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(22222);
        System.out.println("Server Started");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Server Accepted");

            //new server thread created

            new ServerThread(socket);

        }
    }
}