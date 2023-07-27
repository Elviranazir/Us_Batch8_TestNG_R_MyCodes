package Day4;

import org.testng.annotations.*;

public class _01_XMLIntro {
    /**
     * @BeforeSuit // Runs before every suit in XML file
     *  @BeforeTest // Runs before every test tag in xml file
     *      @BeforeGroup // runs before every Group annotation
     *          @BeforeClass // runs before every class
     *              @BeforeMethod // runs before every @Test annotation
     *                  @Test method  // we write our tests
     *                  @Test method  // we write our tests
     *              @AfterMethod // runs after every @Test annotation
     *          @AfterClass // runs after every class
     *      @AfterGroup // runs after every Group annotation
     *  @AfterTest // Runs after every test tag in xml file
     * @AfterSuit // Runs after every suit in XML file
     */


    @BeforeSuite
    void beforeSuit(){
        System.out.println("Before suit is working");
    }

    @AfterSuite
    void afterSuit(){
        System.out.println("After suit is working");
    }

    @BeforeTest
    void beforeTest(){
        System.out.println("Before test is working");
    }

    @AfterTest
    void afterTest(){
        System.out.println("After test is working");
    }
    @BeforeGroups
    void beforeGroups(){
        System.out.println("Before groups is working");
    }

    @AfterGroups
    void afterGroups(){
        System.out.println("Before groups is working");
    }

    @BeforeMethod // this will be run before each test method
    public void beforeMethod() {
        System.out.println("Before method is working");
    }

    @AfterMethod // this will be run after each test method
    public void afterMethod() {
        System.out.println("After method is working");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class is working");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class is working");
    }

    @Test
    public void test1() {
        System.out.println("_01_XMLIntro Test 1 is successful");
    }

    @Test
    public void test2() {
        System.out.println("_01_XMLIntro Test 2 is successful");
    }
}
