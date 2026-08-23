class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();

    }

    public void addWord(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()) {
            int index = c-'a';
            if(node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;

    }


    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int i, TrieNode node) {
        if(node == null) {
            return false;
        }

        if(i == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(i);
        if(c=='.') {
            for(TrieNode child: node.children) {
                if(dfs(word, i+1, child)) {
                    return true;
                }
            }
            return false;
        } else{
            // fixed char: follow this one matching char
            return dfs(word, i+1, node.children[c-'a']);
        }

    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }
}
