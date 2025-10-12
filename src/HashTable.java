import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class HashTable {
    private int size = 7;

    // Node type used as performing separate  chaining//
    private Node[] dataMap;

    public class Node {
        private String key;
        private int value;
        private Node next;


        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        dataMap = new Node[size];

    }

    public void printHash() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];

            while (temp != null) {
                System.out.println("{" + temp.key + " : " + temp.value + " }");
                temp = temp.next;
            }
        }
    }


    private int hashing(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length; //%dataMap.length ensures that the hash always falls under the index boundaries;

        }
        //always going to be the number that is 0 to 6 ;
        return hash;
    }

    public void set(String key, int value) {
        int index = hashing(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }


    public int get(String key) {
        int index = hashing(key);
        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.key == key) {
                return temp.value;
            }
            temp = temp.next;

        }
        return 0;

    }

    public ArrayList keys() {
        ArrayList<String> allKeys = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null) {
                allKeys.add(temp.key);
                temp = temp.next;
            }

        }
        return allKeys;
    }

    public static boolean commanItems(int[] array1, int[] array2) {
        HashMap<Integer, Boolean> newTable = new HashMap<>();
        for (int i : array1) {
            newTable.put(i, true);
        }
        for (int j : array2) {
            if (newTable.get(j) != null) {
                return true;
            }

        }
        return false;
    }



public static List<Integer>  returnDuplicates(int[]array1){
        HashMap<Integer,Integer> myHash = new HashMap<>();
        int count = 0;
        for(int i:array1){
            if(myHash.get(i)==null){
                myHash.put(i,count+1);
            }else{
                int oldCount = myHash.get(i);
                myHash.put(i,oldCount+1);
            }

        }
        ArrayList<Integer> duplicates= new ArrayList<>();
        for (int key :myHash.keySet()){
            if(myHash.get(key)>1){
                duplicates.add(key);
            }

        }
        return duplicates;
}
public  static  void  main(String[]args){
    int[] arr = {1, 2, 3, 2, 4, 3, 5};
    System.out.println(returnDuplicates(arr));
}
}

