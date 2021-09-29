public class Printer {
    synchronized void printAssignment(int pages,String name){
        System.out.println("Printing Started "+name);
        for(int i=1;i<=pages;i++){
            System.out.println(name+" "+i);
        }
        System.out.println("Printing Ended");
    }
}
