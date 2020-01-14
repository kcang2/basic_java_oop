import java.util.*;


class SortedList<T extends Comparable<T>> {  // Comparable is crucial
  LinkedList<T> list;
  public SortedList(T[] input){
    list = new LinkedList<>(Arrays.asList(input));
    Collections.sort(list);
  }
  public String toString() {
    return list.toString();
  }
}

class Main {
  public static void main(String[] args) {
    Random rand = new Random();
    Integer[] input = new Integer[25];
    for (int i = 0; i< 25; ++i)
      input[i] = rand.nextInt(101);
    SortedList<Integer> sl = new SortedList<Integer>(input);
    System.out.println(sl);
  }
}
