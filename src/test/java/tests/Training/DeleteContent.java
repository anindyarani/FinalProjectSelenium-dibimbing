package tests.Training;

import Core.BasePage;
import Core.BaseTest;
import Core.DriverManager;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test(groups = {"smoke"})
public class DeleteContent extends BaseTest {
    public void deleteContent(){
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
        detailTrainingPage.openDetailContent();
        detailContentPage.deleteContentPage();
        detailContentPage.verifySuccessDeleteContent();
    }
}
