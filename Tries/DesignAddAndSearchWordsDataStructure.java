class Node{
    Node children[] = new Node[26];
    boolean end = false;
    boolean hasChildren = false;
}


class WordDictionary {

    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node cur = root;
        char[] wordChars = word.toCharArray();

        for (char ch: wordChars){

            if (cur.children[ch-'a'] == null){
                Node newNode= new Node();
                cur.children[ch - 'a'] = newNode;
                cur.hasChildren = true;
            }

            cur = cur.children[ch-'a'];
        }

        cur.end = true;
    }
    
    public boolean search(String word) {
       return helperSearch(0, word.length(), root, word);
    }

    public boolean helperSearch(int i, int length, Node root, String word){
        if (i>=length){
            return root.end;
        }

        char ch = word.charAt(i);

        if (ch == '.'){
            if (!root.hasChildren){
                return false;
            }

            for (int k = 0; k<26; k++){
                if (root.children[k]!=null){
                    boolean found = helperSearch(i+1, length, root.children[k], word);
                    if (found) return true;
                }
            }
            
            return false;
        }

        if (root.children[ch - 'a']!=null){
            return helperSearch(i+1, length, root.children[ch-'a'], word);
        }

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
