import core.Trie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrieTest {
    Trie testTrie;
     String[] defautStringsToTrie=new String[]{
            "cat",
            "cats",
            "catsdogcats",
            "dog",
            "dogcatsdog",
            "hippopotamuses",
            "rat",
            "ratcatdogcat"
    };
    final String testString="ratcatdogcat";

    List<Integer> indices;
    @Before
    public void Init(){
        Arrays.sort(defautStringsToTrie);
        testTrie = new Trie();
        for(String s:defautStringsToTrie){
            testTrie.addWord(s);
        }
        indices=new ArrayList<>();
    }
    @Test
    public void getIndicesTest(){
        Assert.assertNotEquals(indices,testTrie.getSuffixesStartIndices(testString));
        indices = new ArrayList<Integer>();
        indices.add(3);
        indices.add(12);
        List<Integer> test = testTrie.getSuffixesStartIndices(testString);
        Assert.assertEquals(indices,testTrie.getSuffixesStartIndices(testString));
    }

    @Test
    public void addTest(){
        testTrie.addWord("WORD");
        Assert.assertEquals(true,testTrie.containsWord("WORD"));
        Assert.assertEquals(false,testTrie.containsWord("adadsa"));
    }


}
