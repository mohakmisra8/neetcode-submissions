class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final var map = new HashMap<String, List<String>>();
        for(var s: strs) {
          char[] c = s.toCharArray();
          Arrays.sort(c);
          final var key = new String(c);

          map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
