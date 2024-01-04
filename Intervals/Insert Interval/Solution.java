/**
    do binary search -> find where to insert
    go over and get arrays

 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> startL = new ArrayList<Integer>();

        for (int[] interval: intervals){
            startL.add(interval[0]);
            for (int num: interval){
                list.add(num);
            }
        }

        int insertI = Collections.binarySearch(startL, newInterval[0]);
        if (insertI <0){
            insertI = -insertI -1; 
        }
        list.add(insertI*2, newInterval[0]);
        list.add(insertI*2+1, newInterval[1]);
        List<int[]> result = new LinkedList<int[]>();
        int start = 0;
        int big = list.get(start+1);
        for (int i=1; i<list.size(); i++){
            if (i%2==0 ){
                if (big<list.get(i)){
                    int[] interval = {list.get(start), list.get(i-1)>big ? list.get(i-1):big};
                    result.add(interval);
                    start = i;
                }

                if (list.get(i+1)>big) big= list.get(i+1);
            }
        }
        
        if (list.get(list.size()-1) >big) big =list.get(list.size()-1);

        int[] interval = {list.get(start), big};
        result.add(interval);

        int[][] resultArray = new int[result.size()][2];
        for (int i=0; i<result.size(); i++){
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}
