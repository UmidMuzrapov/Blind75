class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while (left<right){

            int area = (right-left)*((int) Math.min(height[left], height[right]));
            if (area>maxArea){
                maxArea = area;
            }

            if (height[left]>=height[right]){
                right--;
            } else{
                left++;
            }
        }

        return maxArea;
    }
}