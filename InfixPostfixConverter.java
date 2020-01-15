import java.util.Stack;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


class InfixtoPostfix{
  StringBuffer infix, postfix;
  Stack<Character> stack;

  public InfixtoPostfix(String expression){
    infix = new StringBuffer(expression);
    postfix = new StringBuffer();
    stack = new Stack<>();

    stack.push('(');  // a)
    infix.append(")"); // b)
    
    while (!stack.empty()) { // c)
      for (int i = 0; i < infix.length(); i++) {
        char temp = infix.charAt(i);
        
        if (Character.isDigit(temp)) // 1)
          postfix.append(temp);
        else if(temp == '(') // 2)
          stack.push(temp);
        else if (temp == ')') { // 4)
          while (stack.peek() != '(') {
            char top = stack.pop();
            postfix.append(top);
          }
          stack.pop();
        }
        else if (isOperator(temp)) { // 3)
          while (true) {
            if (isOperator(stack.peek())) {
              // System.out.println(stack.peek());
              // System.out.println(temp);
              if (precedence(temp, stack.peek())) {
                char top = stack.pop();
                postfix.append(top);
              }
              else
                break;
            }
            else
              break;
          }
          stack.push(temp);
        }
        else
          throw new IllegalArgumentException("Invalid Token");
      }
    }
  }

  public boolean isOperator(char c) {
    // Java uses \\ to escape; [*-*] signifies range; + signifies at least one
    String operators = "([-\\+*/^%])";
    // Create a Pattern object
    Pattern r = Pattern.compile(operators);
    // Now create matcher object.
    String s = "" + c;  // Matcher must receive CharSequence
    Matcher m = r.matcher(s);
    if (m.find())
      return true;
    else
      return false;
  }

  public boolean precedence(char op1, char op2) {
    int[] p = new int[2];
    char[] op = {op1, op2};

    for (int i = 0; i< op.length; ++i) {
      if (op[i] == '+' || op[i] == '-')
        p[i] = 0;
      else if(op[i] == '*' || op[i] == '/' || op[i] == '%')
        p[i] = 1;
      else if(op[i] == '^')
        p[i] = 2;
      else
        throw new IllegalArgumentException("Unknown Operator "+op[i]);
      }
  
    return (p[0] < p[1]) ? true : false;
  }

  public String toString() {
    return infix.toString() + "\n" + postfix.toString();
  }
}

class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter an expression");
    String input = in.nextLine();
    InfixtoPostfix I2P = new InfixtoPostfix(input);
    System.out.println(I2P);

  }
}
