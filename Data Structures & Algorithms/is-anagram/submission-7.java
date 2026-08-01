class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (Character a : s.toCharArray()) {
            mapS.merge(a, 1, Integer::sum);
        }

        for (Character a : t.toCharArray()) {
            mapT.merge(a, 1, Integer::sum);
        }

        return mapS.equals(mapT);
    }
}
