class Solution {
    public int search(int[] nums, int target) {
        int leftMost = nums[0];
        int left = 0;
        int right = nums.length-1;
        int min = nums[left];
        int mid =0; 
        int minIndex =0;

        while (right>=left){
            mid = (int) Math.ceil((left + right)/2.0);
            if (nums[mid]<=min){
                min = nums[mid];
                minIndex = mid;
            }
            if (nums[mid]>leftMost){
                left = mid+1;
            } else{
                right = mid - 1;
            }
        }

     
        if (minIndex!=0 ){
            if (target> nums[minIndex-1] || target< nums[minIndex]){
                return -1;
            }
        } else{
             if (target> nums[nums.length-1] || target< nums[0]){
                return -1;
            }
        }

        int location =0;
        if (  nums[nums.length-1]>=target || minIndex==0){
            location = Arrays.binarySearch(nums, minIndex, nums.length, target);   
        } else {
            location = Arrays.binarySearch(nums, 0, minIndex, target);
        }

        if (location>=0){
            return location;
        } else return -1;

    }
}