class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        // create hashmap where each key is the sorted version of a string
        // value in the list of strings belongs the group
        // iterate through list
            // sort characters of the string to form a key
            // append the original string to the list corresponding to the key
        Map<String, List<String>> res = new HashMap<>();

        for(String s: strs) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);

            String sortedS = new String(charArr);

            res.putIfAbsent(sortedS, new ArrayList<>());

            res.get(sortedS).add(s);
        }

        return new ArrayList<>(res.values());
        
        
    }
}
