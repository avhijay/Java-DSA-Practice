import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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


    public int minValue(Node currentNode){
        while (currentNode.left!=null){
            currentNode = currentNode.left;

        }
        return currentNode.value;
    }




    private  Node deleteNode(Node currentNode , int value ){

        if (currentNode==null)return null;

        if(value< currentNode.value){
            currentNode.left = deleteNode(currentNode.left,value);

        } else if (value>currentNode.value) {
            currentNode.right=deleteNode(currentNode.right,value);

        }else{
            if(currentNode.left==null && currentNode.right==null){
                return  null ;
            }


            // if node has a node in either left or right
            else if (currentNode.left == null){
                currentNode =currentNode.right;
            } else if (currentNode.right==null) {
                currentNode = currentNode.left;

            }else{
                // if the node to be deleted has both left , right child
                int subTreeMinValue = minValue(currentNode.right);
                currentNode.value=subTreeMinValue;
                currentNode.right=deleteNode(currentNode.right,subTreeMinValue);
            }




        }
        return currentNode;


    }
    public void deleteNode(int value){
        root =  deleteNode(root,value);
    }


    // TREE TRAVERSAL

public ArrayList<Integer> BFS(){
        Node currentNode = root;

    Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> output = new ArrayList<>();
        queue.add(currentNode);

        while (!queue.isEmpty()){
            currentNode=queue.remove();
            output.add(currentNode.value);




            if (currentNode.left!=null){
                queue.add(currentNode.left);
            }
            if (currentNode.right!=null){
                queue.add(currentNode.right);
            }


        }


   return output;
}

public ArrayList<Integer>DFSPreOrder(){
        ArrayList<Integer>output = new ArrayList<>();

        class Traverse{
            Traverse(Node currentNode){
                output.add(currentNode.value);

                if(currentNode.left!=null){
                    new Traverse(currentNode.left);
                }
                if (currentNode.right!=null){
                    new Traverse(currentNode.right);
                }

            }

        }
        new Traverse(root);
        return  output;





}


public ArrayList<Integer>DFSPostOrder(){
        ArrayList<Integer>output = new ArrayList<>();

        class Traversal{
             Traversal(Node currentNode){
                 if (currentNode.left!=null){
                     new Traversal(currentNode.left);
                 }
                 if (currentNode.right!=null){
                     new Traversal(currentNode.right);
                 }
                 output.add(currentNode.value);




            }

        }


new Traversal(root);
return output;


}

public ArrayList<Integer>DFSInOrder(){
        ArrayList<Integer>output= new ArrayList<>();

        class Traverse{
            Traverse(Node currentNode){


                if(currentNode.left!=null){
                   new Traverse(currentNode.left);
                }
                output.add(currentNode.value);

                if (currentNode.right!=null){
                  new  Traverse(currentNode.right);
                }

            }
        }
        new Traverse(root);
        return output;

}








}