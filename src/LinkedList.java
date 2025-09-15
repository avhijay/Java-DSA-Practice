import javax.swing.plaf.PanelUI;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;


    public class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    public LinkedList(int Value) {
        Node newNode = new Node(Value);
        head = newNode;
        tail = newNode;
        length = 1;


    }


    public void append(int value) {
        Node newNode = new Node(value);

        if (head != null) {

            tail.next = newNode;
            tail = newNode;
            length++;

        } else {
            head = newNode;
            tail = newNode;
            length = 1;
        }
    }

    public Node removeLast() {
        if (head == null) return null;
        Node temp = head;
        Node pre = head;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length==0){
            head=null;
            tail=null;
        }
        return temp;
    }



public void prepend(int value){

            Node newNode = new Node(value);
    if (head==null){
        head=newNode;
        tail=newNode;

    }else {
        newNode.next = head;
        head = newNode;

    }
    length++;
}

public  Node removeFirst(){
        if (length==0)return null;
    Node temp = head;

    head = head.next;
            temp.next=null;
            length--;
            if (head.next==null){
                head=null;
                tail=null;
            }
        return temp;

}

  public Node getHeadNode(){
      return head;
  }
public Node get(int index){
       if(index<0||index>=length){return null;}
       Node temp= head;
       for (int i =0;i<index;i++){
           temp=temp.next;


       }
       return temp;


}
public Boolean set(int index , int value ){
        Node temp = get(index);
            if (temp!=null) {
                temp.value = value;
                return true;
        }
            return false;
}



public  Boolean insert(int value , int index) {
    Node newNode = new Node(value);
    if (head == null) return null;
    if (index < 0 || index > length) return false;

    if (index == 0) {
        prepend(value);
        return true;
    }
        if(index == length) {
            append(value);
        }
    Node temp = get(index-1);
        newNode.next=temp.next;
        temp.next =newNode;
        length++;

        return true;
    }


    public Node remove(int index){
        if (index<0||index>=length)return null;
        if (index==0){
            return removeFirst();

        }
        if (index==length-1){
            return removeLast();
        }
        Node temp= get(index-1);
        Node remove=temp.next;// don't use the get method here as get is O(n) INSTEAD JUST USE NEXT TO POINT TO THE NODE
        temp.next=remove.next;
        remove.next=null;
        length--;
        return  remove;
    }

public  void reverse(){

        Node temp =head;
        head=tail;
        tail=temp;

        Node after = temp.next;
    Node before = null;
    for (int i =0; i<length;i++){
        after=temp.next;
   temp.next=before;
   before=temp;
   temp=after;
    }


}











    public void printList(){
        Node temp = head;
        while (temp!=null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }





    public void  getHead() {
        System.out.println("head : " +head.value);
    }



    public  void  getTail() {
        System.out.println("Tail :"+ tail.value);

    }



    public void getLength() {
        System.out.println("Length :"+length);

    }




    public void reverseBetween(int startindex , int endindex ){
        if(head==null)return;
        Node dummy1= new Node(0);
        dummy1.next= head;
        
        Node previous1= dummy1;




        for(int i =0;i<startindex;i++){
            previous1=previous1.next;
        }
        Node current1=previous1.next;


        /// intiliaze again as it is different than the normal reverse we cant just change the direction and do

        for(int i = 0 ; i<endindex- startindex;i++){
            Node toMove=current1.next;
            current1.next=toMove.next;
            toMove.next=previous1.next;
            previous1.next=toMove;
        }
        head=dummy1.next;
    }


  public void printReverse(Node temp ){
        if (temp==null)return;
        printReverse(temp.next);
      System.out.println(temp.value);



  }




}
