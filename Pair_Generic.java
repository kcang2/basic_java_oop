import java.util.*;

class Pair <T, U>{
  T first;
  U second;
  public Pair(T first, U second){
    setFirst(first);
    setSecond(second);
  }
  public void setFirst(T first) {
    this.first = first;
  }
  public void setSecond(U second) {
    this.second = second;
  }
  public T getFirst() {
    return first;
  }
  public U getSecond() {
    return second;
  }
}


public class Main
{
  public static void main(String[] args) {
    Pair<Double, Integer> p = new Pair<>(5.0, 1);
    System.out.println(p.getFirst());
    System.out.println(p.getSecond());
  }
} // end class GenericMethodTest
