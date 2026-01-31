package tests.Division;

import Core.BaseTest;
import Core.DriverManager;
import Pages.EmployeePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test(groups = {"smoke"})
public class VerifyDuplicateDivisionData extends BaseTest {
    public void verifyDuplicateDivisionData(){
        WebDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        EmployeePage employeePage = new EmployeePage(driver);


        loginPage.verifyDashboardTextIsDisplayed();
        homePage.moveToEmployee();
        employeePage.verifyEmployeeTitleIsDisplayed();
        employeePage.createDivision(config.getProperty("divisionName"), config.getProperty("divisionDescription") );

    }
}
