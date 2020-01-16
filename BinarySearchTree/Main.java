import java.security.SecureRandom;

public class Main {
  public static void main(String[] args) {
    Tree<Integer> tree = new Tree<Integer>();
    SecureRandom randomNumber = new SecureRandom();
    System.out.println("Inserting the following values: ");
    // insert 10 random integers from 0-99 in tree
    int del = 0;
    int find = 0;
    for (int i = 0; i < 10; i++) {
      int value = randomNumber.nextInt(100);
      System.out.printf("%d ", value);
      if (i == 3)
        find = value;
      if (i == 4)
        del = value;
      tree.insertNode(value);
    }
    System.out.printf("%n%nPreorder traversal%n");
    tree.preorderTraversal();
    System.out.printf("%n%nInorder traversal%n");
    tree.inorderTraversal();
    System.out.printf("%n%nPostorder traversal%n");
    tree.postorderTraversal();
    System.out.println();
    System.out.println(tree.getDepth());

    tree.deleteNode(del);
    System.out.printf("%n%nInorder traversal%n");
    tree.inorderTraversal();

    TreeNode<Integer> n = tree.contains(find);
    System.out.println(n==null);
  }
} // end class TreeTest