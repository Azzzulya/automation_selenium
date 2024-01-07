package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class orange_Steps {
    private WebDriver driver;

    @Before("@orange")
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After("@orange")
    public void tearDown() {
        driver.quit();
    }

    @Given("I access Website OrangeHRM")
    public void i_access_website_orange_hrm() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("I enter a username {string}")
    public void i_enter_a_username(String string) {
        driver.findElement(By.xpath("(//input[@placeholder='Username'])[1]")).sendKeys(string);
    }

    @And("I enter a password {}")
    public void i_enter_a_password_admin123(String password) {
        driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys(password);
    }
    @And("I click a login button")
    public void i_click_a_login_button() {
        driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).click();
    }
    @Then("Should be presented homepage")
    public void should_be_presented_homepage() {
        WebElement login_Homepage = driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Dashboard'])[1]"));
        Assert.assertEquals(login_Homepage.getText(), "Dashboard");
    }

    @When("I click a user dropdown")
    public void i_click_a_user_dropdown() {
        driver.findElement(By.xpath("(//span[@class='oxd-userdropdown-tab'])[1]")).click();
    }
    @When("I click a logout")
    public void i_click_a_logout() {
        driver.findElement(By.xpath("(//a[normalize-space()='Logout'])[1]")).click();
    }
    @Then("Should be presented login page")
    public void should_be_presented_login_page() {
        WebElement login_page = driver.findElement(By.xpath("(//h5[normalize-space()='Login'])[1]"));
        Assert.assertEquals(login_page.getText(), "Login");
    }


    @When("I click MyInfo")
    public void i_click_my_info() {
        driver.findElement(By.xpath("(//span[normalize-space()='My Info'])[1]")).click();
    }

    @When("I click personal details")
    public void i_click_personal_details() {
        driver.findElement(By.xpath("(//a[normalize-space()='Personal Details'])[1]")).click();
    }

    @When("I enter a nickname")
    public void i_enter_a_nickname() {
        driver.findElement(By.xpath("(//input)[5]")).sendKeys("TestNickname");
    }

    @Then("Nickname should be update")
    public void nickname_should_be_update() {
        WebElement nickname_Update = driver.findElement(By.xpath("(//input)[5]"));
        Assert.assertEquals(nickname_Update.getText(), "TestNickname");
    }


    @When("I click contact details")
    public void i_click_contact_details() {
        driver.findElement(By.xpath("(//a[normalize-space()='Contact Details'])[1]")).click();
    }

    @When("I enter a city")
    public void i_enter_a_city() {
        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[4]")).sendKeys("Jakarta");
    }

    @Then("City should be update")
    public void city_should_be_update() {
        WebElement city_Update = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[4]"));
        Assert.assertEquals(city_Update.getText(), "Jakarta");
    }

}
