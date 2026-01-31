package tests.Employee;


import Core.BaseTest;
import Core.DriverManager;
import Pages.DetailEmployeePage;
import Pages.EmployeePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test(groups = {"smoke"})
public class UpdateStatusEmployee extends BaseTest {
    public void updateStatusEmployee() {
        WebDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        EmployeePage employeePage = new EmployeePage(driver);
        DetailEmployeePage detailEmployeePage = new DetailEmployeePage(driver);

        loginPage.verifyDashboardTextIsDisplayed();
        homePage.moveToEmployee();
        employeePage.verifyEmployeeTitleIsDisplayed();
        employeePage.openDetailEmployee();
        detailEmployeePage.verifyIsInDetailEmployeePage();
        detailEmployeePage.updateStatusEmployee();
        detailEmployeePage.verifySuccessChangeEmployeeStatus();
    }
}

