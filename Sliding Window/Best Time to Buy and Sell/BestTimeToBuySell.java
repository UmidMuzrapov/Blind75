class Solution {
    /*
        left 
        right
    */
    public int maxProfit(int[] prices) {

        if (prices.length<2) return 0;
        
        int left =0;
        int right =1;
        int maxProfit = Integer.MIN_VALUE;

        while (right<prices.length){
            if (prices[left]>=prices[right]){
                left=right;
                right++;
            } else{

                if (prices[right]- prices[left]>maxProfit){
                    maxProfit = prices[right] - prices[left];
                }

                right++;
            }   
        }

        if (maxProfit==Integer.MIN_VALUE) return 0;
        else return maxProfit;
    }
}