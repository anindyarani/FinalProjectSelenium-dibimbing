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

import java.time.Duration;

public class DetailAssignEmployeePage extends BasePage {
    private static final Logger log = LogManager.getLogger(DetailAssignEmployeePage.class);

    public DetailAssignEmployeePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id ="button-update-assigned-employee")
    private WebElement updateAssignEmployeeButton;

    @FindBy (id = "modal-update-assigned-employee-save-button")
    private WebElement updateAssignEmployeeSubmitButton;

    @FindBy (id = "endDate")
    private WebElement deadlineDateInputEdit;

    @FindBy (xpath =  "//*[contains(text(), 'Success update assigned employee')]")
    private WebElement popUpSuccessUpdateAssignEmployee;

    @FindBy (id = "button-delete-assigned-employee")
    private WebElement deleteAssignEmployeeButton;

    @FindBy (id = "modal-delete-assigned-employee-delete-button")
    private WebElement deleteAssignEmployeeSubmitButton;

    @FindBy (xpath =  "//*[contains(text(), 'Success delete Assigned Employee')]")
    private WebElement popUpSuccessDeleteAssignEmployee;

    @FindBy (xpath = "//p[text()='Detail Assigned Employee']")
    private WebElement detalAssignedEmployeeTitle;

    public void updateAssignEmployee(String deadlineDateEdit){
        waitForElementToBeClickable(updateAssignEmployeeButton);
        updateAssignEmployeeButton.click();
        waitForElementToBeVisible(deadlineDateInputEdit);
        deadlineDateInputEdit.click();
        waitForElementToBeClickable(updateAssignEmployeeSubmitButton);
        updateAssignEmployeeSubmitButton.click();
    }

    public void verifySuccessUpdateAssignEmployee(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToBeVisible(popUpSuccessUpdateAssignEmployee);
        Assert.assertTrue(popUpSuccessUpdateAssignEmployee.isDisplayed(),
                "Success Pop-up is not displayed: Failed to update assigned employee");
    }

    public void deleteAssignEmployee(){
        waitForElementToBeClickable(deleteAssignEmployeeButton);
        deleteAssignEmployeeButton.click();
        waitForElementToBeClickable(deleteAssignEmployeeSubmitButton);
        deleteAssignEmployeeSubmitButton.click();
    }

    public void verifySuccessDeleteAssignEmployee(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToBeVisible(popUpSuccessDeleteAssignEmployee);
        Assert.assertTrue(popUpSuccessDeleteAssignEmployee.isDisplayed(),
                "Success Pop-up is not displayed: Failed to delete assigned employee");
    }

    public void verifyInDetailAssignedEmployeePage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(detalAssignedEmployeeTitle));

        // Melakukan Assertion
        Assert.assertTrue(detalAssignedEmployeeTitle.isDisplayed(),
                "Dashboard Title Is Not Display : Is Not In Detail Assigned Employee Page");
    }
}
