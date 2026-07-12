class Solution {
    public boolean isAnagram(String s, String t) {
        // compare two sets one for set 1 and other for set 2
        // need to use a map and set the counts as well
        if(s.length() != t.length()) {
            return false;
        }
        final var mapS = new HashMap<Character, Integer>();
        final var mapT = new HashMap<Character, Integer>();

        for(char a: s.toCharArray()) {
            mapS.merge(a, 1 , Integer::sum);
        }

        for(char b: t.toCharArray()) {
            mapT.merge(b, 1 , Integer::sum);
        }

        return mapS.equals(mapT);

    }
}
