class Solution 
{
    public int characterReplacement(String s, int k) 
    {
        int max = Integer.MIN_VALUE;

        for (int i=0; i<s.length(); i++)
        {
            int localMax= findMax(i, s, k);
            if (max < localMax)
            {
                if (localMax == s.length())
                {
                    return localMax;
                }
                
                max = localMax;
            }

        }

        return max;
    }

    private int findMax(int i, String s, int k)
    {
        int left = i -1;
        int right = i + 1;
        int count = 1 ;
        boolean go_on= true;

        while(go_on)
        {
            if(validMove(left, s.length()) && validMove(right, s.length()))
            {
                if (s.charAt(left) == s.charAt(i))
                {
                    count++;
                    left--;
                }

                else if (s.charAt(right) == s.charAt(i))
                {
                    count++;
                    right++;
                }

                else
                {
                    if (k>0)
                    {
                        k--;
                        left--;
                        count++;
                    }

                    else
                    {
                        go_on =false;
                    }
                }
            }

            else if (validMove(left, s.length()))
            {
                if (s.charAt(left) == s.charAt(i))
                {
                    count++;
                    left--;
                }

                else
                {
                    if (k>0)
                    {
                        k--;
                        left--;
                        count++;
                    }

                    else
                    {
                        go_on = false;
                    }
                }
            }

            else if (validMove(right, s.length()))
            {
                if (s.charAt(right) == s.charAt(i))
                {
                    count++;
                    right++;
                }

                else
                {
                    if (k>0)
                    {
                        k--;
                        right++;
                        count++;
                    }

                    else
                    {
                        go_on = false;
                    }
                }
            }

            else
            {
                go_on = false;
            }
        }

        return count;
    }

    private boolean validMove(int i, int length)
    {
        return (i>=0 && i<length);
    }
}
