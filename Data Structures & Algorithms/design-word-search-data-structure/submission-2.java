class WordDictionary {

    class Custom {
        Custom[] child = new Custom[26];
        boolean isEndOfWord = false;
    }

    Custom root;

    public WordDictionary() {
        root = new Custom();
    }

    public void addWord(String word) {

        Custom curr = root;

        for (char ch : word.toCharArray()) {

            int idx = ch - 'a';

            if (curr.child[idx] == null) {
                curr.child[idx] = new Custom();
            }

            curr = curr.child[idx];
        }

        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    private boolean searchHelper(Custom curr, String word, int index) {

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