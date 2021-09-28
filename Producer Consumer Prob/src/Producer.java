import java.util.concurrent.BlockingQueue;

class Producer implements Runnable{

    BlockingQueue<String> q;
    Thread t;
    String name;
    int qsmax=0;
    Producer(BlockingQueue<String> qtem,String name,int qsmax){
        this.q=qtem;
        this.name=name;
        this.qsmax=qsmax;
        //new Thread(this,name).start(); ->ok to use. Eliminate next two line
        t=new Thread(this,name);
        t.start();
    }
    @Override
    public void run() {
        int i=0;
        while (true) {
            try {
                if(q.size()>=qsmax){
                    System.out.println("Queue is full");
                    t.sleep(2000);
                }
                q.put("Cake:"+i);
                System.out.println(name+" Produce Cake "+i);
                t.sleep(300);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}