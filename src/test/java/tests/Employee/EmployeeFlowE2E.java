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
public class EmployeeFlowE2E extends BaseTest {
    public void employeeFlow(){
        WebDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        EmployeePage employeePage = new EmployeePage(driver);
        DetailEmployeePage detailEmployeePage = new DetailEmployeePage(driver);

        loginPage.verifyDashboardTextIsDisplayed();
        homePage.moveToEmployee();

        employeePage.verifyEmployeeTitleIsDisplayed();

        employeePage.createEmployee(config.getProperty("employeeId"),
                config.getProperty("employeeName"), config.getProperty("email"),
                config.getProperty("phoneNumber"), config.getProperty("role") );
        employeePage.verifySuccessCreateEmployee();

        employeePage.openDetailEmployee();
        detailEmployeePage.verifyIsInDetailEmployeePage();
        detailEmployeePage.updateEmployee(config.getProperty("employeeName"));
        detailEmployeePage.verifySuccessUpdateEmployee();

        detailEmployeePage.deleteEmployee();
        detailEmployeePage.verifySuccessDeleteEmployee();

    }
}
