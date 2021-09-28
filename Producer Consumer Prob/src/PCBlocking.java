import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PCBlocking {
    public static void main(String[] args){
        int qsize=4;
        BlockingQueue<String> q=new ArrayBlockingQueue<>(qsize);
        Producer p1=new Producer(q,"q1",qsize);
        Consumer c1=new Consumer(q,"c1",qsize);
        Consumer c2=new Consumer(q,"c2",qsize);
        Consumer c3=new Consumer(q,"c3",qsize);
    }
}
