class Solution {
    public int missingNumber(int[] nums) {
        int sum = (0+nums.length)*(nums.length+1)/2;

        for (int i=0; i<nums.length; i++){
            sum-=nums[i];
        }

        return sum;
    }
}
