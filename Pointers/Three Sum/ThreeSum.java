/*
    3
    {-1, 0, 1, 2, -1, -4}
    sort -> O(nlogn)
    for element in nums:
        if (element!= previous)
        {
            difference = target - element;
            left pointer = element index +1;
            right = at the end
            while (left!=right)
            {

            }
        }

    Analysis:
        Runtime: O(nlogn + n^2) = O(n^2);
        Space: O(1);
*/
class Solution 
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int previous = Integer.MIN_VALUE;
        HashSet<Integer> previousElements = new HashSet<Integer>();

        for (int numIndex = 0; numIndex< nums.length; numIndex++)
        {
            int num = nums[numIndex];
            if (previous!=num)
            {
                int difference = 0 - num;
                int left = numIndex+1;
                int right = nums.length - 1;
                int intermalPrevious = Integer.MIN_VALUE;

                while (left<right)
                {
                   
                   
                    
                        int sum = nums[left]+ nums[right];
                        if (sum == difference)
                        {
                             if (nums[left]!= intermalPrevious)
                             {
                                  result.add(List.of(num, nums[left], nums[right]));
                                  intermalPrevious = nums[left];
                                  
                             }
                           
                            
                            left++;
                            right--;
                        }

                        else if (sum > difference)
                        {
                            right--;
                        }

                        else
                        {
                            left++;
                        }

                        
                    

                }
            }


             previous = num;
        }

        return result;
    }
}