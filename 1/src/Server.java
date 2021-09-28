import java.io.*;
import java.net.*;
public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(22222);
        System.out.println("Server Started");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Server Accepted");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());


                //read from client...
            Object cMsg = ois.readObject();
            System.out.println("From Client: " + (String) cMsg);
            String serverMsg = (String) cMsg;
            serverMsg = serverMsg.toUpperCase();

                //send to client..
            oos.writeObject(serverMsg);

        }
    }
}