class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }

        Map<String, Set<String>> wordSimilarToWords = new HashMap<>();

        for(List<String> pair:similarPairs) {
            wordSimilarToWords.computeIfAbsent(pair.get(0), value->new HashSet<String>()).add(pair.get(1));
            wordSimilarToWords.computeIfAbsent(pair.get(1), value->new HashSet<String>()).add(pair.get(0));
        }

        for(int i =0;i<sentence1.length;i++) {
            if(sentence1[i].equals(sentence2[i])) {
                continue;
            }

            if(wordSimilarToWords.containsKey(sentence1[i])
            && wordSimilarToWords.get(sentence1[i]).contains(sentence2[i])) {
                continue;
            }
            return false;
        }
        return true;

    }
}
