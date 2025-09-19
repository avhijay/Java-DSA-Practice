import java.util.ArrayList;

public class HashTable {
private int size = 7;

// Node type used as performing separate  chaining//
private  Node[] dataMap;

  public class Node {
      private String key;
      private int value;
      private Node next;


      public Node(String key, int value) {
          this.key=key;
          this.value=value;
      }
  }

  public HashTable(){
      dataMap=new Node[size];

  }
public void printHash(){
      for(int i = 0; i<dataMap.length;i++){
          System.out.println(i+":");
          Node temp = dataMap[i];

          while(temp!=null){
              System.out.println("{"+ temp.key +" : "+temp.value +" }");
              temp=temp.next;
          }
      }
}



private int hashing(String key){
      int hash = 0;
      char[] keyChars = key.toCharArray();
      for(int i = 0; i<keyChars.length;i++){
          int asciiValue=keyChars[i];
          hash = (hash+asciiValue*23)%dataMap.length; //%dataMap.length ensures that the hash always falls under the index boundaries;

      }
      //always going to be the number that is 0 to 6 ;
      return  hash;
}
public void set(String key, int value){
      int index = hashing(key);
      Node newNode = new Node(key,value);
      if(dataMap[index]==null){
          dataMap[index]=newNode;
      }else{
          Node temp = dataMap[index];
          while(temp.next!=null){
              temp = temp.next;
          }
          temp.next=newNode;
      }
}


public int get(String key){
      int index = hashing(key);
      Node temp= dataMap[index];
      while(temp!=null){
          if(temp.key==key){
              return temp.value;
          }
          temp=temp.next;

      }
return 0;

}

public ArrayList keys(){
      ArrayList<String> allKeys=new ArrayList<>();
      for (int i = 0; i<dataMap.length;i++){
          Node temp = dataMap[i];
          while(temp!=null){
              allKeys.add(temp.key);
              temp=temp.next;
          }

      }
      return allKeys;
}

}
