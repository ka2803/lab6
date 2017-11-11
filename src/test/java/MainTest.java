import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class MainTest {
    private final String emptyFile="empty.txt";
    private final String emptyFilePath=" ";
    private final String smallFile="test.txt";
    private final String bigFile="words.txt";

    @Test
    public void testFiles(){
        LongestCompoundWord alg = new LongestCompoundWord();
        alg.doAlgorithm(emptyFile);
        alg.doAlgorithm(emptyFilePath);
        alg.doAlgorithm(smallFile);
        alg.doAlgorithm(bigFile);
    }
    @Test
    public void testAlgotithm(){
        LongestCompoundWord alg = new LongestCompoundWord();
        alg.doAlgorithm(emptyFile);
        Assert.assertEquals(0,alg.maxLength);
        alg.doAlgorithm(smallFile);
        Assert.assertEquals(3,alg.count);
    }
//    @Test
//    public void bytesTest(){
//
//    }
//    @Test
//    public void nanoSecsTest(){
//
//    }
}
