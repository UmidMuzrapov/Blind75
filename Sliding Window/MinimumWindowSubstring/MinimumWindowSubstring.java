import java.util.HashMap;

public class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0 || t.length() > s.length()) {
            return "";
        }

        int left = 0, right = 0, count = 0, minLen = Integer.MAX_VALUE;
        int[] minWindowIndices = {0, 0};

        HashMap<Character, Integer> targetMap = new HashMap<>();
        HashMap<Character, Integer> currentMap = new HashMap<>();

        for (char ch : t.toCharArray()) {
            currentMap.put(ch, 0);
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        while (right < s.length()) {
            char currentChar = s.charAt(right);

            if (targetMap.containsKey(currentChar)) {
                currentMap.put(currentChar, currentMap.get(currentChar) + 1);

                if (currentMap.get(currentChar) <= targetMap.get(currentChar)) {
                    count++;
                }

                while (count == t.length()) {
                    if (right - left < minLen) {
                        minLen = right - left;
                        minWindowIndices[0] = left;
                        minWindowIndices[1] = right + 1;
                    }

                    char leftChar = s.charAt(left);

                    if (targetMap.containsKey(leftChar)) {
                        currentMap.put(leftChar, currentMap.get(leftChar) - 1);

                        if (currentMap.get(leftChar) < targetMap.get(leftChar)) {
                            count--;
                        }
                    }

                    left++;
                }
            }

            right++;
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(minWindowIndices[0], minWindowIndices[1]);
    }
}
