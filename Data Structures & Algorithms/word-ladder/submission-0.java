class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // put word list into a hash set for look up
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        int counter = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return counter;
                }

                // generate neighbouts of word, enqueue unvisistrd ones in the set
                char[] chars = word.toCharArray();
                for (int j = 0; j<chars.length;j++) {
                    char original = chars[j];
                    for (char c= 'a'; c <= 'z';c++) {
                        chars[j] = c;
                        String next = new String(chars);
                        if(set.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            queue.add(next);
                        }
                    }
                    chars[j] = original;
                }
            }
            counter++;
        }

        return 0;
    }
}
