package tests;

import Core.BaseTest;
import Core.DriverManager;

import Core.TestListener;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
@Test(groups = {"smoke"})
public class E2E extends BaseTest{
    public void E2EFlow() {
        WebDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver); // memanggil home page
        EmployeePage employeePage = new EmployeePage(driver);
        TrainingPage trainingPage = new TrainingPage(driver);
        DetailTrainingPage detailTrainingPage = new DetailTrainingPage(driver);
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        loginPage.verifyDashboardTextIsDisplayed();
        homePage.moveToEmployee();

        employeePage.verifyEmployeeTitleIsDisplayed();
        employeePage.createDivision(config.getProperty("divisionName"), config.getProperty("divisionDescription") );
        employeePage.verifySuccessAddDivision();

        employeePage.moveToEmployeeTab();

        employeePage.verifyEmployeeTitleIsDisplayed();
        employeePage.createEmployee(config.getProperty("employeeId"),
                config.getProperty("employeeName"), config.getProperty("email"),
                config.getProperty("phoneNumber"), config.getProperty("role") );
        employeePage.verifySuccessCreateEmployee();

        employeePage.fromEmployeeMoveToTraining();

        trainingPage.verifyIsInTrainingPage();

        trainingPage.createTraining(config.getProperty("trainingName"), config.getProperty("trainingDescription"));
        trainingPage.verifySuccessCreateTraining();

        trainingPage.openDetailTraining();

        detailTrainingPage.verifyIsInDetailTrainingPege();
        detailTrainingPage.createChapter(config.getProperty("chapterName"), config.getProperty("chapterDescription") );
        detailTrainingPage.verifySuccessAddChapter();

        detailTrainingPage.createContentVideo(config.getProperty("contentTitle"), config.getProperty("contentDescription"), config.getProperty("estimatedDuration") );
        detailTrainingPage.verifySuccessAddContent();

        detailTrainingPage.moveToAssignEmployeeTab();
        detailTrainingPage.assignTrainingEmployee(config.getProperty("startDate"), config.getProperty("deadlineDate") );
        detailTrainingPage.verifyAssignEmployee();

        detailTrainingPage.assignTrainingEmployee(config.getProperty("startDate"), config.getProperty("deadlineDate"));
        detailTrainingPage.verifyAssignEmployee();
    }





}
