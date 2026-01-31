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
public class UpdateDivision extends BaseTest {
    public void updateDivision(){
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
        detailDivisionPage.verifyIsInDetailDivisionPage();
        detailDivisionPage.updateDivision(config.getProperty("divisionNameUpdate"), config.getProperty("divisionDescription") );
        detailDivisionPage.verifySuccessUpdateDivision();


    }
}
