package Data;

public class WordDictionary {
	public TrieNode root;
    private int point = 26;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        addWordHelper(word, 0, root);
    }
    
    public void addWordHelper(String word, int pos, TrieNode curr){
        if(pos == word.length()) return;
        if(curr.children[point] == null){
            curr.children[point] = new TrieNode();
        }
        addWordHelper(word, pos + 1, curr.children[point]);
        
        char c = word.charAt(pos);
        if (curr.children[c - 'a'] == null){
            curr.children[c - 'a'] = new TrieNode();
        }
        addWordHelper(word, pos + 1, curr.children[c - 'a']);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchWordHelper(word, 0, root);
    }
    
    private boolean searchWordHelper(String word, int pos, TrieNode curr){
        if(pos == word.length()) return true;
        char c = word.charAt(pos);
        if(c == '.'){
            if(curr.children[point] == null) return false;
            return searchWordHelper(word, pos + 1, curr.children[point]);
        }
        else{
            if(curr.children[c - 'a'] == null) return false;
            return searchWordHelper(word, pos + 1, curr.children[c - 'a']);
        }
    }
}
