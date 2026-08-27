class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        TrieNode node = buildTrie(strs);
        int total = strs.length;

        while(true) {
            int childCount = 0;
            int childIndex = -1;
            for(int i = 0; i<26;i++) {
                if(node.children[i] != null) {
                    childCount++;
                    childIndex = i;
                }
            }

            if(childCount != 1 || node.isWord) {
                break;
            }
            sb.append((char) ('a' + childIndex));
            node = node.children[childIndex];
        }

        return sb.toString();
        
    }

    private TrieNode buildTrie(String[] strs) {
        TrieNode root = new TrieNode();
        for(String s: strs) {
            TrieNode node = root;
            for(char ch: s.toCharArray()) {
                if(node.children[ch- 'a'] == null) {
                    node.children[ch-'a'] = new TrieNode();
                }
                node = node.children[ch-'a'];
            }
            node.isWord = true;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }
}