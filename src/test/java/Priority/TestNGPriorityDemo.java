package Priority;

import org.testng.annotations.Test;

public class TestNGPriorityDemo {

    @Test
    public void one(){
        System.out.println("Executing TEST 1");
    }

    @Test(priority = 1)
    public void two(){
        System.out.println("Executing TEST 2");
    }

    @Test(priority = 2)
    public void three(){
        System.out.println("Executing TEST 3");
    }
}
