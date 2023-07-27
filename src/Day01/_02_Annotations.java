package Day01;

import org.testng.annotations.*;

public class _02_Annotations {
    @BeforeMethod // this will be run before each test method
    public void beforeMethod(){
        System.out.println("Before method is working");
    }
    @AfterMethod // this will be run after each test method
    public void afterMethod(){
        System.out.println("After method is working");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class is working!");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After class is working!");
    }

    @Test
    public void test1(){
        System.out.println("Test 1 is successful");
    }
    @Test
    public void test2(){
        System.out.println("Test 2 is successful");
    }
}