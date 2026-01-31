package tests.Division;

import Core.BaseTest;
import Core.DriverManager;
import Core.TestListener;
import Pages.EmployeePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
@Test(groups = {"smoke"})
public class CreateDivison extends BaseTest {
    public void createDivision() {
        WebDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        EmployeePage employeePage = new EmployeePage(driver);


        loginPage.verifyDashboardTextIsDisplayed();
        homePage.moveToEmployee();
        employeePage.verifyEmployeeTitleIsDisplayed();
        employeePage.createDivision(config.getProperty("divisionName"), config.getProperty("divisionDescription") );
        employeePage.verifySuccessAddDivision();

    }
}
