import java.util.*;


class SortedList<T extends Comparable<T>> {  // Comparable is crucial
  LinkedList<T> list;
  public SortedList(T[] input){
    list = new LinkedList<>(Arrays.asList(input));
    Collections.sort(list);
  }
  public void merge(SortedList<T> list2) {
    list.addAll(list2.getList());
  }

  public LinkedList<T> getList() {
    return list;
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
    Integer[] input2 = {999, 1000};
    SortedList<Integer> sl2 = new SortedList<Integer>(input2);
    System.out.println(sl2);
    sl.merge(sl2);
    System.out.println(sl);
  }
}
