class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i< wordsDict.length;i++) {
            map.computeIfAbsent(wordsDict[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> w1 = map.get(word1);
        List<Integer> w2 = map.get(word2);

        int i = 0, j = 0, min = Integer.MAX_VALUE;

        while (i < w1.size() && j < w2.size()) {
            min = Math.min(min, Math.abs(w1.get(i) - w2.get(j)));
            if(w1.get(i) < w2.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return min;

        
    }
}
