package sergei.com.steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import sergei.utility.ConfigurationReader;
import sergei.utility.DB_Util;
import sergei.utility.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks  {

    @Before ("@ui")
    public void setUp(){

        System.out.println("this is coming from BEFORE");
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));


    }

    @After ("@ui")
    public void tearDown(Scenario scenario){
        System.out.println("this is coming from AFTER");

        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();

    }





    @Before ("@db")// custom/conditional Before tag to open connection before each scenario
    public void setUpDB(){
        DB_Util.createConnection();
        System.out.println("connection to DB");


    }

    @After("@db")// custom/conditional After tag to destroy connection after each scenario
    public void destroyBD(){
                DB_Util.destroy();
        System.out.println("connection destroyed");

    }

    //  @Before ("@db") @After("@db") that before  and after annotation will run if scenario have @db annotation, and those annotations will be runn only in those scenarios where we need connection to DB and dostroying of connection

}
