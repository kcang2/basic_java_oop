import java.util.*;

class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter a string");

    String input = in.nextLine(); 
    String[] tokens = input.split(" ");

    Stack<String> stack = new Stack<>();

    for (String t: tokens) {
      stack.push(t);
    }
    
    try {
      while (true){
        String temp = stack.pop();
        System.out.println(temp);
      }
    }
    catch(EmptyStackException emptyStackException){
      System.out.println("Empty Stack");
    }

  }
}
