package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import pages.LoginPage;

public class LoginSteps {
    WebDriver driver;
    LoginPage define;

    @Given("User is on the OrnageHRm login page")
    public void userIsOnTheOrnageHRmLoginPage() {
        driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        define=new LoginPage(driver);
    }

    @When("User enters valid credentials")
    public void userEntersValidCredentials() throws InterruptedException {
        Thread.sleep(2000);
        define.enterUsername("Admin");
        define.enterPassword("admin123");
        define.clickLogin();

    }

    @Then("User should be redirected to the dashboard")
    public void userShouldBeRedirectedToTheDashboard() {
        driver.quit();
    }

}
