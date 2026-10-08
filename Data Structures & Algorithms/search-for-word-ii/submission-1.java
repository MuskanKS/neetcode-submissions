class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(
        char[][] board,
        String[] words
    ) {

        // 1. Build Trie
        for (String word : words) {
            insert(word);
        }

        List<String> result = new ArrayList<>();

        // 2. Start DFS from every cell
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root, result);
            }
        }

        return result;
    }

    private void insert(String word) {

        TrieNode curr = root;

        for (char ch : word.toCharArray()) {

            int idx = ch - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }

            curr = curr.children[idx];
        }

        curr.word = word;
    }

    private void dfs(
        char[][] board,
        int r,
        int c,
        TrieNode node,
        List<String> result
    ) {

        // Outside board
        if (r < 0 || r >= board.length ||
            c < 0 || c >= board[0].length) {
            return;
        }

        // Already used
        if (board[r][c] == '#') {
            return;
        }

        char ch = board[r][c];

        int idx = ch - 'a';

        // No word in Trie can be formed from this path
        if (node.children[idx] == null) {
            return;
        }

        // Move into Trie
        node = node.children[idx];

        // We found a complete word
        if (node.word != null) {
            result.add(node.word);

            // Prevent adding same word again
            node.word = null;
        }

        // Mark current board cell as visited
        board[r][c] = '#';

        // Explore 4 directions
        dfs(board, r - 1, c, node, result); // up
        dfs(board, r + 1, c, node, result); // down
        dfs(board, r, c - 1, node, result); // left
        dfs(board, r, c + 1, node, result); // right

        // Backtrack
        board[r][c] = ch;
    }
}