package runner;

//runner and pages file copied directly from demos and not all the way edited yet

import org.junit.BeforeClass;
import pages.page;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "steps")
public class WikiRunner {

    // We will need an instance of our WebDriver
    public static WebDriver driver;
    // and if we're using a Page Object Model - we'll need that as well
    public static page page;

    // and then we'll need a way to set it up and configure it before running our tests
    @BeforeClass // this is JUnit 4 (JUnit 5 equivalent is @BeforeAll)
    public static void setup() {
        // we instantiate our driver
        // 1. Set a system property to tell the driver Object where to locate the browserdriver we downloaded from the internet
        // Create a File Object
        File chrome = new File(
                "C:\\Users\\confu\\IdeaProjects\\katie-project-1\\katie-project-1-test\\src\\main\\resources\\chromedriver.exe");

        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());

        // instantiate driver and POM
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        page = new page(driver);
    }


    @AfterClass
    public static void teardown() {
        // clean up our resources
        driver.quit();
    }


}
