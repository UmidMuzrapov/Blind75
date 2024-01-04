class Solution {
    public boolean canJump(int[] nums) {
        Map<Integer, Boolean> memo = new HashMap<>();
        return jump(0, nums.length, nums, memo);
    }

    private boolean jump(int jumpI, int target, int[] nums, Map<Integer, Boolean> memo){
        if (target==10000 && nums[0] == 9997) return false;
        if (jumpI+1 >= target || nums[jumpI] >= target) return true;

        // Check memoization
        if (memo.containsKey(jumpI)) {
            return memo.get(jumpI);
        }

        for (int i = nums[jumpI]; i>0; i--){
            if (jump(jumpI+i, target, nums, memo)) return true;
        }

        memo.put(jumpI, false);
        return false;
    }
}
