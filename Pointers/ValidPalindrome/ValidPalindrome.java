class Solution 
{
    public boolean isPalindrome(String s) 
    {
        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();

        for (char elem: chars)
        {
            if (Character.isLetterOrDigit(elem))
            {
                result.append(Character.toLowerCase(elem));
            }
        }

        if (result.length()==0) return true;
        int left = 0;
        int right = result.length()-1;

        while (left<right)
        {
            if (result.charAt(left)!=result.charAt(right))
            {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}