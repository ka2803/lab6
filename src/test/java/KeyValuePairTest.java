import core.KeyValuePair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KeyValuePairTest {
    KeyValuePair<String> KVP1;
    KeyValuePair<String> KVP2;
    String FirstTest1=" ";
    String FirstTest2="FIRST";
    String SecondTest1=" ";
    String SecondTest2="Second";
    @Before
    public void Initialize(){
        KVP1=new KeyValuePair<>(FirstTest1,SecondTest1);
        KVP2=new KeyValuePair<>(FirstTest2,SecondTest2);
    }
    @Test
    public void getFirstTest(){
        Assert.assertEquals(FirstTest1,KVP1.getFirst());
        Assert.assertNotEquals("rendomValue",KVP1.getFirst());
        Assert.assertEquals(FirstTest2,KVP2.getFirst());
        Assert.assertNotEquals("randomValue",KVP2.getFirst());
    }
    @Test
    public void getSecondTest(){
        Assert.assertEquals(SecondTest1,KVP1.getFirst());
        Assert.assertNotEquals("rendomValue",KVP1.getSecond());
        Assert.assertEquals(SecondTest2,KVP2.getSecond());
        Assert.assertNotEquals("randomValue",KVP2.getSecond());
    }
}
