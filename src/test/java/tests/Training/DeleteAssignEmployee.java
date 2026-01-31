package tests.Training;

import Core.BaseTest;
import Core.DriverManager;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test(groups = {"smoke"})
public class DeleteAssignEmployee extends BaseTest {
    public void deleteAssignEmployee() {
        WebDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver);
        TrainingPage trainingPage = new TrainingPage(driver);
        DetailTrainingPage detailTrainingPage = new DetailTrainingPage(driver);
        DetailAssignEmployeePage detailAssignEmployeePage = new DetailAssignEmployeePage(driver);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        homePage.moveToTraining();
        trainingPage.openDetailTraining();
        detailTrainingPage.verifyIsInDetailTrainingPege();
        detailTrainingPage.moveToAssignEmployeeTab();
        detailTrainingPage.openDetailAssignEmployee();
        detailAssignEmployeePage.verifyInDetailAssignedEmployeePage();
        detailAssignEmployeePage.deleteAssignEmployee();
        detailAssignEmployeePage.verifySuccessDeleteAssignEmployee();
    }
}
