import java.util.HashMap;

class Solution {
    public int longestKSubstr(String s, int k) {
        int low = 0;
        int maxLen = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int high = 0; high < s.length(); high++) {
            // Add character at high pointer to map
            char ch = s.charAt(high);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Shrink window if unique characters exceed k
            while (map.size() > k) {
                char leftChar = s.charAt(low);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                low++;
            }

            // Update max length if window has exactly k unique characters
            if (map.size() == k) {
                maxLen = Math.max(maxLen, high - low + 1);
            }
        }

        return maxLen;
    }
}