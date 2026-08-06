class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // early exit if end word is not set
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            // bfs ring loop -> while loop is not empty -> snapshot size
            // for size times -> poll a word -> if it is end word return level
            // we need to keep track of the ring sizes
            // adding next ring neighbours to the back of the same qwueue
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return level;
                }
                char[] arr = word.toCharArray();

                for(int j = 0; j< arr.length;j++) {
                    char original = arr[j];

                    for(char c = 'a'; c<= 'z'; c++) {
                        arr[j] = c;
                        String newWord = new String(arr);

                        if(words.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            queue.add(newWord);
                        }

                    }
                    arr[j] = original;
                }
            }

            level++;
        }

        return 0;
    }
}
