package Day6.xmlFiles;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _01_DataProvider {
    @Test (dataProvider = "usernameList")
    void test1(String username){
        System.out.println("Test 1 is running for username =" + username);
    }
    @Test (dataProvider = "credentials")
    void test2(String username, String password){
        System.out.println("Test 2 is started");
        System.out.println("Test 2 is running for username =" + username + " and password = " + password);
        System.out.println("Test 2 is completed");
    }
    @Test (dataProvider = "credentialsList") // we can call same dataProvider from different tests
    void test3(String username, String password){
        System.out.println("Test 2 is started");
        System.out.println("Test 2 is running for username =" + username + " and password = " + password);
        System.out.println("Test 2 is completed");
    }

    @DataProvider
    public Object[][] usernameList (){
        Object[][] usernames = {
                {"John"},
                {"George"},
                {"Jessica"}
        };
        return usernames;
    }
    @DataProvider(name = "credentialsList") // we can give a name adn use it instead of method name
    public Object[][] credentials (){
        Object[][] credentials = {
                {"John","John1234"},
                {"George","George1234"},
                {"Jessica", "JessicaJessica1"}
        };
        return credentials;
    }
}
