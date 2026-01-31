package Pages;

import Core.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DetailEmployeePage extends BasePage {
    private static final Logger log = LogManager.getLogger(DetailEmployeePage.class);

    public DetailEmployeePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id ="edit-employee-button")
    private WebElement editemployeeButton;

    @FindBy (id = "edit-employee-employee-id-input")
    private WebElement employeeIdEdit;

    @FindBy (id = "edit-employee-name-input")
    private WebElement  employeeNameEdit;

    @FindBy (id = "edit-employee-email-input")
    private WebElement emailEdit;

    @FindBy (id ="edit-employee-phone-number-input")
    private WebElement phoneNumberEdit;

    @FindBy (id = "edit-employee-division-select")
    private WebElement employeeDivisionEdit;

    @FindBy (id = "edit-employee-employee-role-input")
    private WebElement employeeRoleEdit;

    @FindBy (id = "edit-employee-save-changes-button")
    private WebElement saveChangesButton;

    @FindBy (id = "delete-employee-button")
    private WebElement deleteEmployeeButton;

    @FindBy (id = "confirm-delete-button")
    private WebElement confirmDeleteButton;

    @FindBy (id ="resend-email-button")
    private WebElement resendEmailButton;

    @FindBy (id = "activation-employee-button")
    private WebElement employeeStatusActivateButton;

    @FindBy (xpath =  "//*[contains(text(), 'Success update employee')]")
    private WebElement popUpSuccessUpdateEmployee;

    @FindBy (xpath =  "//p[contains(text(), 'Succes delete employee')]")
    private WebElement popUpSuccessDeleteEmployee;

    @FindBy(xpath =  "//p[text()='Detail Employee']")
    private WebElement titleDetailEmployee;

    @FindBy (id = "activation-employee-button")
    private WebElement activationEmployeeButton;

    @FindBy (id = "activation-employee-confirm-button")
    private WebElement activationEmployeeSubmitButton;

    @FindBy (xpath =  "//p[contains(text(), 'Succes inactivate employee account')]")
    private WebElement popUpSuccessUpdateStatusEmployee;




    public void verifyIsInDetailEmployeePage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(titleDetailEmployee));

        // Melakukan Assertion
        Assert.assertTrue(titleDetailEmployee.isDisplayed(),
                "Dashboard Title Is Not Display : Is Not In Detail Employee Page");

    }

    public void updateEmployee(String employeeNameUpdate) {
        waitForElementToBeClickable(editemployeeButton);
        editemployeeButton.click();
        waitForElementToBeVisible(employeeNameEdit);
        employeeNameEdit.clear();
        employeeNameEdit.click();
        employeeNameEdit.sendKeys(employeeNameUpdate); //random string
        employeeNameEdit.sendKeys(Keys.TAB);
        waitForElementToBeClickable(saveChangesButton);
        saveChangesButton.click();
    }

    public void verifySuccessUpdateEmployee(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToBeVisible(popUpSuccessUpdateEmployee);
        Assert.assertTrue(popUpSuccessUpdateEmployee.isDisplayed(),
                "Success Pop-up is not displayed: Failed to update employee");
    }

    public void deleteEmployee (){
        waitForElementToBeClickable(deleteEmployeeButton);
        deleteEmployeeButton.click();
        waitForElementToBeClickable(confirmDeleteButton);
        confirmDeleteButton.click();
    }

    public void verifySuccessDeleteEmployee(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToBeVisible(popUpSuccessDeleteEmployee);
        Assert.assertTrue(popUpSuccessDeleteEmployee.isDisplayed(),
                "Success Pop-up is not displayed: Failed to delete employee");
    }

    public void updateStatusEmployee(){
        waitForElementToBeClickable(activationEmployeeButton);
        activationEmployeeButton.click();
        waitForElementToBeClickable(activationEmployeeSubmitButton);
        activationEmployeeSubmitButton.click();
    }

    public void verifySuccessChangeEmployeeStatus(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToBeVisible(popUpSuccessUpdateStatusEmployee);
        Assert.assertTrue(popUpSuccessUpdateStatusEmployee.isDisplayed(),
                "Success Pop-up is not displayed: Failed to update status employee");
    }






}
