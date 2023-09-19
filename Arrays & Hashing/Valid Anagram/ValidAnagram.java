class Solution 
{
    public boolean isAnagram(String s, String t) 
    {
        if (s.length()!=t.length()) return false;
        // 0 128
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();

        Arrays.parallelSort(charsS);
        Arrays.parallelSort(charsT);

        for (int i=0; i<charsS.length; i++)
        {
            if (charsS[i]!=charsT[i]) return false;
        }

        return true;
    }
}