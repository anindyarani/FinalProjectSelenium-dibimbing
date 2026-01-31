package Pages;

import Core.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DetailContentPage extends BasePage {
    private static final Logger log = LogManager.getLogger(DetailContentPage.class);

    public DetailContentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "button-update-content")
    private WebElement updateContentButton;

    @FindBy (id = "input-title-content")
    private WebElement titlieEditTextField;

    @FindBy (id = "modal-update-content-save-button")
    private WebElement updateContentSubmitButton;

    @FindBy (xpath =  "//*[contains(text(), 'Success update content')]")
    private WebElement popUpSuccessUpdateContent;

    @FindBy (xpath = "//button[text()='Delete']")
    private WebElement deleteContentButton;

    @FindBy (xpath = "//footer[contains(@class, 'chakra-modal__footer')]//button[normalize-space()='Delete']")
    private WebElement deleteContentSubmitButton;

    @FindBy (xpath =  "//*[contains(text(), 'Success delete content')]")
    private WebElement popUpSuccessDeleteContent;

    public void updateContentVideo(String titleEdit){
        waitForElementToBeClickable(updateContentButton);
        updateContentButton.click();
        waitForElementToBeVisible(titlieEditTextField);
        titlieEditTextField.clear();
        titlieEditTextField.sendKeys(titleEdit);
        waitForElementToBeClickable(updateContentSubmitButton);
        updateContentSubmitButton.click();
    }

    public void updateContentArticle(String titleEdit){
        waitForElementToBeClickable(updateContentButton);
        updateContentButton.click();
        waitForElementToBeVisible(titlieEditTextField);
        titlieEditTextField.clear();
        titlieEditTextField.sendKeys(titleEdit);
        waitForElementToBeClickable(updateContentSubmitButton);
        updateContentSubmitButton.click();
    }

    public void updateContentTest(String titleEdit){
        waitForElementToBeClickable(updateContentButton);
        updateContentButton.click();
        waitForElementToBeVisible(titlieEditTextField);
        titlieEditTextField.clear();
        titlieEditTextField.sendKeys(titleEdit);
        waitForElementToBeClickable(updateContentSubmitButton);
        updateContentSubmitButton.click();
    }

    public void verifySuccessUpdateContent(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToBeVisible(popUpSuccessUpdateContent);
        Assert.assertTrue(popUpSuccessUpdateContent.isDisplayed(),
                "Success Pop-up is not displayed: Failed to update content");
    }

    public void deleteContentPage() {
        waitForElementToBeClickable(updateContentButton);
        updateContentButton.click();
        waitForElementToBeClickable(deleteContentButton);
        deleteContentButton.click();
        waitForElementToBeClickable(deleteContentSubmitButton);
        deleteContentSubmitButton.click();
    }

    public void verifySuccessDeleteContent(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToBeVisible(popUpSuccessDeleteContent);
        Assert.assertTrue(popUpSuccessDeleteContent.isDisplayed(),
                "Success Pop-up is not displayed: Failed to delete content");
        }

}
