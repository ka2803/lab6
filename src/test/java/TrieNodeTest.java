import core.Trie;
import core.TrieNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrieNodeTest {

    final char testCharValue='a';
    @Before
    public void Init(){

    }

    @Test
    public void ctorTest(){
        TrieNode node = new TrieNode(testCharValue);
        Assert.assertEquals(testCharValue,node.val);
        Assert.assertEquals(false,node.isEndOfWord);
        Assert.assertEquals(true,node.children.isEmpty());
    }
    @Test
    public void containsTest(){
        TrieNode node = new TrieNode(testCharValue);
        Assert.assertEquals(false,node.containsChild(testCharValue));
        node.addChild(testCharValue);
        Assert.assertEquals(true,node.containsChild(testCharValue));
    }
    @Test
    public void addTest(){
        TrieNode node = new TrieNode(testCharValue);
        Assert.assertEquals(false,node.containsChild(testCharValue));
        node.addChild(testCharValue);
        Assert.assertEquals(true,node.containsChild(testCharValue));
    }
    @Test
    public void getTest(){
        TrieNode node = new TrieNode(testCharValue);
        Assert.assertNotEquals(new TrieNode('e'),node.getChild(testCharValue));
    }
}
