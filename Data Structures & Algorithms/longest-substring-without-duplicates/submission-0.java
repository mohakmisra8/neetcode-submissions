class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Expand right and add characters to the set
        // When you hit a duplicate, shrink from left until the duplicate is removed
        // Track the max window size throughout

        int right = 0;
        int left = 0;
        int maxLen = 0;

        Set<Character> set = new HashSet<>();
        
        while (right <s.length()) {
            char c = s.charAt(right);
            while(set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}
