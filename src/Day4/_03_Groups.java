package Day4;

import org.testng.annotations.Test;

public class _03_Groups {
    @Test(groups = "smokeTest")
    void test1() {
        System.out.println("Test 1 is running!");
    }

    @Test(groups = "regressionTest")
    void test2() {
        System.out.println("Test 2 is running!");
    }

    @Test
    void test3() {
        System.out.println("Test 3 is running!");
    }

    @Test(groups = "smokeTest")
    void test4() {
        System.out.println("Test 4 is running!");
    }

    @Test(groups = "regressionTest")
    void test5() {
        System.out.println("Test 5 is running!");
    }

    @Test(groups = {"smokeTest","regressionTest"})
    void test6() {
        System.out.println("Test 6 is running!");
    }
}

