class Solution {
    public boolean isAnagram(String s, String t) {
        // take two hashmaps one for each string and add char and count to map
        // compare both maps
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (char c : s.toCharArray()) {
            mapS.merge(c, 1, Integer::sum);
        }

        for (char c : t.toCharArray()) {
            mapT.merge(c, 1, Integer::sum);
        }

        return mapS.equals(mapT);
    }
}
