import core.KeyValuePair;
import core.Trie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class LongestCompoundWord {


    private final double BYTES_IN_MEGABYTE = 1048576.0;
    public int maxLength = 0;			// longest compound word length
    //int sec_maxLength = 0;		// getSecond longest compound word length
    public String longest = "";		// longest compound word
    public String sec_longest = "";
    public int count=0;
    public double nanoSecondsInSeconds(long nanoSeconds){
        return nanoSeconds*Math.pow(10, -9);
    }

    public double bytesToMBytes(long bytes){
        return bytes / BYTES_IN_MEGABYTE;
    }
    public void doAlgorithm(String filepath){
        // change file name accordingly
        File file = new File(filepath);

        // Trie
        Trie trie = new Trie();
        LinkedList<KeyValuePair<String>> queue = new LinkedList<KeyValuePair<String>>();

        // used to calculate the total amount of compound words
        HashSet<String> compoundWords = new HashSet<String>();

        // scan the file
        Scanner s = null;
        try {
            s = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        String word;				// a word
        List<Integer> sufIndices;	// indices of suffixes of a word

        // read words from the file
        // fill up the queue with words which have suffixes, who are
        // candidates to be compound words
        // addWord each word in trie
        while (s.hasNext()) {
            word = s.next();
            sufIndices = trie.getSuffixesStartIndices(word);

            for (int i : sufIndices) {
                if (i >= word.length())		// if index is out of bound
                    break;					// it means suffixes of the word has
                // been added to the queue if there is any
                queue.add(new KeyValuePair<String>(word, word.substring(i)));
            }

            trie.addWord(word);
        }

        KeyValuePair<String> p;				// a pair of word and its remaining suffix
       // getSecond longest compound word
        maxLength = 0;			// longest compound word length
        //int sec_maxLength = 0;		// getSecond longest compound word length
        longest = "";		// longest compound word
        sec_longest = "";
        while (!queue.isEmpty()) {
            p = queue.removeFirst();
            word = p.getSecond();

            sufIndices = trie.getSuffixesStartIndices(word);

            // if no suffixes found, which means no prefixes found
            // discard the pair and check the next pair
            if (sufIndices.isEmpty()) {
                continue;
            }

            //System.out.println(word);
            for (int i : sufIndices) {
                if (i > word.length()) { // sanity check
                    break;
                }

                if (i == word.length()) { // no suffix, means it is a compound word
                    // check if the compound word is the longest
                    // if it is update both longest and getSecond longest
                    // words records
                    if (p.getFirst().length() > maxLength) {
                        //sec_maxLength = maxLength;
                        sec_longest = longest;
                        maxLength = p.getFirst().length();
                        longest = p.getFirst();
                    }

                    compoundWords.add(p.getFirst());	// the word is compound word

                } else {
                    queue.add(new KeyValuePair<String>(p.getFirst(), word.substring(i)));
                }
            }
        }
        count=compoundWords.size();

        // print out the results
        System.out.println("Longest Compound Word: " + longest);
        System.out.println("Second Longest Compound Word: " + sec_longest);
        System.out.println("Total Number of Compound Words: " + compoundWords.size());
    }

    public static void main(String[] args) throws IOException {
        long startTime;
        long finishTime;
        long startMemory;
        long finishMemory;
        double measureTimeInSeconds;
        double resultMBytes;

        startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        startTime = System.nanoTime();
        LongestCompoundWord alg = new LongestCompoundWord();
        alg.doAlgorithm("words.txt");
        finishTime = System.nanoTime();
        measureTimeInSeconds = alg.nanoSecondsInSeconds(finishTime - startTime);
        System.out.println("Time: " + measureTimeInSeconds + " s");
        finishMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        resultMBytes = alg.bytesToMBytes(finishMemory - startMemory);
        System.out.println("Memory: " + resultMBytes + " Mb");

    }
}
