class NewThread implements Runnable{
    Thread t;
    int tnum;
    NewThread(int x){
        t=new Thread(this,"Runable Thread");
        tnum=x;
        t.start();
    }
    @Override
    public void run() {
        System.out.println("Hello.You are in run method");
        int i;
        for(i=10;i>=0;i--){
            System.out.println(tnum+" Child Thread "+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Interrupt in Child Thread");
            }
        }
        System.out.println("Exit Child Thread");
    }
}
public class RunableThread {
    public static void main(String[] args){
        System.out.println("Main Thread Started");
        NewThread ob1= new NewThread(1);
        NewThread ob2= new NewThread(2);
        System.out.println("Thread 1 is alive:"+ob1.t.isAlive());
        System.out.println("Thread 2 is alive:"+ob2.t.isAlive());
        //ob1.t ->Here t is  the name of thread in runable class
        try {
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Thread Exited");
    }
}
