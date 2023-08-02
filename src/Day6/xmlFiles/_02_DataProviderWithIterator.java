package Day6.xmlFiles;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _02_DataProviderWithIterator {

    @Test(dataProvider = "dataList")
    void test1(String username){
        System.out.println("username " + username);
    }


    @DataProvider
    public Iterator<Object[]>  dataList(){
        List<Object[]> myData = new ArrayList<>();
        myData.add(new Object[]{"John"});
        myData.add(new Object[]{"George"});
        myData.add(new Object[]{"Jessica"});
        return myData.iterator();
    }


}
