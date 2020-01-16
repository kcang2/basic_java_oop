import java.util.*;

// class TreeNode definition
class TreeNode<T extends Comparable<T>>{
  // package access members
  TreeNode<T> leftNode;
  T data; // node value
  int count;
  TreeNode<T> rightNode;
  // constructor initializes data and makes this a leaf node
  public TreeNode(T nodeData){
    count = 1;
    data = nodeData;
    leftNode = rightNode = null; // node has no children
  }
  // locate insertion point and insert new node; ignore duplicate values
  public int insert(T insertValue, int depth){
    depth += 1;
    // insert in left subtree
    if (insertValue.compareTo(data) < 0){
      // insert new TreeNode
      if (leftNode == null)
        leftNode = new TreeNode<T>(insertValue);
      else // continue traversing left subtree recursively
        depth = leftNode.insert(insertValue, depth);
    }
    // insert in right subtree
    else if (insertValue.compareTo(data) > 0) {
      // insert new TreeNode
      if (rightNode == null)
        rightNode = new TreeNode<T>(insertValue);
      else // continue traversing right subtree recursively
        depth = rightNode.insert(insertValue, depth);
    }
    else{ // equal value
      this.count += 1;
      depth -= 1;
    }
    return depth;
  }
} // end class TreeNode

// class Tree definition
public class Tree<T extends Comparable<T>> {
  private TreeNode<T> root;
  private int depth;
  // constructor initializes an empty Tree of integers
  public Tree(){
    root = null;
    depth = 0;
  }

  // insert a new node in the binary search tree
  public void insertNode(T insertValue){
    if (root == null){
      depth = 1;
      root = new TreeNode<T>(insertValue); // create root node
    }
    else{
      int newdepth = root.insert(insertValue, 1); // call the insert method
      depth = (newdepth>depth)? newdepth:depth;
    }
  }

  public void deleteNode(T value) {
    TreeNode<T> deleted = root;  // search for deleted
    TreeNode<T> parent = root;
    boolean isLeft = false;

    while (deleted != null) {
      if (value.compareTo(deleted.data) == 0) // Found
        break;
      else {  // continue searching
        parent = deleted;
        if (value.compareTo(deleted.data) < 0){
          deleted = deleted.leftNode;
          isLeft = true;
        }
        else if (value.compareTo(deleted.data) > 0) {
          deleted = deleted.rightNode;
          isLeft = false;
        }
      }
    }
    if (deleted == null) { // not found
      System.out.println("Value not found");
      return;
    }
    else { // deleting
      if (deleted.rightNode == null && deleted.leftNode == null){ // leaf
        System.out.println("LEAF!");
        if (isLeft)
          parent.leftNode = null;
        else
          parent.rightNode = null;
      }
      else if(deleted.rightNode == null ^ deleted.leftNode == null){ // single child
        System.out.println("SINGLE!");
        if (isLeft)
          parent.leftNode = (deleted.rightNode!=null)?deleted.rightNode : deleted.leftNode;
        else
          parent.rightNode = (deleted.rightNode!=null)?deleted.rightNode : deleted.leftNode;;
      }
      else { // two children, get replacement
        // smallest greater than deleted || largest less than deleted
        System.out.println("DOUBLE!");
        TreeNode<T> replacement = deleted.leftNode;
        TreeNode<T> parentReplacement = deleted;

        while (replacement.rightNode != null){  // get replacement and its parent
          parentReplacement = replacement;
          replacement = replacement.rightNode;
        }

        if (isLeft)
          parent.leftNode = replacement;
        else
          parent.rightNode = replacement;
      
        if(replacement != deleted.rightNode)
          replacement.rightNode = deleted.rightNode;
        if(replacement != deleted.leftNode)
          replacement.leftNode = deleted.leftNode;

        if (replacement.leftNode == null) // replacement has no child
          parentReplacement.rightNode = null;
        else
          parentReplacement.rightNode = replacement.leftNode;
      }
      deleted = null;
    }
  }


  public TreeNode<T> contains(T value) {
    TreeNode<T> current = root;
    while(current!=null) {
      if (value.compareTo(current.data) == 0){
        System.out.println("Found!");
        break;
      }
      else if(value.compareTo(current.data) < 0)
        current = current.leftNode;
      else
        current = current.rightNode;
    }
    return current;
  }
  
  public int getDepth(){return depth;}
  private void print(TreeNode<T> node){
    System.out.printf("%s,%s ", node.data, node.count); // output node data
  }
  
  // begin preorder traversal
  public void preorderTraversal(){preorderHelper(root);}
  // recursive method to perform preorder traversal
  private void preorderHelper(TreeNode<T> node){
    if (node == null)
      return;
    print(node);
    preorderHelper(node.leftNode); // traverse left subtree
    preorderHelper(node.rightNode); // traverse right subtree
  }

  // begin inorder traversal
  public void inorderTraversal(){inorderHelper(root);}
  // recursive method to perform inorder traversal
  private void inorderHelper(TreeNode<T> node){
    if (node == null)
      return;
    inorderHelper(node.leftNode); // traverse left subtree
    print(node);
    inorderHelper(node.rightNode); // traverse right subtree
  }

  // begin postorder traversal
  public void postorderTraversal(){postorderHelper(root);}
  // recursive method to perform postorder traversal
  private void postorderHelper(TreeNode<T> node){
    if (node == null)
      return;
    postorderHelper(node.leftNode); // traverse left subtree
    postorderHelper(node.rightNode); // traverse right subtree
    print(node);
  }
  // begin levelorder traversal
  public void levelorderTraversal(){levelorderHelper(root);}
  // recursive method to perform postorder traversal
  private void levelorderHelper(TreeNode<T> node){
    if (node == null)
      return;
    LinkedList<TreeNode<T>> q = new LinkedList<>();
    q.addFirst(node);
    while(q.size() > 0){
      node = q.pollLast();
      print(node);
      if (node.leftNode != null)
        q.addFirst(node.leftNode);
      if (node.rightNode != null)
        q.addFirst(node.rightNode);
    }
  }
} // end class Tree