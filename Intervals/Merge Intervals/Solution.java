class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));

        List<int[]> r = new LinkedList<int[]>();
        int start = 0;
        int small = intervals[0][0];
        int big = intervals[0][1];

        for (int i = 1; i<intervals.length; i++){
            if (big < intervals[i][0]){
                int[] interval = {small, big};
                r.add(interval);
                start = i;
                small = intervals[i][0];
            } 

            if (intervals[i][1] > big) big = intervals[i][1];
            if (intervals[i][0] < small ) small = intervals[i][0];
        }

        if (intervals[intervals.length-1][1]>big) big = intervals[intervals.length-1][1];
        int[] interval = {small, big};
        r.add(interval);

        return r.toArray(new int[r.size()][]);
    }
}
