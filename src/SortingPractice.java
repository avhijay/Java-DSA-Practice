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

}
