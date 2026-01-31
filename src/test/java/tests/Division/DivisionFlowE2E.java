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
public class DivisionFlowE2E extends BaseTest {
    public void flow (){
        WebDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        EmployeePage employeePage = new EmployeePage(driver);
        DetailDivisionPage detailDivisionPage = new DetailDivisionPage(driver);


        loginPage.verifyDashboardTextIsDisplayed();
        homePage.moveToEmployee();
        employeePage.verifyEmployeeTitleIsDisplayed();

        employeePage.createDivision(config.getProperty("divisionName"), config.getProperty("divisionDescription") );
        employeePage.verifySuccessAddDivision();


        employeePage.openDetailDivision();

        detailDivisionPage.updateDivision(config.getProperty("divisionNameUpdate"), config.getProperty("divisionDescriptionUpdate") );
        detailDivisionPage.verifySuccessUpdateDivision();

        detailDivisionPage.deleteDivision();
        detailDivisionPage.verifySuccessDeleteDivision();
    }
}
