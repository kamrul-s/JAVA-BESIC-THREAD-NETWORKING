import java.io.IOException;
import java.io.ObjectInputStream;

public class ReaderThread implements Runnable {
    ObjectInputStream ois;
    String name;
    Thread t;
    ReaderThread(ObjectInputStream ois,String name){
        this.ois=ois;
        this.name=name;
        t=new Thread(this);
        t.start();
    }
    @Override
    public void run() {
        while (true) {
            try {
                Object rdmsg = ois.readObject();
                System.out.println("Got Message in" + name+" "+rdmsg);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
