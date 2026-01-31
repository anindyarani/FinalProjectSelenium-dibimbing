package Pages;

import Core.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;



public class HomePage extends BasePage {
    private static final Logger log = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "layout-desktop-menu-item-link-employee")
    private WebElement menuEmployee;

    @FindBy (id = "layout-desktop-menu-item-link-training")
    private WebElement menuTraining;

    @FindBy (id = "tabs-admin-employee--tabpanel-0")
    private WebElement employeeList;

    public void moveToEmployee(){
        menuEmployee.click();
    }

    public void verifyInEmployeeMenu (){
        Assert.assertTrue(employeeList.isDisplayed(), "Employee List is not displayed");
    }

    public void moveToTraining(){
        waitForElementToBeClickable(menuTraining);
        menuTraining.click();
    }
}
