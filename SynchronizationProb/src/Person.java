public class Person implements Runnable {
    String name;
    Printer p;
    //final Printer p;
    int pages;
    Thread t;
    Person(String name,Printer p,int pages){
        this.name=name;
        this.p=p;
        this.pages=pages;
        t=new Thread(this,name);
        t.start();
    }
    @Override
    public void run() {
        /*synchronized (p){
            p.printAssignment(...);
        }*/
        p.printAssignment(pages,name);
    }
}
