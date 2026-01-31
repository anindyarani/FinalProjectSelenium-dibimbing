package tests.Training;

import Core.BaseTest;
import Core.DriverManager;
import Pages.DetailTrainingPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.TrainingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test(groups = {"smoke"})
public class CreateChapter extends BaseTest {
    public void CreateChapter (){
        WebDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver);
        TrainingPage trainingPage = new TrainingPage(driver);
        DetailTrainingPage detailTrainingPage = new DetailTrainingPage(driver);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        homePage.moveToTraining();
        trainingPage.openDetailTraining();
        detailTrainingPage.verifyIsInDetailTrainingPege();
        detailTrainingPage.createChapter(config.getProperty("chapterName"), config.getProperty("chapterDescription") );
        detailTrainingPage.verifySuccessAddChapter();


    }
}
