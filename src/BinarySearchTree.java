public class BinarySearchTree {
    Node root;


    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }


    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) {
                return false;
            }
            if (newNode.value > temp.value) {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                } else {
                    temp = temp.right;
                }
            } else {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                } else {
                    temp = temp.left;
                }
            }


        }


    }
public  boolean contains(int value ){
        if(root==null)return  false;
        Node temp = root;
        while(temp!=null){
            if(temp.value==value){
                return  true;
            }else{
                if(temp.value>value){
                    temp=temp.left;
                }else{
                    temp=temp.right;
                }
            }
        }return  false;
}


private boolean recursiveContains(Node currentNode , int value){
        if (currentNode == null)return false;
        if(currentNode.value==value) return true;

        if(value<currentNode.value){
          return  recursiveContains(currentNode.left,value);
        }else{
           return recursiveContains(currentNode.right, value);
        }
}

public boolean recursiveContains(int value){
        return recursiveContains(root,value);
}


private Node  recursiveInsert(Node currentNode , int value){

        if (currentNode==null)return new Node(value);
        if (value< currentNode.value){
            currentNode.left=recursiveInsert(currentNode.left,value);
        }else if (value > currentNode.value){
            currentNode.right=recursiveInsert(currentNode.right,value);
        }
        return  currentNode;


}


public  void recursiveInsert(int value){


        if (root==null) root = new Node(value);
      recursiveContains(root,value);
}




}