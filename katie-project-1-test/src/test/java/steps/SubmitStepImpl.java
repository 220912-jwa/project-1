package steps;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.page;
import org.openqa.selenium.Keys;
import runner.WikiRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;



public class SubmitStepImpl {

    public WebDriver driver = WikiRunner.driver;
    public page page = WikiRunner.page;

    @Given("The user is on the submitEvent page")
    public void the_user_is_on_the_submitEvent_page() {
        driver.get("http://localhost:8080/");
        driver.findElement(By.xpath(
                "//*[@id=\"username\"]")).sendKeys("grandma" + Keys.TAB);
        driver.findElement(By.xpath(
                "//*[@id=\"password\"]")).sendKeys("password" + Keys.TAB);
        driver.findElement(By.xpath(
                "//*[@id=\"loginButton\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.urlContains("home"));

        driver.findElement(By.xpath(
                "/html/body/a")).click();
        wait.until(ExpectedConditions.urlContains("eventSubmission"));
    }

    @When("The employee types in 2 into the Event ID input")
    public void the_employee_types_in_into_the_event_id_input () {
        driver.findElement(By.xpath(
                "//*[@id=\"eName\"]")).sendKeys("2" + Keys.TAB);
    }

    @When("The employee types in yes into the Event Name input")
    public void the_employee_types_in_yes_into_the_event_name_input () {
        driver.findElement(By.xpath(
                "//*[@id=\"eID\"]")).sendKeys("yes" + Keys.TAB);
    }

    @When("The employee types in 100 into the cost input")
    public void the_employee_types_in_into_the_cost_input () {
        driver.findElement(By.xpath(
                "//*[@id=\"eCost\"]")).sendKeys("100" + Keys.TAB);
    }

    @When("The employee types in 1100 into the time input")
    public void the_employee_types_in_into_the_time_input () {
        driver.findElement(By.xpath(
                "//*[@id=\"eTime\"]")).sendKeys("1100" + Keys.TAB);
    }

    @When("The employee types in no into the description input")
    public void the_employee_types_in_no_into_the_description_input () {
        driver.findElement(By.xpath(
                "//*[@id=\"eDesc\"]")).sendKeys("no" + Keys.TAB);
    }

    @When("The employee types in no into the justification input")
    public void the_employee_types_in_no_into_the_justification_input () {
        driver.findElement(By.xpath(
                "//*[@id=\"justification\"]")).sendKeys("yes" + Keys.TAB);
    }

    @When("The employee types in no into the grading format input")
    public void the_employee_types_in_no_into_the_grading_format_input () {
        driver.findElement(By.xpath(
                "//*[@id=\"gradeDescription\"]")).sendKeys("yes" + Keys.TAB);
    }

    @When("The employee selects todays date for start date")
    public void the_employee_selects_todays_date_for_start_date () {
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date = dateObj.format(formatter);
        driver.findElement(By.xpath(
                "//*[@id=\"startDate\"]"))
                .sendKeys(date + Keys.TAB);
    }

    @When("The employee selects todays date for end date")
    public void the_employee_selects_todays_date_for_end_date () {
        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String date = dateObj.format(formatter);
        driver.findElement(By.xpath(
                "//*[@id=\"submitNewEvent\"]"))
                .sendKeys(date + Keys.TAB);
    }

    @When("The employee clicks submit")
    public void the_employee_clicks_submit () {
        driver.findElement(By.xpath(
                "//*[@id=\"eDesc\"]")).click();
    }

    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.alertIsPresent());

        //could be many messages
        String is = driver.switchTo().alert().getText().toLowerCase(Locale.ROOT);
        driver.switchTo().alert().dismiss();
        int test = 1;
        if(is.contains("wrong") && is.contains("password")){
            test = 0;
        }
        Assert.assertEquals(test, 0);
    }

}
