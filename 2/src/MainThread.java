public class MainThread {
    public static void main(String[] args) {
        Thread t=Thread.currentThread();
        System.out.println(t);
        t.setName("My thread");
        System.out.println(t);
        int i;
        for(i=10;i>=0;i--){
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Interrupt");
            }
        }
    }
}
