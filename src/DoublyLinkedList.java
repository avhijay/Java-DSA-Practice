

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    int length;


    public class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;

    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        System.out.println("Head : " + head.value);
    }

    public void getTail() {
        System.out.println("Tail : " + tail.value);
    }

    public void getLength() {
        System.out.println("Length :  " + length);
    }


    public void append(int value) {
        Node newNode = new Node(value);
        if (head != null) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            length++;
        } else {
            head = newNode;
            tail = newNode;
            length = 1;
        }
    }


    public boolean isPalindrome() {
        if (head.next == null) return true;

        Node front = head;
        Node back = tail;
        for (int i = 0; i <= length / 2; i++) {
            if (front.value == back.value) {
                front = front.next;
                back = back.next;
            }
        }
        return true;
    }

    public void partitionList(int x) {

        Node dummy1=new Node(0);
        Node dummy2 = new Node(0);
        Node dumb1=dummy1;
        Node dumb2=dummy2;
        Node temp = head;
        while(temp!=null){
            if(temp.value<x){
                dumb1.next=temp;
                dumb1.next.prev=dumb1;
                dumb1=dumb1.next;


            }else{
                dumb2.next=temp;
                dumb2.next.prev=dumb2;
                dumb2=dumb2.next;


            }
            temp=temp.next;
        }

        if(dummy2.next==null){
            head=dummy1.next;
            tail=dumb1;
        }
        else if (dummy1.next==null){
            head=dummy2.next;
            tail=dumb2;
        }else{
            head = dummy1.next;
            dumb2.next=null;
            dumb1.next=dummy2.next;
            dummy2.next.prev=dumb1;

        }


    }



}


