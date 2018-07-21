package Data;

public class TestWordDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("word");
		wordDictionary.addWord("ab");
		System.out.println(wordDictionary.search("pattern"));
		System.out.println(wordDictionary.search("ab"));
		System.out.println(wordDictionary.search(".."));
		System.out.println(wordDictionary.search(".a"));
		System.out.println(wordDictionary.search(".b"));
		System.out.println(wordDictionary.search("..."));
	}

}
