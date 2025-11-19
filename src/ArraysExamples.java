import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArraysExamples {

    public int maxSubarraySizeK(  int [] num  , int k ){
         int currentSum= 0;
         int maxSum=0;

         for(int i =0 ; i < k ; i ++){
             currentSum += num[i];
         }
         maxSum=currentSum;


for (int j = k ; j<num.length;j++){
    currentSum += num[j];
    currentSum -= num[j-k];
    maxSum=Math.max(maxSum,currentSum);




}
return  maxSum;

    }


    public int  numberOfGoodPairs(int [] num ){ // give number of pairs(i , j) where  i < j and num[i]==num[j]
        HashMap<Integer, Integer> newMap = new HashMap<>();
        int pairs =0;
        for (int value : num){



            if (newMap.containsKey(value)){
                int appearanceFrequency= newMap.get(value);
                pairs+= appearanceFrequency;
                newMap.put(value,appearanceFrequency+1);

            }else{
                newMap.put(value,1);
            }
        }
        return pairs;



    }


    public int longestSubArray(int [] num , int k ){

        int currentSum = 0 ;
        int currentLength=0;
        int maxLength=0;
        int expandLeft=0;

        for(int expand = 0 ; expand<num.length;expand++){

            currentSum+=num[expand];

            while(currentSum>k) {
               currentSum -= num[expandLeft];
               expandLeft++;
            }


            maxLength = Math.max(maxLength,expand - expandLeft+1);


        }
        return  maxLength;





}









}
