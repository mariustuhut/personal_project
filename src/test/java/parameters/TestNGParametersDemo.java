package parameters;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParametersDemo {

    @Test
    @Parameters({"MyName", "age"})
    public void test(@Optional String name, String age) {
        System.out.println("My name is: " + name);
        System.out.println("Years old: " + age);

    }
}
