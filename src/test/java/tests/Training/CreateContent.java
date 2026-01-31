package tests.Training;

import Core.BaseTest;
import Core.DriverManager;
import Pages.DetailTrainingPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.TrainingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.TestRunner.PriorityWeight.priority;


public class CreateContent extends BaseTest {
    @Test(priority = 1, groups = {"smoke"})
    public void createContentVideo() {
        WebDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver);
        TrainingPage trainingPage = new TrainingPage(driver);
        DetailTrainingPage detailTrainingPage = new DetailTrainingPage(driver);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        homePage.moveToTraining();
        detailTrainingPage.verifyIsInDetailTrainingPege();
        trainingPage.openDetailTraining();
        detailTrainingPage.createContentVideo(config.getProperty("contentTitle"), config.getProperty("contentDescription"), config.getProperty("estimatedDuration") );
        detailTrainingPage.verifySuccessAddContent();
    }
    @Test(priority = 2, groups = {"smoke", "prio2"})
    public void createContentArticle() {
        WebDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver);
        TrainingPage trainingPage = new TrainingPage(driver);
        DetailTrainingPage detailTrainingPage = new DetailTrainingPage(driver);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        homePage.moveToTraining();
        detailTrainingPage.verifyIsInDetailTrainingPege();
        trainingPage.openDetailTraining();
        detailTrainingPage.createContentArticle(config.getProperty("contentTitle"), config.getProperty("contentDescription"), config.getProperty("readDuration") );
        detailTrainingPage.verifySuccessAddContent();
    }

    @Test(priority = 3, groups = {"smoke", "prio3"})
    public void createContentTest() {
        WebDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver);
        TrainingPage trainingPage = new TrainingPage(driver);
        DetailTrainingPage detailTrainingPage = new DetailTrainingPage(driver);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        homePage.moveToTraining();
        detailTrainingPage.verifyIsInDetailTrainingPege();
        trainingPage.openDetailTraining();
        detailTrainingPage.createContentTest(config.getProperty("contentTitle"), config.getProperty("contentDescription"), config.getProperty("testDuration"));
        detailTrainingPage.verifySuccessAddContent();
    }



}
