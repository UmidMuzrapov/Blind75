class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();
        getCombinations(candidates, result, comb, target, 0, 0);
        return result;
    }

    private void getCombinations(int[] candidates, List<List<Integer>> result, LinkedList<Integer> comb, int target, int sum, int gi){

        for (int i=gi; i<candidates.length; i++){
            int c = candidates[i];
            sum+=c;
            comb.addLast(c);
            if (sum==target){
                result.add(new LinkedList(comb));;
                comb.removeLast();
                sum-=c;
            }
            else if (sum>target){
                sum-=c;
                comb.removeLast();
            } else{
                getCombinations(candidates, result, comb, target, sum, i);
                sum-=c;
                comb.removeLast();
            }
        }
    }
}
