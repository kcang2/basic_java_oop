import java.util.*;

class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter a string");

    String input = in.nextLine();
    // Remove white-space and punctuation
    String lettersOnly = input.replaceAll("[\\W]", "");
    // String to char array
    char[] charArray = lettersOnly.toCharArray();
    // char array to Character array
    Character[] charObjectArray = new Character[charArray.length];
    for (int i =0 ; i < charArray.length; ++i) {
      charObjectArray[i] = charArray[i];
    }

    Stack<Character> stack = new Stack<>();
    for (Character c: charObjectArray) {
      stack.push(c);
    }

    boolean isPalindrome = true;
    for (Character c: charObjectArray) {
      Character sc = stack.pop();
      if (sc.compareTo(c) != 0 ){
        System.out.println("NOT A PALINDROME");
        break;
      }
    }
    
    if (isPalindrome)
      System.out.println("IT IS A PALINDROME");
  }
}
