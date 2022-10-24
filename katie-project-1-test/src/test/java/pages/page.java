package pages;

//runner and pages file copied directly from demos and not all the way edited yet
import runner.WikiRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class page {

    // This class represents the web page that we will be automating (in case of project 1 => the html pages that you create)
    // This class is what we call a POM (Page Object Model) ** not to be confused with pom.xml -> project object model

    // we'll need an instance of our Driver
    public WebDriver driver = WikiRunner.driver;


    // a constructor to create an instance of this Page
    // and also initialize the web elements on the page using the PageFactory
    public page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // We can locate and initialize the elements by making them instance variables of this class

}
