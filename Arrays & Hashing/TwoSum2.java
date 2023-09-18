class Solution 
{
    public int[] twoSum(int[] nums, int target) 
	{
			HashMap<Integer, Integer> elementIndex = new HashMap<Integer, Integer>();
            int[] result = {0, 0};
            
            for (int i=0; i < nums.length; i++)
            {
                int difference = target - nums[i];
                if (elementIndex.containsKey(difference))
                {
                    result[0] = i;
                    result[1] = elementIndex.get(difference);
                    return result;
                }

                elementIndex.put(nums[i], i);
            }

            return result;
    }
}