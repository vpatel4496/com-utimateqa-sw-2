package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // Click on Sign In
        WebElement signIn = driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        signIn.click();

        // Verify the text
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]")).getText();
    }

    @Test
    public void verifyTheErrorMessage() {

        WebElement signIn = driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        signIn.click();

        // Enter Invalid username
        WebElement username = driver.findElement(By.id("user[email]"));
        username.sendKeys("xyz@gmail.com");

        // Enter Invalid Password
        WebElement password = driver.findElement(By.name("user[password]"));
        password.sendKeys("SuperSecret1");

        // Click on Sign In Button
        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();

        // Verify the error message

        String expectedMessage = "Invalid email or password.";
        String actualMessage = driver.findElement(By.className("form-error__list-item")).getText();

        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @After
    public void tearDown() {
        //   closeBrowser();
    }
}