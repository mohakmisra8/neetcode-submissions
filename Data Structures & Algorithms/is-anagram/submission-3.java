class Solution {
    public boolean isAnagram(String s, String t) {
        final var sMap = new HashMap<Character, Integer>();
        for(var a: s.toCharArray()) {
            sMap.merge(a, 1, Integer::sum);
        };

        for(var a: t.toCharArray()) {
            sMap.merge(a, -1, Integer::sum);
        }

        return sMap.values().stream().allMatch(i -> i == 0);

    }
}
