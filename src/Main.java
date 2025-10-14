import javax.naming.NamingEnumeration;
import java.sql.SQLOutput;


public  class  Main {
     public static void main(String[] args) {



          //LINKED LIST:
//         LinkedList mylinkedList = new LinkedList(1);
//         mylinkedList.append(2);
//         mylinkedList.append(3);
//         mylinkedList.append(4);
//         mylinkedList.append(5);
//         mylinkedList.append(6);
//         mylinkedList.set(1,987);






//DOUBLE LINKED LIST :
DoublyLinkedList newOne = new DoublyLinkedList(9);
//newOne.getTail();
//newOne.append(10);
//newOne.append(11);
//newOne.getTail();
//newOne.printList();
//mylinkedList.printReverse(mylinkedList.getHeadNode());



//STACK:
//         Stack newStack = new Stack(78);
//         newStack.gethHeight();
//         newStack.getTop();
//         newStack.printStack();


         //BINARY SEARCH TREE:
//         BinarySearchTree newTree = new BinarySearchTree();
//         System.out.println("Root is :  "+ newTree.root);
//         newTree.insert(47);
//         newTree.insert(21);
//         newTree.insert(76);
//         newTree.insert(18);
//         newTree.insert(52);
//         newTree.insert(82);
//
//
//         System.out.println("Root is :  "+ newTree.root);
//
//         newTree.insert(27);
//         System.out.println(newTree.root.left.right.value);
//         System.out.println(    newTree.contains(52));


         // HASH TABLE:
         HashTable newHash = new HashTable();


        newHash.set("Mangoes",600);
        newHash.set("Apple",89);
         newHash.set("Litchi",788);
//         newHash.printHash();
         newHash.set("Grapes",655);
         newHash.set("MILK",87);
         newHash.set("Banana", 120);
//         newHash.set("Orange", 340);
//         newHash.set("Pineapple", 999);
//         newHash.set("Strawberry", 150);
//         newHash.set("Papaya", 432);
//         newHash.set("Watermelon", 222);
//         newHash.set("Peach", 77);
//         newHash.set("Cherry", 505);
//         newHash.set("Kiwi", 310);
//         newHash.set("Guava", 274);
//         newHash.set("Plum", 201);
//         newHash.set("Apricot", 312);
//         newHash.set("Blueberry", 415);
//         newHash.set("Raspberry", 518);
//         newHash.set("Blackberry", 622);
//         newHash.set("Coconut", 725);
//         newHash.set("Dates", 829);
//         newHash.set("Fig", 933);
//         newHash.set("Pomegranate", 1037);
//         newHash.set("Dragonfruit", 1140);
//        newHash.set("Jackfruit", 1244);         newHash.set("Durian", 1348);
//         newHash.set("Lychee", 1452);
//         newHash.set("Tamarind", 1556);
//         newHash.set("Mulberry", 1660);
//         newHash.set("Cranberry", 1764);
//         newHash.set("Gooseberry", 1868);
//          newHash.set("Lime", 2180);
//
////         newHash.printHash();
//         System.out.println(newHash.get("Fig"));
//         System.out.println(newHash.keys());


//----Graph---

         Graph newGraph = new Graph();
         newGraph.addVertex("A");
         newGraph.addVertex("B");
         newGraph.addVertex("C");
         newGraph.addVertex("D");


         newGraph.addEdge("A","B");
         newGraph.addEdge("C","D");
         newGraph.printGraph();

         newGraph.removeEdge("A","B");
         newGraph.printGraph();










     }


}
