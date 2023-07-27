package Day02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Assertions {

    @Test
    void test1(){
        String str1 = "John";
        String str2 = "John";

        Assert.assertEquals(str1,str2,"They are not equal"); // Checks if two values are the same
    }

    @Test
    void test2(){
        String str1 = "John";
        String str2 = "John1";

        Assert.assertEquals(str1,str2,"They are not equal"); // Checks if two values are the same
    }

    @Test
    void test3(){
        int num1 = 12;
        int num2 = 34;

        Assert.assertNotEquals(num1,num2,"They are equal"); // Checks if two values are not the same
    }

    @Test
    void test4(){
        int num1 = 12;
        int num2 = 12;

        Assert.assertNotEquals(num1,num2,"They are equal"); // Checks if two values are not the same
    }

    @Test
    void test5(){
        int num1 = 12;
        int num2 = 12;

        Assert.assertTrue(num1==num2,"It is false"); // Checks if the boolean statement is true
    }

    @Test
    void test6(){
        int num1 = 12;
        int num2 = 45;

        Assert.assertTrue(num1==num2,"It is false"); // Checks if the boolean statement is true
    }

    @Test
    void test7(){
        String str = "John";

        Assert.assertNull(str,"It is null"); // Checks if an object is null
    }

    @Test
    void test8(){
        String str = null;

        Assert.assertNull(str,"It is null"); // Checks if an object is null
    }

    @Test
    void test9(){

        Assert.fail("Test failed"); // It throws an exception no matter what
    }



}