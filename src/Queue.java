public class Queue {
   private Node first ;
   private  Node last;
   private int length;


    class Node{
        int value;
        Node next;

        Node(int value ){
            this.value=value;
        }



    }

public  Queue(int value){
        Node newNode = new Node (value);
        first=newNode;
        last=newNode;
        length=1;
}


public void printQueue(){
        Node temp = first;
        while(temp!=null){
            System.out.println(temp.value);
            temp = temp.next;
        }
}

public  void getfirst(){
    System.out.println(first.value);


}
public void getfirstNode(){
    System.out.println(first);

}



public void getLast(){
    System.out.println(last.value);

}


public void getLastNode(){
    System.out.println(last);
}
 public void getLength(){
     System.out.println("Length :"+ length);
 }












}


