import java.util.*;

class Market {
  LinkedList<Customer> q;
  int duration;
  public Market(int duration){
    q = new LinkedList<>();
    this.duration = duration;
  }
  public void simulate(){
    Random rand = new Random();
    int arrival = rand.nextInt((4 - 1) + 1) + 1;
    Customer c = new Customer(0, 0);
    boolean isService = false;
    int maxlen = 0;
    int maxwait = 0;
    int curwait = 0;

    for (int i=0; i<duration; ++i){
      if (q.size() > maxlen)
        maxlen = q.size();
      if (curwait > maxwait)
        maxwait = curwait;

      if (i == arrival) {
        System.out.println("New Customer");
        q.add(new Customer(i, curwait));
        curwait += q.getLast().getService();
        System.out.println(q.getLast());
        arrival = i + rand.nextInt((4 - 1) + 1) + 1;
      }

      if (isService) {
        if (c.getDone() == i) {
          System.out.println("Serviced Customer");
          System.out.println(c);
          isService = false;
        }
        curwait = ((curwait - 1) > 0)? (curwait - 1) : 0;
      }

      if((!isService) && (q.size() > 0)){
        isService = true;
        c = q.poll();
      }
    }
    System.out.println("Maximum Queue Length: "+maxlen);
    System.out.println("Maximum Wait: "+maxwait);
  }
}

class Customer {
  int arrival, wait, service;
  public Customer(int arrival, int wait){
    Random rand=new Random();
    this.arrival = arrival;
    this.wait = wait;
    this.service = rand.nextInt((4 - 1) + 1) + 1;
  }
  public int getArrival(){return arrival;}
  public int getService(){return service;}
  public int getWait(){return wait;}
  public int getDone() {return getArrival() + getWait() + getService();}
  public String toString(){
    return String.format("%d %d %d",getArrival(), getWait(), getService());
  }
}

public class Main{
  public static void main(String[] args) {
    Market m = new Market(720);
    m.simulate();
  }
}
