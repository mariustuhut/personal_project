package grouping;

import org.testng.annotations.Test;

@Test(groups = {"AllClassTests"})
public class TestNGGroupsDemo {

    @Test(groups = "windows.only")
    public void test1(){
        System.out.println(" This is test 1 ");
    }

    @Test(groups = "windows.smoke")
    public void test2(){
        System.out.println(" This is test 2 ");
    }

    @Test(groups = {"linux.only" })
    public void test3(){
        System.out.println(" This is test 3 ");
    }

    @Test(groups = {"whatever", "example"})
    public void test4(){
        System.out.println(" This is test 4 ");
    }
}
