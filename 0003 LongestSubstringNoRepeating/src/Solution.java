import java.util.HashSet;

// try keeping track of last index of char and see how long you can go from there
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        HashSet<Character> usedChar = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (usedChar.contains(character)) {
                return Math.max(usedChar.size(), lengthOfLongestSubstring(s.substring(1)));
            }
            usedChar.add(character);
        }
        return s.length();
    }
}
