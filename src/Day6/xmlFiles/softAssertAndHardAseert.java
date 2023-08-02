package Day6.xmlFiles;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssertAndHardAseert {
    @Test
    void hardAssert(){
        String str = "Hello";
        System.out.println("Before Assertion");
        Assert.assertEquals("Hello world", str,"Your test is failed!"); // Hard Assert
        //If actual and expected result are different it throws an exeption and doesn't run the rest of the code
        //Then Test TNG starts to run the next code
        System.out.println("After Assertion");
    }

    @Test
    void softAssert(){
        String strHomePage = "www.facebook.com/homepage";
        String strCardPage = "www.facebook.com/cardpage";
        String strEditAccount = "www.facebook.com/editaccountpage";

        SoftAssert softAssert = new SoftAssert();

        System.out.println("Before first assert");
        softAssert.assertEquals("www.facebook.com/homepage", strHomePage);
        System.out.println("After first assert");
        System.out.println("Before second assert");
        softAssert.assertEquals("www.facebook.com/profile", strCardPage);
        System.out.println("After second assert");
        System.out.println("Before third assert");
        softAssert.assertEquals("www.facebook.com/settings", strEditAccount);
        System.out.println("After third assert");

        softAssert.assertAll();


    }

}
