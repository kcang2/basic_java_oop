import java.util.*;


class Main {
  public static <T extends Comparable<T>> ArrayList<T> reverseCopy(ArrayList<T> list) {
    ArrayList<T> copyList = new ArrayList<T>(list);
    Collections.reverse(copyList);
    return copyList;
  }
  public static void main(String[] args) {
    Integer[] arr = {1, 2, 3};
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
    ArrayList<Integer> reverse = reverseCopy(list);
    System.out.println(list);
    System.out.println(reverse);
  }
}
