package tests.Employee;

import Core.BaseTest;
import Core.DriverManager;
import Core.TestUtils;
import Pages.EmployeePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ImportDataEmployee extends BaseTest {

    @DataProvider(name = "singleFileData")
    public Object[][] dataProvider() {
        return new Object[][]{
                {
                        "Testing Import File Utama",
                        System.getProperty("user.dir") + "/src/test/resources/data/data.xlsx",
                        "Success"
                }
        };
    }

    @Test(priority = 1, groups = {"smoke"}, dataProvider = "singleFileData")
    public void importEmployeeData(String scenario, String filePath, String expectedMsg) {
        WebDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        EmployeePage employeePage = new EmployeePage(driver);

        loginPage.verifyDashboardTextIsDisplayed();
        homePage.moveToEmployee();
        employeePage.verifyEmployeeTitleIsDisplayed();
        employeePage.importEmployee(filePath);
        employeePage.verifySuccessImportDataEmployee();
    }
}
