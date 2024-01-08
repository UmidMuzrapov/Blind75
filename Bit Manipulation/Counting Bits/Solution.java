class Solution {
    public int[] countBits(int n) {
        int[] ans =  new int[n+1];
        for (int i=0 ; i < n+1; i++){
            ans[i] = hammingWeight(i);
        }

        return ans;
    }

    private int hammingWeight(int n) {
		return Integer.bitCount(n);
    }
}
