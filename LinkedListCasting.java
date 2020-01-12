import java.util.*;

public class LinkedListCasting {
  public static void main(String[] args) {
    Character[] C = {'a', 'b', 'c', 'd'};

    // Standard up-casting as in Deitel.
    List<Character> LC = new LinkedList<>(Arrays.asList(C));

    // Down-cast to LinkedList<Char> since List has no clone() method
    // Type: LinkedList. Throws conversion error if assigned to List<Char> reference
    System.out.println((((LinkedList<Character>) LC).clone()).getClass());
    // List<Character> RLC = ((LinkedList<Character>) LC).clone();

    // The long way: down-cast, call clone(), type-cast again.
    List<Character> RLC = (LinkedList<Character>) ((LinkedList<Character>) LC).clone();
    // Reverse
    Collections.reverse(RLC);

    // No casting up and down
    LinkedList<Character> LC2 = new LinkedList<>(Arrays.asList(C));
    LinkedList<Character> RLC2 = (LinkedList<Character>) LC2.clone();
    Collections.reverse(RLC2);

    System.out.println(LC);
    System.out.println(RLC);

    System.out.println(LC2);
    System.out.println(RLC2);
  }
}
