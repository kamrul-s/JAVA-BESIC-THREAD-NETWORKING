
import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket("127.0.0.1", 22222);
        System.out.println("Client Connected..");

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        Scanner sc = new Scanner(System.in);

        String message = sc.nextLine();
        //sent to server...
        oos.writeObject(message);
        //receive from server..
        Object fromServer = ois.readObject();
        System.out.println("From Server: "+(String)fromServer);



    }
}