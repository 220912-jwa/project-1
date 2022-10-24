package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.page;
import org.openqa.selenium.Keys;
import runner.WikiRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.util.Locale;

public class loginStepImpl {
    //Step Implementation

    public WebDriver driver = WikiRunner.driver;
    public page page = WikiRunner.page;


    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        // driver.get("url") will load a webpage in our automated browser
        driver.get("http://localhost:8080/");
    }

    @When("The employee types {string} into username input")
    public void the_employee_types_into_username_input(String string) {
        //usernameBox is giving me grief
        driver.findElement(By.xpath(
                "//*[@id=\"username\"]")).sendKeys(string + Keys.TAB);
    }

    @When("The employee types {string} into password input")
    public void the_employee_types_into_password_input(String string) {
        driver.findElement(By.xpath(
                "//*[@id=\"password\"]")).sendKeys(string + Keys.TAB);
    }

    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {

        driver.findElement(By.xpath(
                "//*[@id=\"loginButton\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlContains("home"));
    }


    @Then("The employee should see their name {string} on the home page")
    public void the_employee_should_see_their_name_on_the_home_page(String string) {
        String is = driver.findElement(By.xpath(
                "//*[@id=\"welcomeHeader\"]")).getText();

        int test = 1;
        if(is.contains(string)){
            test = 0;
        }
        Assert.assertEquals(test, 0);
    }
}
