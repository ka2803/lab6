package core;

import java.util.LinkedList;
import java.util.List;


public class Trie {


    private TrieNode root;
    private TrieNode currentElement;

    public Trie() {
        root = new TrieNode(' ');	// root
        currentElement = root;
    }


    public void addWord(String s) {
        char letter;
        currentElement = root;


        for (int i = 0; i < s.length(); i++) {
            letter = s.charAt(i);

            if (!currentElement.containsChild(letter)) {
                currentElement.addChild(letter);
            }

            currentElement = currentElement.getChild(letter);
        }


        currentElement.isEndOfWord = true;
    }
    public boolean containsWord(String word){
        char letter;
        currentElement = root;
        for (int i = 0; i < word.length(); i++) {
            letter = word.charAt(i);

            if (!currentElement.containsChild(letter)) {
                return false;
            }

            currentElement = currentElement.getChild(letter);
        }
        if(currentElement.isEndOfWord)
            return true;
        return false;
    }

    public List<Integer> getSuffixesStartIndices(String s) {
        List<Integer> indices = new LinkedList<Integer>();
        char letter;
        currentElement = root;

        for (int i = 0; i < s.length(); i++) {
            letter = s.charAt(i);


            if (!currentElement.containsChild(letter))
                return indices;


            currentElement = currentElement.getChild(letter);


            if (currentElement.isEndOfWord)
                indices.add(i + 1);
        }

        return indices;
    }

}
