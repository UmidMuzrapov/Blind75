class Solution {
    public List<Integer> spiralOrder(int[][] m) {
        List<Integer> result = new ArrayList<Integer>();
        int l = 0;
        int r = m[0].length-1;
        int t = 0;
        int b = m.length - 1;
        int max = (r+1)*(b+1);
        int count = 0;

        while (r>=l && b >= t){
            for (int li = l; li <= r && count < max; li++){
                result.add(m[t][li]);
                count++;
            }

            for (int ti=t+1; ti<=b && count < max; ti++){
                result.add(m[ti][r]);
                count++;
            }

            for (int ri=r-1; ri>=l && count < max; ri--){
                result.add(m[b][ri]);
                count++;
            }

            for (int bi=b-1; bi>=t+1 && count < max; bi--){
                result.add(m[bi][l]);
                count++;
            }

            l++;
            r--;
            t++;
            b--;
        }

        return result;
    }
}
