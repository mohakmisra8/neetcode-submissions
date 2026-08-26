class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> res = new ArrayList<>();

        for(int r = 0; r< board.length;r++) {
            for(int c = 0; c< board[0].length;c++) {
                dfs(board, r, c, root, res);
            }
        }
        return res;

        
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> res) {
        if(r <0 || r >= board.length || c <0 || c >= board[0].length) {
            return;
        }

        char ch = board[r][c];
        if(ch == '#' || node.children[ch-'a'] == null) {
            return;
        }

        node = node.children[ch-'a'];
        if(node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        board[r][c] = '#'; 
        dfs(board, r+1, c, node, res);
        dfs(board, r-1, c, node, res);
        dfs(board, r, c+1, node, res);
        dfs(board, r, c-1, node, res);
        board[r][c] = ch;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String w: words) {
            TrieNode node = root;
            for(char c: w.toCharArray()) {
                if(node.children[c - 'a'] == null) {
                    node.children[c-'a'] = new TrieNode();
                }
                node = node.children[c-'a'];
            }
            node.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }
}
