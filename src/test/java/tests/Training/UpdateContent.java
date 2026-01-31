package tests.Training;

import Core.BaseTest;
import Core.DriverManager;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class UpdateContent extends BaseTest {
    @Test(priority = 1, groups = {"smoke"})
    public void updateContentVideo(){
        WebDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver);
        TrainingPage trainingPage = new TrainingPage(driver);
        DetailTrainingPage detailTrainingPage = new DetailTrainingPage(driver);
        DetailContentPage detailContentPage = new DetailContentPage(driver);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        homePage.moveToTraining();
        detailTrainingPage.verifyIsInDetailTrainingPege();
        trainingPage.openDetailTraining();
        detailTrainingPage.verifyIsInDetailTrainingPege();
        detailTrainingPage.openDetailContent();
        detailContentPage.updateContentVideo(config.getProperty("titleEdit"));
        detailContentPage.verifySuccessUpdateContent();
    }

    @Test(priority = 3, groups = {"smoke", "prio2"})
    public void updateContenTest(){
        WebDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver);
        TrainingPage trainingPage = new TrainingPage(driver);
        DetailTrainingPage detailTrainingPage = new DetailTrainingPage(driver);
        DetailContentPage detailContentPage = new DetailContentPage(driver);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        homePage.moveToTraining();
        detailTrainingPage.verifyIsInDetailTrainingPege();
        trainingPage.openDetailTraining();
        detailTrainingPage.verifyIsInDetailTrainingPege();
        detailTrainingPage.openDetailContent();
        detailContentPage.updateContentArticle(config.getProperty("titleEdit"));
        detailContentPage.verifySuccessUpdateContent();
    }
    @Test(priority = 2, groups = {"smoke", "prio3"})
    public void updateContentArticle(){
        WebDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver);
        TrainingPage trainingPage = new TrainingPage(driver);
        DetailTrainingPage detailTrainingPage = new DetailTrainingPage(driver);
        DetailContentPage detailContentPage = new DetailContentPage(driver);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        homePage.moveToTraining();
        detailTrainingPage.verifyIsInDetailTrainingPege();
        trainingPage.openDetailTraining();
        detailTrainingPage.verifyIsInDetailTrainingPege();
        detailTrainingPage.openDetailContent();
        detailContentPage.updateContentTest(config.getProperty("titleEdit"));
        detailContentPage.verifySuccessUpdateContent();
    }
}
