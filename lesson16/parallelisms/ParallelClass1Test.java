package lesson16.parallelisms;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ParallelClass1Test {

    @Test
    public void parallel1() throws InterruptedException{
        Thread.sleep(2000);
        Assert.assertTrue(true);
    }

    @Test
    public void parallel2() throws InterruptedException{
        Thread.sleep(2000);
        Assert.assertTrue(true);
    }

    @Test
    public void parallel3() throws InterruptedException{
        Thread.sleep(2000);
        Assert.assertTrue(true);
    }

    @Test
    public void parallel4() throws InterruptedException{
        Thread.sleep(2000);
        Assert.assertTrue(true);
    }

    @Test
    public void parallel5() throws InterruptedException{
        Thread.sleep(2000);
        Assert.assertTrue(true);
    }
}
