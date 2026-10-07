class WordDictionary {

    class Node {
        Node[] child = new Node[26];
        boolean isEndOfWord = false;
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {

        Node curr = root;

        for (char ch : word.toCharArray()) {

            int idx = ch - 'a';

            if (curr.child[idx] == null) {
                curr.child[idx] = new Node();
            }

            curr = curr.child[idx];
        }

        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    private boolean searchHelper(Node curr, String word, int index) {

        // We have processed the entire word
        if (index == word.length()) {
            return curr.isEndOfWord;
        }

        char ch = word.charAt(index);

        // Case 1: normal character
        if (ch != '.') {

            int idx = ch - 'a';

            // Required path doesn't exist
            if (curr.child[idx] == null) {
                return false;
            }

            // Move to next node
            return searchHelper(
                curr.child[idx],
                word,
                index + 1
            );
        }

        // Case 2: '.'
        // Try every possible child
        for (int i = 0; i < 26; i++) {

            if (curr.child[i] != null) {

                if (searchHelper(
                        curr.child[i],
                        word,
                        index + 1)) {

                    return true;
                }
            }
        }

        return false;
    }
}