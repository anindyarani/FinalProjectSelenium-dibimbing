package Pages;

import Core.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.time.Duration;

public class TrainingPage extends BasePage {
    private static final Logger log = LogManager.getLogger(TrainingPage.class);

    public TrainingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "add-training-button")
    private WebElement addTrainingButton;

    @FindBy (id =  "title")
    private WebElement trainingNameTextField;

    @FindBy (id ="description")
    private WebElement trainingDescriptionTextField;

    @FindBy (id = "add-training-submit-button")
    private WebElement addTrainingSubmitButton;

    @FindBy(xpath = "(//a[contains(@href,'training/detail')])[1]")
    private WebElement firstTrainingDetail;

    @FindBy(xpath = "//p[text()='Manage Training']")
    private WebElement titleManageTraining;

    @FindBy (xpath =  "//*[contains(text(), 'Success create program')]")
    private WebElement popUpSuccessCreateTraining;


    public void createTraining(String trainingName, String trainingDescription){
        addTrainingButton.click();
        trainingNameTextField.sendKeys(trainingName);
        trainingDescriptionTextField.sendKeys(trainingDescription);
        addTrainingSubmitButton.click();
    }

    public void verifyIsInTrainingPage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(titleManageTraining));

        // Melakukan Assertion
        Assert.assertTrue(titleManageTraining.isDisplayed(),
                "Dashboard Title Is Not Display : Is Not In Training Page");

    }

    public void verifySuccessCreateTraining(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(popUpSuccessCreateTraining));

        // Melakukan Assertion
        Assert.assertTrue(popUpSuccessCreateTraining.isDisplayed(),
                "Success Pop-up is not displayed: Failed to create training");
    }

    public void openDetailTraining(){
        waitForElementToBeClickable(firstTrainingDetail);
        firstTrainingDetail.click();
    }











}
