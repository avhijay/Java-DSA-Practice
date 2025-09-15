import java.sql.SQLOutput;

public  class  Main {
     public static void main(String[] args) {

         LinkedList mylinkedList = new LinkedList(1);
//         mylinkedList.append(2);
//         mylinkedList.append(3);
//         mylinkedList.append(4);
//         mylinkedList.append(5);
//         mylinkedList.append(6);

//mylinkedList.printList();
//         System.out.println("length :");
//mylinkedList.getLength();

//         mylinkedList.printList();
//         mylinkedList.getHead();
//         mylinkedList.getTail();
//         mylinkedList.getLength();
//
//
//
       //   mylinkedList.printList();
//         mylinkedList.getHead();
//         mylinkedList.getTail();
//         mylinkedList.getLength();

         //  System.out.println(mylinkedList.removeLast().value);
//
//
         // System.out.println(mylinkedList.removeLast().value);
//
//
//
         // System.out.println(mylinkedList.removeLast());

//         mylinkedList.prepend(564);
//         mylinkedList.getHead();
//         mylinkedList.getTail();
//         mylinkedList.printList();
//         mylinkedList.removeFirst();
//         mylinkedList.printList();
//         mylinkedList.getLength();
//mylinkedList.set(1,987);
//mylinkedList.printList();
//mylinkedList.insert(1010,0);
//         System.out.println("after insert ");
//mylinkedList.printList();
//mylinkedList.getLength();
//mylinkedList.reverse();
//mylinkedList.getTail();
//mylinkedList.getHead();
//mylinkedList.printList();
//mylinkedList.reverseBetween(1,4);
//mylinkedList.printList();


DoublyLinkedList newOne = new DoublyLinkedList(9);
//newOne.getTail();
//newOne.append(10);
//newOne.append(11);
//newOne.getTail();
//newOne.printList();


//mylinkedList.printReverse(mylinkedList.getHeadNode());

//
//         Stack newStack = new Stack(78);
//         newStack.gethHeight();
//         newStack.getTop();
//         newStack.printStack();

         BinarySearchTree newTree = new BinarySearchTree();
         System.out.println("Root is :  "+ newTree.root);

         newTree.insert(47);
         newTree.insert(21);
         newTree.insert(76);
         newTree.insert(18);
         newTree.insert(52);
         newTree.insert(82);


         System.out.println("Root is :  "+ newTree.root);

         newTree.insert(27);
         System.out.println(newTree.root.left.right.value);




     }
 }
