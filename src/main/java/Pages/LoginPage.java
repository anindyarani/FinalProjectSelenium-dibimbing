package Pages;

import org.apache.logging.log4j.LogManager;
import Core.BasePage;
import org.apache.logging.log4j.Logger;
//import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BasePage {

    private static final Logger log = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-username-or-email")
    private WebElement emailTextField;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordTextField;

    @FindBy(id = "button-sign-in")
    private WebElement loginButton;

    @FindBy(xpath = "//p[text()='Dashboard']")
    private WebElement dashboardTitle;


    public void login(String username, String password) {
        log.info("Logging in with username: {}", username);
        waitForElementToBeVisible(emailTextField);
        emailTextField.sendKeys(username);
        passwordTextField.sendKeys(password);
        loginButton.click();
    }

    public void verifyDashboardTextIsDisplayed() {
        // Tunggu elemen muncul (Timeout 10 detik)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dashboardTitle));

        // Melakukan Assertion
        Assert.assertTrue(dashboardTitle.isDisplayed(),
                "Dashboard Title Is Not Display : Failed Login");
    }
}
