import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    private final String emptyFile="empty.txt";
    private final String emptyFilePath=" ";
    private final String smallFile="test.txt";
    private final String bigFile="words.txt";

    @Test
    public void testFiles(){
        Main alg = new Main();
        alg.doAlgorithm(emptyFile);
        alg.doAlgorithm(emptyFilePath);
        alg.doAlgorithm(smallFile);
        alg.doAlgorithm(bigFile);
    }
    @Test
    public void testAlgotithm(){
        Main alg = new Main();
        alg.doAlgorithm(emptyFile);
        Assert.assertEquals(0,alg.maxLength);
        alg.doAlgorithm(smallFile);
        Assert.assertEquals(3,alg.count);
    }

}
