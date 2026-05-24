class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final var map = new HashMap<String, List<String>>();

        for(var s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
