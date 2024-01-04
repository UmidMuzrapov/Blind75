class Solution {
    public int maxSubArray(int[] nums) {
       int max= Integer.MIN_VALUE;
       int curSum = 0;

       for (int element: nums){
            curSum+=element;
            if (max<curSum) max= curSum;
            if (curSum<0) curSum = 0;
       } 

       return max;
    }
}
