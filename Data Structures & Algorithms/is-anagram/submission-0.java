class Solution {
    public boolean isAnagram(String s, String t) {
        // make 2 hash maps with counts of letter and count 
        // compare both map
        final var map = new HashMap<Character, Integer>();
        for(var c: s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        for(var c: t.toCharArray()) {
            map.merge(c, -1, Integer::sum);
        }
        return map.values().stream().allMatch(v -> v == 0);


    }
}
