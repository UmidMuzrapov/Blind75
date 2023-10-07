/*
    Example:
    1
    [3,4,5,1,2]
*/
class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length-1;
        int mid = (left+right)/2;

        while (left!=right){
           
            mid = (left+right)/2;
            System.out.printf("left %d right %d mid %d \n ", left, right, mid);
            if (nums[mid]<min){
                min =  nums[mid];
            }

            if (nums[left]<= nums[mid]){
                left = mid +1;
            } else{
                right = mid - 1;
            }
        }

        if (nums[mid-1]<min){
            min = nums[mid-1];
        }

        return min;
    }


}