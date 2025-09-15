public class Stack {

    private  Node top;
    private int height;




    public class Node {
        int value;
        Node next;


        public Node(int value){
            this.value=value;
        }
    }
    public Stack(int value){
        Node newNode = new Node(value);
        top=newNode;
        height=1;

    }
public void printStack(){
        Node temp = top;
        while (temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }



    }

public void gethHeight(){
    System.out.println("Height :"+ height);

}

public void getTop(){
    System.out.println("Top :"+top.value);
}
public void getTopNode(){
    System.out.println(top);
}

}
