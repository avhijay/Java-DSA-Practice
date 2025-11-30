import java.util.*;

public class ArraysExamples {

    public int maxSubarraySizeK(int[] num, int k) {
        int currentSum = 0;
        int maxSum = 0;

        for (int i = 0; i < k; i++) {
            currentSum += num[i];
        }
        maxSum = currentSum;


        for (int j = k; j < num.length; j++) {
            currentSum += num[j];
            currentSum -= num[j - k];
            maxSum = Math.max(maxSum, currentSum);


        }
        return maxSum;

    }


    public int numberOfGoodPairs(int[] num) { // give number of pairs(i , j) where  i < j and num[i]==num[j]
        HashMap<Integer, Integer> newMap = new HashMap<>();
        int pairs = 0;
        for (int value : num) {


            if (newMap.containsKey(value)) {
                int appearanceFrequency = newMap.get(value);
                pairs += appearanceFrequency;
                newMap.put(value, appearanceFrequency + 1);

            } else {
                newMap.put(value, 1);
            }
        }
        return pairs;


    }


    public int longestSubArray(int[] num, int k) {

        int currentSum = 0;
        int currentLength = 0;
        int maxLength = 0;
        int expandLeft = 0;

        for (int expand = 0; expand < num.length; expand++) {

            currentSum += num[expand];

            while (currentSum > k) {
                currentSum -= num[expandLeft];
                expandLeft++;
            }


            maxLength = Math.max(maxLength, expand - expandLeft + 1);


        }
        return maxLength;


    }

    public Boolean twoSumSortedHashApproach(int[] num, int target) {
        HashMap<Integer, Integer> newMap = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            int required = target - num[i];
            if (newMap.get(required) != null) {
                return true;
            } else {
                newMap.put(num[i], i);
            }

        }

        return false;


    }

    public void printArray (int [] array ){
        for (int a : array){
            System.out.println(a);
        }
    }

    public Boolean twoSumSortedTwoPointerApproach(int[] num, int target) {

        int left = 0;
        int right = num.length - 1;

        while (left < right) {
            int requiredSum = num[left] + num[right];


            if (requiredSum == target) {
                return true;
            }


            if (requiredSum < target) {
                left++;
            } else {
                right--;
            }


        }
        return false;

    }

    public int removeDuplicates(int[] num) {
        int left = 0;


        for (int right = 1; right < num.length; right++) {
            if (num[right] != num[left]) {

                left++;
                num[left] = num[right];   // as we increase the index of left pointer and move it to the duplicate and hence element removed  , if no duplicate the index left is already  equal to index right so it doesn't matter
            }

        }
        return left + 1;
    }



// dry run this
    public int removeElement(int[] num, int val){
        int left = 0 ;



        for(int right = 0 ; right < num.length; right++){


            if (num[right]!=val){
num[left]=num[right];
                left++;
            }

        }
        return left ;


    }




    public void moveZeroes(int[] num) {

        int left = 0 ;


        for( int right = 0 ; right<num.length; right++){
            if (num[right]!=0){
                num[left]=num[right];
                left++;
            }


        }
        for (int i = left ; i < num.length; i ++){
            num[i]=0;
        }


    }



public void sortColors(int [] num){

        int left  = 0 ;
        int right  = num.length-1;


        for (int mid = 0; mid <= right ; mid++ ){
            if (num[mid]==0){
                int temp = num[left];
                num[left]= num[mid];
                num[mid]= temp;
                left ++;

            } else if ( num[mid]==2 ){
                int temp = num[right];
                num[right]=num[mid];
                num[mid]= temp ;
                 right--;
                 mid--;
            }




        }
}



public int[] firstAndLastPosition(int [] nums , int target ){


    int left = 0 ;
    int right = nums.length-1;
    int start = -1;
    int end = -1;
// do 2 binary search and when  value == target then in one binary search move left , and in the other move right
    while(left<=right){
        int mid = left+(right-left)/2;

        if(nums[mid] > target ){
            right = mid-1;
        }

        else if (nums[mid]<target){
            left = mid+1;
        }
        else{
            start = mid;
            right = mid-1;

        }

    }
    left = 0;
    right = nums.length - 1;


    while(left<=right){
        int mid = left +(right - left)/2;


        if(nums[mid]>target){
            right = mid-1;

        }
        else if (nums[mid]< target){
            left = mid+1;
        }else{
            end = mid;
            left = mid +1;
        }

    }

    int [] output =  {start , end };
    return output ;



}



    public List<ArrayList<Integer>>threeSum(int[] array1) {
        Arrays.sort(array1);

        int right = 0;
        int mid = 0;
        List<ArrayList<Integer>> output = new ArrayList<>();

        for(int i = 0; i< array1.length - 2; i ++){
            if( i==0 ||  array1[i]!= array1[i-1]){
                int required = -array1[i];
                mid = i+1;
                right = array1.length-1;

                while   ( mid< right ){

                    int currentTotal = array1[mid]+ array1[right];
                    if(currentTotal<required){


                        while(    mid < right  &&  array1[mid+1]== array1[mid]   ){
                            mid++;
                        }

                        mid++;
                    }


                    else if(currentTotal > required){

                        while(   right > mid && array1[right-1]== array1[right] ){
                            right--;
                        }

                        right--;

                    }


                    else if(currentTotal==required){
                        ArrayList<Integer> newOne  = new ArrayList<>();
                        newOne.add(array1[i]);
                        newOne.add(array1[mid]);
                        newOne.add(array1[right]);
                        output.add(newOne);

                        while(   right > mid && array1[right-1]== array1[right] ){
                            right--;
                        }
                        while(    mid < right  &&  array1[mid+1]== array1[mid]   ){
                            mid++;
                        }

                        mid++;
                        right--;
                    }
                }

            }


        }
        return output;

    }









}





















//    Problem C (Medium)
//
//    Count how many pairs sum to less than a given target.
//            Example:
//
//    arr = [1, 3, 4, 6]
//    target = 10













