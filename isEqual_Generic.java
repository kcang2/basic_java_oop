import java.util.*;

public class Main
{
  public static void main(String[] args) {
    Double d1 = 5.0;
    Double d2 = 4.0;
    System.out.println(isEqual(d1, d2));
  }

  public static <T extends Comparable<T>> boolean isEqual(T p1, T p2) {
    return (p1.compareTo(p2) == 0)? true: false;
  }
}
