import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread  implements Runnable{
    Socket socket;
    Thread t;
    ServerThread(Socket ts){
        socket=ts;
        t=new Thread(this);
        t.start();
    }
    @Override
    public void run() {


        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            while (true) {
                Object cMsg = ois.readObject();
                if(cMsg==null) break;
                System.out.println("From Client: " + (String) cMsg);
                String serverMsg = (String) cMsg;
                serverMsg = serverMsg.toUpperCase();
                //send to client..
                oos.writeObject(serverMsg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
