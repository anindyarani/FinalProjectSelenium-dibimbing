package Pages;

import Core.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DetailTrainingPage extends BasePage {
    private static final Logger log = LogManager.getLogger(DetailTrainingPage.class);

    public DetailTrainingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "update-training-button")
    private WebElement updateTrainingButton;

    @FindBy(id = "title")
    private WebElement trainingNameUpdateTextField;

    @FindBy(id = "description")
    private WebElement trainingDescriptionUpdateTextField;

    @FindBy(id = "update-training-submit-button")
    private WebElement updateTrainingSubmitButton;

    @FindBy(id = "add-chapter-icon-button")
    private WebElement addChapterButton;

    @FindBy(xpath = "//div[contains(text(), 'Chapter 1 - Chapter 1')]")
    private WebElement chapterOne;

    @FindBy(id = "update-chapter-button-1")
    private WebElement updateChapterButton;

    @FindBy(xpath = "//input[@name='title' and @placeholder='Chapter Name']")
    private WebElement chapterNameUpdate;

    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement chapterDescriptionUpdate;

    @FindBy(id = "update-chapter-submit-button-1")
    private WebElement updateChapterSubmitButton;

    @FindBy(id = "tabs-training-detail--tab-1")
    private WebElement assignEmployeeTab;

    @FindBy(xpath = "//*[text()='Assign Employee']")
    private WebElement assignEmployeeButton;

    @FindBy(xpath = "//table[contains(@class, 'chakra-table')]/tbody/tr[1]/td[4]/button")
    private WebElement firstAssignEmployeeButton;

    @FindBy(xpath = "//p[text()='Start Date']/following-sibling::input[@type='date']")
    private WebElement inputStartDate;

    @FindBy(xpath = "//p[text()='Deadline Date']/following-sibling::input[@type='date']")
    private WebElement inputDeadlineDate;

    @FindBy(xpath = "//button[text()='Assign Employee']")
    private WebElement assignSubmitButton;

    @FindBy(xpath = "//button[@aria-label='cancel']")
    private WebElement cancelAssignEmployeeButton;

    @FindBy(xpath = "//th[text()='Action']")
    private WebElement firstEmployeeCell;


    @FindBy(id = "title")
    private WebElement chapterNameTextField;

    @FindBy(id = "description")
    private WebElement chapterDescriptionTextField;

    @FindBy(id = "add-chapter-submit-button")
    private WebElement addChapterSubmitButton;

    @FindBy(id = "tabs-training-detail--tab-0")
    private WebElement contentChapterTab;


    @FindBy(xpath = "//button[contains(@class, 'chakra-button') and contains(., 'Add Content')]")
    private WebElement addContentButton;

    @FindBy(xpath = "//span[contains(@class, 'chakra-radio__label')][text()='Video']")
    private WebElement videoRadioButton;

    @FindBy(xpath = "//span[contains(@class, 'chakra-radio__label')][text()='Article']")
    private WebElement articleRadioButton;

    @FindBy(xpath = "//span[contains(@class, 'chakra-radio__label')][text()='Test']")
    private WebElement testRadioButton;

    @FindBy(xpath = "//input[@placeholder='Content title']")
    private WebElement contentTitleTextField;

    @FindBy(xpath = "//div[@role='textbox' and @aria-label='Editor editing area: main']")
    private WebElement contentDescriptionTextField;

    @FindBy(id = "button-upload-media")
    private WebElement chooseMediaContent;

    @FindBy(id = "input-estimated-video-duration--Infinity")
    private WebElement estimatedVideoDuration;

    @FindBy ( xpath = "//p[text()='Read Duration']/following::input[@type='number']")
    private WebElement readDurationTextField;

    @FindBy (xpath = "//p[text()='Test Duration']/following::input[@type='number']")
    private WebElement testDurationTextField;

    @FindBy(id = "submit-button--Infinity")
    private WebElement saveContentButton;

    @FindBy(id = "button-upload-media")
    private WebElement uploadMediaButton;

    @FindBy(xpath = "(//div[contains(@class, 'chakra-stack')]//div[contains(@class, 'css-79elbk')])[1]")
    private WebElement firstVideoInList;

    @FindBy (xpath = "(//div[contains(@class, 'chakra-stack')]//div[contains(@class, 'css-14t4u77')])[1]")
    private WebElement firstArticleInList;


    @FindBy(xpath = "//button[text()='Choose Media']")
    private WebElement chooseMediaButton;

    @FindBy(xpath = "//div[@data-rfd-draggable-id='0']")
    private WebElement firstChapterItem;

    @FindBy(xpath = "//button[text()='Add Content' and contains(@id, 'submit-button')]")
    private WebElement addContentSubmitButton;

    @FindBy(xpath = "//p[text()='Training']")
    private WebElement titleTraining;

    @FindBy (xpath =  "//*[contains(text(), 'Success create chapter')]")
    private WebElement popUpSuccessCreateChapter;

    @FindBy (xpath =  "//*[contains(text(), 'Success create content')]")
    private WebElement popUpSuccessCreateContent;

    @FindBy (xpath =  "//*[contains(text(), 'Success assign employee')]")
    private WebElement popUpSuccessAssignEmployee;

    @FindBy (xpath =  "//*[contains(text(), 'Success update program')]")
    private WebElement popUpSuccessUpdateTraining;

    @FindBy (xpath =  "//*[contains(text(), 'Success update chapter')]")
    private WebElement popUpSuccessUpdateChapter;

    @FindBy (xpath = "//tbody/tr[1]//button[text()='Detail']")
    private WebElement firstContentItem;

    @FindBy (xpath = "//tbody/tr[1]//button[contains(., 'Detail')]")
    private WebElement firstDetailAssignEmployee;


    public void verifyIsInDetailTrainingPege(){
        waitForElementToBeVisible(titleTraining);
        // Melakukan Assertion
        Assert.assertTrue(titleTraining.isDisplayed(),
                "Dashboard Title Is Not Display : Is Not In Detail Training Page");
    }

    public void createChapter(String chapterName, String chapterDescription) {
        waitForElementToBeClickable(addChapterButton);
        addChapterButton.click();
        chapterNameTextField.sendKeys(chapterName);
        chapterDescriptionTextField.sendKeys(chapterDescription);
        addChapterSubmitButton.click();
    }

    public void verifySuccessAddChapter (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToBeVisible(popUpSuccessCreateChapter);
        Assert.assertTrue(popUpSuccessCreateChapter.isDisplayed(),
                "Success Pop-up is not displayed: Failed to create chapter");
    }

    public void safeSlowType(WebElement element, String text) {
        // 1. Pastikan fokus dan kosongkan secara manual agar script editor tidak bingung
        element.click();
        element.clear();

        // 2. Gunakan polling micro-wait yang sedikit lebih lama namun tetap dinamis
        for (char ch : text.toCharArray()) {
            element.sendKeys(String.valueOf(ch));

            // Gunakan WebDriverWait untuk memberikan waktu proses bagi script editor
            // Angka 300ms adalah 'safe zone' untuk Rich Text Editor yang berat
            new WebDriverWait(driver, Duration.ofMillis(300))
                    .until(d -> true);
        }
    }

    public void createContentVideo(String contentTitle, String contentDescription, String estimatedDuration){
        waitForElementToBeClickable(firstChapterItem);
        firstChapterItem.click();

        waitForElementToBeClickable(addContentButton);
        addContentButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("chakra-modal__content")));
        waitForElementToBeClickable(videoRadioButton);
        videoRadioButton.click();

        waitForElementToBeVisible(contentTitleTextField);
        contentTitleTextField.sendKeys(contentTitle);

        waitForElementToBeVisible(contentDescriptionTextField);
        contentDescriptionTextField.click();
        contentDescriptionTextField.clear();
        safeSlowType(contentDescriptionTextField, contentDescription);

        waitForElementToBeVisible(uploadMediaButton);
        uploadMediaButton.click();

        waitForElementToBeClickable(firstVideoInList);
        firstVideoInList.click();

        waitForElementToBeVisible(chooseMediaButton);
        chooseMediaButton.click();

        waitForElementToBeVisible(estimatedVideoDuration);
        estimatedVideoDuration.sendKeys(estimatedDuration);

        waitForElementToBeClickable(addContentSubmitButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(d -> {
            try {
                // 1. Scroll ke elemen menggunakan Actions (Tanpa JS/Thread.sleep)
                new Actions(driver).moveToElement(addContentSubmitButton).perform();

//                Assert.assertTrue(addContentSubmitButton.isDisplayed(), "button not display");

                // 2. Coba Klik
                addContentSubmitButton.click();
                return true;
            } catch (ElementClickInterceptedException e) {
                // Jika masih terhalang overlay transparan Chakra UI, balikkan false untuk retry
                return false;
            } catch (Exception e) {
                return false;
            }
        });

    }

    public void verifySuccessAddContent(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToBeVisible(popUpSuccessCreateContent);
        Assert.assertTrue(popUpSuccessCreateContent.isDisplayed(),
                "Success Pop-up is not displayed: Failed to create content");
    }

    public void createContentArticle(String contentTitle, String contentDescription, String readDuration){
        waitForElementToBeClickable(firstChapterItem);
        firstChapterItem.click();

        waitForElementToBeClickable(addContentButton);
        addContentButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("chakra-modal__content")));
        waitForElementToBeClickable(articleRadioButton);
        articleRadioButton.click();

        waitForElementToBeVisible(contentTitleTextField);
        contentTitleTextField.sendKeys(contentTitle);

        waitForElementToBeVisible(contentDescriptionTextField);
        contentDescriptionTextField.click();
        contentDescriptionTextField.clear();
        safeSlowType(contentDescriptionTextField, contentDescription);

        waitForElementToBeVisible(uploadMediaButton);
        uploadMediaButton.click();

        waitForElementToBeClickable(firstArticleInList);
        firstArticleInList.click();

        waitForElementToBeVisible(chooseMediaButton);
        chooseMediaButton.click();

        waitForElementToBeVisible(readDurationTextField);
       readDurationTextField.sendKeys(readDuration);

        waitForElementToBeClickable(addContentSubmitButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(d -> {
            try {
                // 1. Scroll ke elemen menggunakan Actions (Tanpa JS/Thread.sleep)
                new Actions(driver).moveToElement(addContentSubmitButton).perform();

//                Assert.assertTrue(addContentSubmitButton.isDisplayed(), "button not display");

                // 2. Coba Klik
                addContentSubmitButton.click();
                return true;
            } catch (ElementClickInterceptedException e) {
                // Jika masih terhalang overlay transparan Chakra UI, balikkan false untuk retry
                return false;
            } catch (Exception e) {
                return false;
            }
        });

    }


    public void createContentTest(String contentTitle, String contentDescription, String testDuration){
        waitForElementToBeClickable(firstChapterItem);
        firstChapterItem.click();

        waitForElementToBeClickable(addContentButton);
        addContentButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("chakra-modal__content")));
        waitForElementToBeClickable(testRadioButton);
        testRadioButton.click();

        waitForElementToBeVisible(contentTitleTextField);
        contentTitleTextField.sendKeys(contentTitle);

        waitForElementToBeVisible(contentDescriptionTextField);
        contentDescriptionTextField.click();
        contentDescriptionTextField.clear();
        safeSlowType(contentDescriptionTextField, contentDescription);

        waitForElementToBeVisible(testDurationTextField);
        testDurationTextField.sendKeys(testDuration);

        waitForElementToBeClickable(addContentSubmitButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(d -> {
            try {
                // 1. Scroll ke elemen menggunakan Actions (Tanpa JS/Thread.sleep)
                new Actions(driver).moveToElement(addContentSubmitButton).perform();

//                Assert.assertTrue(addContentSubmitButton.isDisplayed(), "button not display");

                // 2. Coba Klik
                addContentSubmitButton.click();
                return true;
            } catch (ElementClickInterceptedException e) {
                // Jika masih terhalang overlay transparan Chakra UI, balikkan false untuk retry
                return false;
            } catch (Exception e) {
                return false;
            }
        });

    }

    public void moveToContentTab() {
        waitForElementToBeClickable(contentChapterTab);
        contentChapterTab.click();
    }

    public void moveToAssignEmployeeTab() {
        waitForElementToBeClickable(assignEmployeeTab);
        assignEmployeeTab.click();
    }

    public void assignTrainingEmployee(String startDate, String deadlineDate) {
        waitForElementToBeClickable(assignEmployeeTab);
        assignEmployeeTab.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToBeClickable(assignEmployeeButton);
        assignEmployeeButton.click();
        waitForElementToBeVisible(firstAssignEmployeeButton);
        firstAssignEmployeeButton.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        inputStartDate.clear();
        inputStartDate.sendKeys(startDate);
        inputDeadlineDate.clear();
        inputDeadlineDate.sendKeys(deadlineDate);
        waitForElementToBeClickable(assignSubmitButton);
        assignSubmitButton.click();
    }

    public void verifyAssignEmployee(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToBeVisible(popUpSuccessAssignEmployee);
        Assert.assertTrue(popUpSuccessAssignEmployee.isDisplayed(),
                "Success Pop-up is not displayed: Failed to create chapter");

    }

    public void updateTraining(String trainingNameEdit){
        waitForElementToBeClickable(updateTrainingButton);
        updateTrainingButton.click();
        waitForElementToBeVisible(trainingNameUpdateTextField);
        trainingNameUpdateTextField.clear();
        trainingNameUpdateTextField.sendKeys(trainingNameEdit);
        trainingNameUpdateTextField.sendKeys(Keys.TAB);
        waitForElementToBeClickable(updateTrainingSubmitButton);
        updateTrainingSubmitButton.click();
    }

    public void verifySuccessUpdateTraining(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToBeVisible(popUpSuccessUpdateTraining);
        Assert.assertTrue(popUpSuccessUpdateTraining.isDisplayed(),
                "Success Pop-up is not displayed: Failed to create chapter");
    }

    public void updateChapter(String chapterNameEdit){
        waitForElementToBeClickable(firstChapterItem);
        firstChapterItem.click();
        waitForElementToBeClickable(updateChapterButton);
        updateChapterButton.click();
        waitForElementToBeVisible(chapterNameUpdate);
        chapterNameUpdate.clear();
        chapterNameUpdate.sendKeys(chapterNameEdit);
        waitForElementToBeClickable(updateChapterSubmitButton);
        updateChapterSubmitButton.click();
    }

    public void verifySuccessUpdateChapter(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToBeVisible(popUpSuccessUpdateChapter);
        Assert.assertTrue(popUpSuccessUpdateChapter.isDisplayed(),
                "Success Pop-up is not displayed: Failed to update chapter");
    }

    public void openDetailContent(){
        waitForElementToBeClickable(firstChapterItem);
        firstChapterItem.click();
        waitForElementToBeClickable(firstContentItem);
        firstContentItem.click();
    }

    public void openDetailAssignEmployee(){
        waitForElementToBeClickable(firstDetailAssignEmployee);
        firstDetailAssignEmployee.click();
    }


}