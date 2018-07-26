import org.junit.Assert;
import org.junit.Test;

/**
 * Created by asang002 on 7/26/2018.
 */
public class HelloWorldTest {

    HelloWorld helloWorld = new HelloWorld();

    @Test
    public void HelloWorldTest(){
        Assert.assertEquals(5,helloWorld.sum(2,3));

    }
}
