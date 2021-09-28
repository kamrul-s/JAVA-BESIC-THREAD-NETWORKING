import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable{
    BlockingQueue<String> q;
    Thread t;
    String name;
    int qsmax=0;
    Consumer(BlockingQueue<String> qtem,String name,int qsmax){
        this.q=qtem;
        this.name=name;
        this.qsmax=qsmax;
        //new Thread(this,name).start(); ->ok to use. Eliminate next two line
        t=new Thread(this,name);
        t.start();
    }
    @Override
    public void run() {
        while (true) {
            try {
                if(q.size()<=0){
                    System.out.println("Queue is empty");
                    t.sleep(2000);
                }
                System.out.println(name+" got:"+q.take());
                t.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
