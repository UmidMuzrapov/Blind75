class Solution {
    public int getSum(int a, int b) {
        return add(a, b);
    }

    private int add(int x, int y)
    { 
        int keep = (x & y) << 1;
        int res = x^y;

        if (keep == 0)
            return res;
             
        return add(keep, res);
    }
}
