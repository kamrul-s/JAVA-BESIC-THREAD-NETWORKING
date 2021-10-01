import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class WriterThread implements Runnable{
    ObjectOutputStream oos;
    String name;
    Thread t;
    WriterThread(ObjectOutputStream oos,String name){
        this.oos=oos;
        this.name=name;
        t=new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        Scanner sc=new Scanner(System.in);
        while (true) {
            String message = sc.nextLine();
            //if(message.equalsIgnoreCase("exit")) break;
            //sent to server...
            try {
                System.out.println("Message Sent By"+name+":"+message);
                oos.writeObject(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
