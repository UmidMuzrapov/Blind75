class Solution 
{
    public int[] twoSum(int[] nums, int target) 
		{
			List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

			for (int i=0; i<nums.length; i++)
			{
				list.add( new ArrayList(Arrays.asList(nums[i], i)));
			}

			Collections.sort(list, Comparator.comparing((ArrayList<Integer> e) -> e.get(0)));

			int left =0;
			int right= list.size()-1;

			while (left!=right)
			{
				if (list.get(left).get(0)+ list.get(right).get(0) == target)
				{
					break;
				}

				else if (list.get(left).get(0)+ list.get(right).get(0)> target)
				{
					right--;
				}

				else
				{
					left++;
				}
			}

			int[] result = {list.get(left).get(1), list.get(right).get(1)};

			return result;
    }
}