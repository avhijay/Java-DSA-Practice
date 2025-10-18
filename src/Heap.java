import java.util.ArrayList;
import java.util.List;

public class Heap {


    private int leftChild(int index){
        return 2*index+1;
    }

    private int rightChild(int index){
        return 2*index+2;
    }
    private int parent(int index){
        return(index-1)/2;
    }




    private List<Integer> heap;


    public  Heap(){
        this.heap=new ArrayList<>();
    }


    private void swap (int index1 , int index2 ){
        int temp = heap.get(index1);
        heap.set(index1,heap.get(index2));
        heap.set(index2,temp);
    }


    public List<Integer> getHeap(){
        return new ArrayList<>(heap);
    }



    public void insert(int value){
        heap.add(value);
        int current = heap.size()-1;

        while(current>0&&heap.get(current)>heap.get(parent(current))){
                swap(current,parent(current));
                current = parent(current);
        }

    }
    public Integer remove() {
        if  (heap.size()==0)return null;

        if (heap.size()==1){
            return  heap.remove(0);
        }

        int maxValue = heap.get(0);
        heap.set(0,heap.remove(heap.size()-1));
        sinkDown(0);
        return maxValue;



    }

    public  void sinkDown(int index){
        int maxIndex = index;
        while(true){
          int leftChild =  leftChild(index);
          int rightChild = rightChild(index);

          if(leftChild<heap.size() && heap.get(leftChild)>heap.get(maxIndex)){
              maxIndex=leftChild;


          }
          if(rightChild<heap.size()&&  heap.get(rightChild)>heap.get(maxIndex)){
              maxIndex=rightChild;
          }


          if (maxIndex!=index){
              swap(index,maxIndex);
              index=maxIndex;

          }else{
              return;
          }


        }
    }




}
