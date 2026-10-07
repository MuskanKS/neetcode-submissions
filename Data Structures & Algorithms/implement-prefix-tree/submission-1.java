class PrefixTree {
    class Custom{
        Custom[] child = new Custom[26];
        boolean isEndOfWord = false;
    }
    Custom root;


    public PrefixTree() {
        root = new Custom();
    }

    public void insert(String word) {
        Custom curr = root;

        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if(curr.child[idx] == null){
                curr.child[idx] = new Custom();
            }
            curr = curr.child[idx];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        Custom curr = root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a';

            if(curr.child[idx] == null){
                return false;
            }
            curr = curr.child[idx];
        }
        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        Custom curr = root;

        for(char ch : prefix.toCharArray()){
             int idx = ch - 'a';

        if(curr.child[idx] == null){
            return false;
        }

        curr = curr.child[idx];
        }
        return true;
    }
    
}
