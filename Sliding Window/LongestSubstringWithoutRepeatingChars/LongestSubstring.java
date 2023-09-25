class Solution
{
    public int lengthOfLongestSubstring(String s) {
      if(s.length()==0) return 0;
      if (s.length()==1) return 1;

      HashSet<Character> set = new HashSet<Character>();
      int left =0;
      int right = 1;
      int maxLength = Integer.MIN_VALUE;
      set.add(s.charAt(left));

      while (right<s.length()){
        char nextChar = s.charAt(right);

        if (set.contains(nextChar)){

          if (right - left>maxLength){
            maxLength = right - left;
          }
          set.remove(s.charAt(left));
          left++;
        } else{
          set.add(nextChar);
          right++;
        }
      }

      if(set.size() > maxLength){
        maxLength =set.size();
      }

      return maxLength;
  }
}