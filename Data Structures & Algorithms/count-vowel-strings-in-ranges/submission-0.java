class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        int n = words.length;
        int[] prefixCount = new int[n+1];

        for(int i =0; i< n;i++) {
            String w = words[i];
            prefixCount[i+1] = prefixCount[i];

            if(set.contains(w.charAt(0)) && set.contains(w.charAt(w.length()-1))) {
                prefixCount[i+1]++;
            }
        }

        int[] res = new int[queries.length];
        for(int i =0;i<queries.length;i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            res[i] = prefixCount[r+1]-prefixCount[l];
        }
        return res;
    }
}