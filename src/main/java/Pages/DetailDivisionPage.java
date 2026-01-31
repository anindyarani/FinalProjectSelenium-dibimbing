package Pages;

import Core.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DetailDivisionPage extends BasePage {
    private static final Logger log = LogManager.getLogger(DetailDivisionPage.class);

    public  DetailDivisionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "edit-division-button")
    private WebElement editDivisionButton;

    @FindBy(css = "input[name='Division Name']")
    private WebElement divisionNameEdit;

    @FindBy(css = "textarea[name='Division Description']")
    private WebElement divisionDescriptionEdit;

    @FindBy (id = "edit-division-confirm-button")
    private WebElement editDIvisionConfirmButton;

    @FindBy (id = "export-employee-button")
        private WebElement exportEmployeePerDivisionButton;

    @FindBy (xpath =  "//*[contains(text(), 'Success update division')]")
    private WebElement popUpSuccessUpdateDivision;

    @FindBy (xpath =  "//*[contains(text(), 'Success delete division')]")
    private WebElement popUpSuccessDeleteDivision;

    @FindBy(xpath = "//p[text()='Detail Division']")
    private WebElement titleDetailDivision;

    @FindBy (xpath = "//button[contains(., 'Delete Division')]")
    private WebElement deleteDivisionButton;

    @FindBy (xpath = "//footer[contains(@class, 'chakra-modal__footer')]//button[text()='Delete']")
    private WebElement deleteDivisionConfirmButton;

    @FindBy (id = "export-employee-button")
    private WebElement exportDivisionButton;



    public void verifyIsInDetailDivisionPage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(titleDetailDivision));

        // Melakukan Assertion
        Assert.assertTrue(titleDetailDivision.isDisplayed(),
                "Dashboard Title Is Not Display : Is Not In Detail Division Page");

    }

    public void updateDivision(String divisionNameUpdate, String divisionDescriptionUpdate){
        waitForElementToBeClickable(editDivisionButton);
        editDivisionButton.click();
        waitForElementToBeVisible(divisionNameEdit);
        divisionNameEdit.clear();
        divisionNameEdit.sendKeys(divisionNameUpdate);
        waitForElementToBeVisible(divisionDescriptionEdit);
        divisionDescriptionEdit.clear();
        divisionDescriptionEdit.sendKeys(divisionDescriptionUpdate);
        waitForElementToBeVisible(editDIvisionConfirmButton);
        editDIvisionConfirmButton.click();
    }

    public void verifySuccessUpdateDivision(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToBeVisible(popUpSuccessUpdateDivision);
        Assert.assertTrue(popUpSuccessUpdateDivision.isDisplayed(),
                "Success Pop-up is not displayed: Failed to update division");
    }

    public void deleteDivision(){
        waitForElementToBeVisible(editDivisionButton);
        editDivisionButton.click();
        waitForElementToBeClickable(deleteDivisionButton);
        deleteDivisionButton.click();
        waitForElementToBeClickable(deleteDivisionConfirmButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> {
            try {
                // Jangan pakai d.findElement(...) karena variabelnya sudah WebElement
                deleteDivisionConfirmButton.click();
                return true;
            } catch (ElementClickInterceptedException e) {
                // Ini akan menangkap 'chakra-modal__content-container' yang menghalangi
                // Selenium akan mencoba klik lagi otomatis setiap 500ms
                return false;
            } catch (Exception e) {
                return false;
            }
        });

    }

    public void verifySuccessDeleteDivision(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToBeVisible(popUpSuccessDeleteDivision);
        Assert.assertTrue(popUpSuccessDeleteDivision.isDisplayed(),
                "Success Pop-up is not displayed: Failed to delete division");
    }

    public void exportDivision(){
        waitForElementToBeClickable(exportDivisionButton);
        exportDivisionButton.click();
    }

    public void verifySuccessDownloadDataDivision(String fileNamePartDivision) {
        // 1. Verifikasi UI (Tetap lakukan ini agar yakin tidak crash)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(titleDetailDivision));
        Assert.assertTrue(titleDetailDivision.isDisplayed(), "Gagal kembali ke halaman Detail Divisi");

        // 2. Verifikasi File Fisik (Gunakan Java File IO)
        String path = System.getProperty("user.dir") + java.io.File.separator + "downloads";
        java.io.File folder = new java.io.File(path);

        // Kita beri sedikit waktu tunggu agar download selesai sempurna
        boolean isFilePresent = false;
        for (int i = 0; i < 10; i++) { // Retry selama 10 detik
            java.io.File[] files = folder.listFiles();
            if (files != null) {
                for (java.io.File file : files) {
                    if (file.getName().contains(fileNamePartDivision)) {
                        isFilePresent = true;
                        break;
                    }
                }
            }
            if (isFilePresent) break;
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }

        // Assertion Utama untuk File
        Assert.assertTrue(isFilePresent, "File dengan nama " + fileNamePartDivision + " tidak ditemukan di folder download!");
    }
}

