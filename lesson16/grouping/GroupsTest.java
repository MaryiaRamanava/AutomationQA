package lesson16.grouping;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupsTest {

    @Test(priority = 1, groups = {"first"})
    public void one(){
        Assert.assertTrue(true);
    }

    @Test(priority = 2, groups = {"second"})
    public void two(){
        Assert.assertTrue(true);
    }

    @Test(priority = 3, groups = {"first"})
    public void three(){
        Assert.assertTrue(true);
    }

    @Test(priority = 4, groups = {"second"})
    public void four(){
        Assert.assertTrue(true);
    }

    @Test(priority = 5, groups = {"first"})
    public void five(){
        Assert.assertTrue(true);
    }

    @Test(priority = 6, groups = {"second"})
    public void six(){
        Assert.assertTrue(true);
    }

    @Test(priority = 7, groups = {"first"})
    public void seven(){
        Assert.assertTrue(true);
    }

    @Test(priority = 8, groups = {"second"})
    public void eight(){
        Assert.assertTrue(true);
    }
}
