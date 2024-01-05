/**
    min = 0
    start
    end
    go over each interval
        if first start of interval < current interval
            min++
        else stat = start of the interval
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(e -> e[0]));
        int min=0;
        int end = intervals[0][1];

        for (int i=1; i<intervals.length; i++){
            if (intervals[i][0] < end){
                min++;
                end = Math.min(intervals[i][1], end);
            } 
            else end = intervals[i][1];
        }

        return min;
    }
}
