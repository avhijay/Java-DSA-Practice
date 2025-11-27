import java.util.Arrays;

public class SortingPractice {

public static void bubbleSort(int [] array){

    for(int i = array.length; i>0; i--) {

        for (int j = 0; j < i; j++) {
            if (array[j] > array[j + 1]) {
                int temp = array[j];
                array[j]=array[j+1];
                array[j+1]=temp;

            }

        }
    }




}
public static void selectionSort(int [] num ){

    for(int i = 0 ; i < num.length; i++){
        int minIndex= i;
        for(int j = i+1 ; j <num.length; j++ ) {
            if (num[j] < num[minIndex]) {
                minIndex = j;
            }
        }
        if(i!=minIndex) {
            int temp = num[minIndex];
            num[minIndex] = num[i];
            num[i] = temp;

        }
        }

    }

    public static void insertionSort(int[] array ){

    for( int i =1; i < array.length; i++ ){
         int temp = array[i];
         int prev = i-1;

         while (prev>-1 && temp<array[prev]){
array[prev+1]=array[prev];
array[prev]=temp;
prev--;

         }
    }

}


public static int [] merge( int [] num1  , int [] num2  ){

    int i = 0 ;
     int j = 0 ;
     int index = 0 ;
     int [] output = new int [num1.length+num2.length];

    while (i < num1.length &&  j < num2.length ){
        if(num1[i] > num2[j]){
            output[index]=num2[j];
             index++;
            j++;
        }else {
            output[index] = num1[i];
            index++;
            i++;
        }
    }

    while ( i < num1.length){

        output[index]= num1[i];
        index++;
        i++;
    }
    while(j< num2.length){
         output[index] = num2[j];
         index++;
         j++;
    }
 return  output;


}


 public static int [] mergeSort(int[]mergeMe ){

    if (mergeMe.length==1)return mergeMe;

     int mid = mergeMe.length/2;
     int[] left = mergeSort(Arrays.copyOfRange(mergeMe,0,mid));
     int [] right = mergeSort(Arrays.copyOfRange(mergeMe, mid,mergeMe.length));
     return merge(left,right);


 }



 public static void swap(int [] array , int index1 ,  int index2){
    int temp = array[index1];
    array[index1]=array[index2];
    array[index2] = temp;



 }


 public static int  pivot ( int [] array1 , int pivotIndexPointer , int endIndex){

    int swapIndex = pivotIndexPointer;
    for(int i = pivotIndexPointer+1; i <=endIndex;i++) {
        if (array1[i] < array1[pivotIndexPointer]) {
            swapIndex++;
            swap(array1,i,swapIndex);

        }
    }
        swap(array1,pivotIndexPointer,swapIndex);
    return swapIndex;

 }

  public static void quickSortHelper( int [] array , int left , int right ) {

      if (left < right) {
          int pivotIndex = pivot(array, left, right);
          quickSortHelper(array, left, pivotIndex - 1);
          quickSortHelper(array, pivotIndex + 1, right);
      }

  }
    public static void quickSort(int[]array) {

    quickSortHelper(array,0,array.length-1);
    }






    public static void main (String [] args ){

        int [] newOne = {2,4,7,8,9,1,8,3,7};

      quickSort(newOne);
        System.out.println(Arrays.toString(newOne));


    }



}








