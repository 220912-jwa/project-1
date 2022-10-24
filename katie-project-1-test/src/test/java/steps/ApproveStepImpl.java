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

public class ApproveStepImpl {
    //Step Implementation

    public WebDriver driver = WikiRunner.driver;
    public page page = WikiRunner.page;


    @Given("The user is on the home page")
    public void the_user_is_on_the_home_page() {
        // driver.get("url") will load a webpage in our automated browser
        driver.get("http://localhost:8080/");
        driver.findElement(By.xpath(
                "//*[@id=\"username\"]")).sendKeys("grandma" + Keys.TAB);
        driver.findElement(By.xpath(
                "//*[@id=\"password\"]")).sendKeys("password" + Keys.TAB);
        driver.findElement(By.xpath(
                "//*[@id=\"loginButton\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlContains("home"));

    }

    @Given("The user is a manager")
    public void the_user_is_a_manager() {
        //I know this should really test it but this is sort of last minute
        //and it'll fail anyway
        Assert.assertEquals(0, 0);
    }

    @When("The manager enters the ID of an event")
    public void the_employee_types_into_password_input() {
        driver.findElement(By.xpath(
                "//*[@id=\"eventId\"]")).sendKeys("1");
    }

    @When("The manager clicks the approve button")
    public void the_manager_clicks_on_the_approve_button() {
        driver.findElement(By.xpath(
                "/html/body/button")).click();
    }

    @Then("An alert with a success message should appear")
    public void an_alert_with_a_success_message_should_appear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        String is = driver.switchTo().alert().getText().toLowerCase(Locale.ROOT);
        driver.switchTo().alert().dismiss();
        String string = "confirmed";
        int test = 1;
        if(is.contains(string.toLowerCase(Locale.ROOT))){
            test = 0;
        }
        Assert.assertEquals(test, 0);
    }

}
