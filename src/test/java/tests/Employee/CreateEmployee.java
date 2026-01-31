package tests.Employee;

import Core.BaseTest;
import Core.DriverManager;
import Pages.EmployeePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test(groups = {"smoke"})
public class CreateEmployee extends BaseTest {
    public void CreateEmployee(){
        WebDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        EmployeePage employeePage = new EmployeePage(driver);

        loginPage.verifyDashboardTextIsDisplayed();
        homePage.moveToEmployee();
        employeePage.verifyEmployeeTitleIsDisplayed();
        employeePage.createEmployee(config.getProperty("employeeId"),
                config.getProperty("employeeName"), config.getProperty("email"),
                config.getProperty("phoneNumber"), config.getProperty("role") );

        employeePage.verifySuccessCreateEmployee();

    }
}
