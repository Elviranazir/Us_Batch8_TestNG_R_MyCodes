package Day6.xmlFiles;

import org.testng.annotations.Test;

public class _03_DataProviderFromDifferentClass {
    @Test (dataProvider = "credentialsList", dataProviderClass = _01_DataProvider.class)
    void test1(String username, String password){
        System.out.println("Test 1 is started");
        System.out.println("Test 1 is running for username =" + username + " and password = " + password);
        System.out.println("Test 1 is completed");
    }
}
