import core.ValuePair;
import core.Trie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {


    private final double BYTES_IN_MEGABYTE = 1048576.0;
    public int maxLength = 0;

    public String longest = "";
    public String sec_longest = "";
    public int count=0;
    public double nanoSecondsInSeconds(long nanoSeconds){
        return nanoSeconds*Math.pow(10, -9);
    }

    public double bytesToMBytes(long bytes){
        return bytes / BYTES_IN_MEGABYTE;
    }
    public void doAlgorithm(String filepath){

        File file = new File(filepath);
        Trie trie = new Trie();
        LinkedList<ValuePair<String>> queue = new LinkedList<ValuePair<String>>();
        HashSet<String> compoundWords = new HashSet<String>();
        Scanner s = null;
        try {
            s = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        String word;				// a word
        List<Integer> sufIndices;	// indices of suffixes of a word

        while (s.hasNext()) {
            word = s.next();
            sufIndices = trie.getSuffixesStartIndices(word);

            for (int i : sufIndices) {
                if (i >= word.length())
                    break;
                queue.add(new ValuePair<String>(word, word.substring(i)));
            }

            trie.addWord(word);
        }

        ValuePair<String> p;
        maxLength = 0;
        longest = "";
        sec_longest = "";
        while (!queue.isEmpty()) {
            p = queue.removeFirst();
            word = p.getSecond();

            sufIndices = trie.getSuffixesStartIndices(word);


            if (sufIndices.isEmpty()) {
                continue;
            }


            for (int i : sufIndices) {
                if (i > word.length()) {
                    break;
                }

                if (i == word.length()) {
                    if (p.getFirst().length() > maxLength) {

                        sec_longest = longest;
                        maxLength = p.getFirst().length();
                        longest = p.getFirst();
                    }

                    compoundWords.add(p.getFirst());

                } else {
                    queue.add(new ValuePair<>(p.getFirst(), word.substring(i)));
                }
            }
        }
        count=compoundWords.size();


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
        Main alg = new Main();
        alg.doAlgorithm("words.txt");
        finishTime = System.nanoTime();
        measureTimeInSeconds = alg.nanoSecondsInSeconds(finishTime - startTime);
        System.out.println("Time: " + measureTimeInSeconds + " s");
        finishMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        resultMBytes = alg.bytesToMBytes(finishMemory - startMemory);
        System.out.println("Memory: " + resultMBytes + " Mb");

    }
}
