package api.auto.test;

import org.testng.TestNG;
import java.util.Arrays;

public class TestRunner {
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        testng.setTestSuites(Arrays.asList("src/test/resources/testng.xml"));
        testng.run();
    }
}
