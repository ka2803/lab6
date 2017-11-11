package core;

import java.util.HashMap;

// inner class, only for the use of Trie
public class TrieNode {
    //@SuppressWarnings("unused")
    public char val;			// character stored in the node
    public HashMap<Character, TrieNode> children;	// map name of string to the node
    // which has the string as value
    public boolean isEndOfWord;		// if the node is at the end of a word

    // constructor
    public TrieNode(char val) {
        this.val = val;
        children = new HashMap<>();
        isEndOfWord = false;
    }

    // add child to trienode
    public void addChild(char child) {
        children.put(child, new TrieNode(child));
    }

    // get child of trienode that has the same character as the give one
    public TrieNode getChild(char child) {
        if (!children.keySet().contains(child)) {
            return null;
        }

        return children.get(child);
    }

    // return true if child exists
    public boolean containsChild(char child) {
        return children.keySet().contains(child);
    }
}

