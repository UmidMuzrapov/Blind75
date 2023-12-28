class Node{
    Node children[] = new Node[26];
    boolean end = false;
}

class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node cur = root;
        char[] wordChars = word.toCharArray();
        for (char ch: wordChars){

            if (cur.children[ch-'a'] == null){
                Node newNode= new Node();
                cur.children[ch - 'a'] = newNode;
            }

            cur = cur.children[ch-'a'];
        }

        cur.end = true;
    }
    
    public boolean search(String word) 
    {
        Node cur = root;
        char[] wordChars = word.toCharArray();
        for (char ch: wordChars){
            if (cur.children[ch -'a'] == null){
                return false;
            }

            cur = cur.children[ch -'a'];
        }

        return cur.end;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        char[] wordChars = prefix.toCharArray();

        for (char ch: wordChars){
            if (cur.children[ch-'a'] == null){
                return false;
            }

            cur = cur.children[ch -'a'];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
