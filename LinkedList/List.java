// class to represent one node in a list
class ListNode<T> {
  // package access members; List can access these directly
  T data; // data for this node
  ListNode<T> nextNode; // reference to the next node in the list
  // constructor creates a ListNode that refers to object
  ListNode(T object){this(object, null);}
  // constructor creates ListNode that refers to the specified
  // object and to the next ListNode
  ListNode(T object, ListNode<T> node){
    data = object;
    nextNode = node;
  }
  // return reference to data in node
  T getData(){return data;}
  // return reference to next node in list
  ListNode<T> getNext(){return nextNode;}
} // end class ListNode<T>

// class List definition
public class List<T> {
  private ListNode<T> firstNode;
  private ListNode<T> lastNode;
  private String name; // string like "list" used in printing

  // constructor creates empty List with "list" as the name
  public List(){this("list");}

  // constructor creates an empty List with a name
  public List(String listName){
    name = listName;
    firstNode = lastNode = null;
  }

  // insert item at front of List
  public void insertAtFront(T insertItem){
    if (isEmpty()) // firstNode and lastNode refer to same object
      firstNode = lastNode = new ListNode<T>(insertItem);
    else // firstNode refers to new node
      firstNode = new ListNode<T>(insertItem, firstNode);
  }

  public void insertAt(T insertItem, int index){
    if (index == 0){
      insertAtFront(insertItem);
      return;
    }
    ListNode<T> newNode = new ListNode(insertItem);
    ListNode<T> prev = firstNode;
    for (int i = 0; i < index-1; i++){
      if (prev.nextNode == null){
        System.out.println("Unexpected end of list. Check your index");
        return;
      }
      prev = prev.nextNode;
    }
    ListNode<T> temp = prev.nextNode;
    prev.nextNode = newNode;
    newNode.nextNode = temp;
  }

  public T removeAt(int index) throws EmptyListException{   
    ListNode<T> prev = firstNode;
    for (int i = 0; i < index-1; i++){
      if (prev.nextNode == null)
        throw new IllegalArgumentException("Unexpected end of list. Check your index");
      prev = prev.nextNode;
    }
    if (prev.nextNode.nextNode == null)
      return removeFromBack();
    else{
      ListNode<T> temp = prev.nextNode;
      prev.nextNode = prev.nextNode.nextNode;
      temp.nextNode = null;
      return temp.data;
    }
  }

  // insert item at end of List
  public void insertAtBack(T insertItem){
    if (isEmpty()) // firstNode and lastNode refer to same object
      firstNode = lastNode = new ListNode<T>(insertItem);
    else // lastNode's nextNode refers to new node
      lastNode = lastNode.nextNode = new ListNode<T>(insertItem);
  }

  // remove first node from List
  public T removeFromFront() throws EmptyListException{
    if (isEmpty()) // throw exception if List is empty
      throw new EmptyListException(name);
    T removedItem = firstNode.data; // retrieve data being removed
    // update references firstNode and lastNode
    if (firstNode == lastNode)
      firstNode = lastNode = null;
    else
      firstNode = firstNode.nextNode;
    return removedItem; // return removed node data
  }

  // remove last node from List
  public T removeFromBack() throws EmptyListException {
    if (isEmpty()) // throw exception if List is empty
      throw new EmptyListException(name);
    T removedItem = lastNode.data; // retrieve data being removed
    // update references firstNode and lastNode
    if (firstNode == lastNode)
      firstNode = lastNode = null;
    else {// locate new last node 
      ListNode<T> current = firstNode;
      // loop while current node does not refer to lastNode
      while (current.nextNode != lastNode)
        current = current.nextNode;
      lastNode = current; // current is new lastNode
      current.nextNode = null;
    }
    return removedItem; // return removed node data
  }

  // determine whether list is empty
  public boolean isEmpty(){
    return firstNode == null; // return true if list is empty
  }

  // output list contents
  public void print(){
    if (isEmpty()) {
      System.out.printf("Empty %s%n", name);
      return;
    }
    System.out.printf("The %s is: ", name);
    ListNode<T> current = firstNode;
    // while not at end of list, output current node's data
    while (current != null){
      System.out.printf("%s ", current.data);
      current = current.nextNode;
    }
    System.out.println();
  }
  public ListNode<T> search(T value){
    if (isEmpty()) {
      System.out.printf("Empty %s%n", name);
      return null;
    }
    else{
      ListNode<T> current = firstNode;
      return searchRecursive(current, value);
    }
  }
  private ListNode<T> searchRecursive(ListNode<T> current, T value) {
    if (current.data == value) { // found
      return current;
    }
    else if (current.nextNode != null){ // could be next
      return searchRecursive(current.nextNode, value);
    }
    else { // not found and end-of-list
      return null;
    }
  }

  public void printListBackward(){
    if (isEmpty()) {
      System.out.printf("Empty %s%n", name);
      return;
    }
    System.out.printf("The %s is: ", name);
    ListNode<T> current = firstNode;
    // while not at end of list, output current node's data
    printRecursive(current);
    System.out.println();
  }
  private void printRecursive(ListNode<T> current){
    if (current.nextNode != null)
      printRecursive(current.nextNode);
    System.out.printf("%s ", current.data);
  }
} // end class List<T>
