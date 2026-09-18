class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    String word = null;

    public TrieNode() {
    }
}

class Solution {

    char[][] fullboard;
    ArrayList<String> ans = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = new TrieNode();

        // Build Trie
        for (String word : words) {

            TrieNode node = root;

            for (char letter : word.toCharArray()) {

                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                }
                else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }

            node.word = word;
        }

        this.fullboard = board;

        // Start DFS from every cell
        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[0].length; col++) {

                if (root.children.containsKey(board[row][col])) {
                    backtracking(row, col, root);
                }
            }
        }

        return ans;
    }


    public void backtracking(int row, int col, TrieNode parent) {

        Character letter = fullboard[row][col];

        TrieNode currNode = parent.children.get(letter);

        // Found a complete word
        if (currNode.word != null) {
            ans.add(currNode.word);
            currNode.word = null;
        }

        // Mark current cell as visited
        fullboard[row][col] = '#';

        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};

        // Explore 4 directions
        for (int i = 0; i < 4; i++) {

            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];

            if (newRow >= 0 && newRow < fullboard.length &&
                newCol >= 0 && newCol < fullboard[0].length &&
                fullboard[newRow][newCol] != '#' &&
                currNode.children.containsKey(fullboard[newRow][newCol])) {

                backtracking(newRow, newCol, currNode);
            }
        }

        // Unmark when coming back
        fullboard[row][col] = letter;
    }
}