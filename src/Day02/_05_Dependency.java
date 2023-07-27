package Day02;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _05_Dependency {

    @Test
    void startEngine(){
        System.out.println("Engine is started");
//        Assert.fail();
    }

    @Test(dependsOnMethods = "startEngine")  // This test depends on startEngine test
    void driveCar(){
        System.out.println("Car is being driven");
//        Assert.fail();
    }

    @Test(dependsOnMethods = {"driveCar","startEngine"}) // This test depends on both startEngine and driveCar tests
    void parkCar(){
        System.out.println("Car cis parked");
    }

    @Test(dependsOnMethods = {"driveCar","startEngine","parkCar"})
    void stopCar(){
        System.out.println("Car is stopped");
    }
}