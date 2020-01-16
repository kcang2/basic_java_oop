import java.util.*;

public class Main{
  public static void main(String[] args) {
    List<Integer> l = new List<>();
    for (int i=0; i< 5; ++i) {
      l.insertAtBack(i);
    }
    l.print();
    l.printListBackward();
    System.out.println(l.search(3).getData());
  }
}