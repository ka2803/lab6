package core;

import java.util.LinkedList;
import java.util.List;

// Helper data structure for class LongestCompoundWord
// each node, which contains a letter as its value,
// in trie may have a list of chlidren nodes
// Trie is also able to find all suffixes indices of a word

public class Trie {


    private TrieNode root;
    private TrieNode currentElement;

    public Trie() {
        root = new TrieNode(' ');	// root
        currentElement = root;
    }

    // addWord a word to trie
    public void addWord(String s) {
        char letter;
        currentElement = root;

        // traverse every letter of a word
        // update trie if a letter is not in the structure
        for (int i = 0; i < s.length(); i++) {
            letter = s.charAt(i);

            if (!currentElement.containsChild(letter)) {
                currentElement.addChild(letter);
            }

            currentElement = currentElement.getChild(letter);
        }

        // mark last letter as the end of a word
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
    // return starting indices of all suffixes of a word
    public List<Integer> getSuffixesStartIndices(String s) {
        List<Integer> indices = new LinkedList<Integer>();	// store indices
        char letter;
        currentElement = root;	// start from root

        for (int i = 0; i < s.length(); i++) {
            letter = s.charAt(i);

            // if the current letter doesn't have one letter as child
            // which means trie currently doesn't have the relationship
            // returns indices of suffixes
            if (!currentElement.containsChild(letter))
                return indices;

            // move on to the child node
            currentElement = currentElement.getChild(letter);

            // if the letter is an end to a word, it means after the letter is a suffix
            // update indices
            if (currentElement.isEndOfWord)
                indices.add(i + 1);
        }

        return indices;
    }

}
