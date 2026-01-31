package tests.Training;

import Core.BaseTest;
import Core.DriverManager;
import Core.TestListener;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.TrainingPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
@Test(groups = {"smoke"})
public class CreateTraining extends BaseTest {
    public void createTraining(){
        WebDriver driver = DriverManager.getDriver();
        HomePage homePage = new HomePage(driver);
        TrainingPage trainingPage = new TrainingPage(driver);

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(config.getProperty("username"), config.getProperty("password"));

        homePage.moveToTraining();
        trainingPage.verifyIsInTrainingPage();
        trainingPage.createTraining(config.getProperty("trainingName"), config.getProperty("trainingDescription"));
        trainingPage.verifySuccessCreateTraining();
    }
}
