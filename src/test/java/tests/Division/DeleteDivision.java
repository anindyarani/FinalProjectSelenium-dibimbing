package tests.Division;

import Core.BaseTest;
import Core.DriverManager;
import Pages.DetailDivisionPage;
import Pages.EmployeePage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test(groups = {"smoke"})
public class DeleteDivision extends BaseTest {
    public void deleteDivision(){
        WebDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver);
        EmployeePage employeePage = new EmployeePage(driver);
        DetailDivisionPage detailDivisionPage = new DetailDivisionPage(driver);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        loginPage.verifyDashboardTextIsDisplayed();
        homePage.moveToEmployee();
        employeePage.verifyEmployeeTitleIsDisplayed();
        employeePage.moveToDivisionTab();
        employeePage.openDetailDivision();
        detailDivisionPage.deleteDivision();
        detailDivisionPage.verifySuccessDeleteDivision();
    }
}
