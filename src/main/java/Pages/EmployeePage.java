package Pages;

import Core.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class EmployeePage extends BasePage {
    private static final Logger log = LogManager.getLogger(EmployeePage.class);

    public EmployeePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "layout-desktop-menu-item-link-training")
    private WebElement trainingNavbarMenu;

    @FindBy(xpath = "//p[text()='Manage Employee List']")
    private WebElement titleManageEmployee;

    @FindBy(xpath = "//button[@role='tab'][contains(text(), 'Division')]")
    private WebElement tabDivision;

    @FindBy(id = "add-division-button")
    private WebElement addDivision;

    @FindBy (id = "detail-division-button")
    private WebElement detailDivisionButton;

    @FindBy(css = "input[name='Division Name']")
    private WebElement divisionNameTextField;

    @FindBy (id = "description")
    private WebElement divisionDescriptionTextField;

    @FindBy (id = "add-division-confirm-button")
    private WebElement saveDivisionButton;

    @FindBy(xpath = "//tr[.//text()[normalize-space()='General, Secretariat & " +
            "IT']]//a[contains(@href,'/division/')]")
    private WebElement detailGeneralSecretariatITDivisionButton;




    @FindBy(xpath = "//button[@role='tab' and .//text()[normalize-space()='Employee List']]")
    private WebElement tabEmployee;

    @FindBy (id = "button-add-employee")
    private WebElement addEmployeeButton;

    @FindBy (id = "employeeId")
    private WebElement employeeIdTextField;

    @FindBy(css = "input[name='Name']")
    private WebElement employeeNameTextField;

    @FindBy (id = "email")
    private WebElement emailTextField;

    @FindBy (id = "phoneNumber")
    private WebElement phoneNumberTextField;

    @FindBy (id = "division")
    private WebElement dropdowDivisionButton;

    @FindBy(xpath = "//option[text()='General, Secretariat & IT']")
    private WebElement optionGeneralSecretariatIT;

    @FindBy (id = "employeeRole")
    private WebElement employeeRoleTextField;

    @FindBy (id = "button-add-employee-submit")
    private WebElement addEmployeeSubmitButton;

    @FindBy(xpath = "//button[@data-action='transfer']")
    private WebElement transferEmployeMenu;

    @FindBy(xpath = "//button[@data-action='download']")
    private WebElement downloadEmployeeDataMenu;

    @FindBy(xpath = "//tr[.//text()[normalize-space()='Anindya Dewi Maharani']]//a[contains(@href,'/employee/')]")
    private WebElement detailAnindya;

    @FindBy (id = "add-division-confirm-button")
    private WebElement addDivisionConfirmButton;

    @FindBy (xpath =  "//*[contains(text(), 'Success create division')]")
    private WebElement popUpSuccessCreateDivision;

    @FindBy (xpath =  "//*[contains(text(), 'Success create employee')]")
    private WebElement popUpSuccessCreateEmployee;

    @FindBy (xpath = "(//table//tbody/tr[1]//button)[1]")
    private WebElement firstDivisionDetail;

    @FindBy (id = "tabs-admin-employee--tab-1")
    private WebElement divisionTab;

    @FindBy (xpath = "//tbody/tr[1]/td[last()]//button")
    private WebElement firstEmployeeDetail;

    @FindBy (id = "tabs-admin-employee--tab-0")
    private WebElement employeeTab;

    @FindBy(xpath = "((//tbody//tr)[1]//button)[1]")
    private WebElement firstTransferEmployeeButton;

    @FindBy (xpath = "//div[contains(@id, 'menu-list')]//button[text()='Transfer']")
    private WebElement transferButton;

    @FindBy (xpath = "//select[@name='Select Target Division']/option[text()='General, Secretariat & IT']")
    private WebElement selectedDivision;

    @FindBy (xpath = "//button[text()='Transfer Employee']")
    private WebElement transferEmployeeSubmitButton;

    @FindBy (xpath =  "//*[contains(text(), 'Berhasil mengubah data')]")
    private WebElement popUpSuccessTransferDivision;

    @FindBy(id = "menu-button-admin-employee-action")
    private WebElement dropdownAction;

    @FindBy (xpath = "//button[@role='menuitem' and contains(., 'Download')]")
    private WebElement downloadDataEmployeeButton;

    @FindBy (xpath = "//button[@role='menuitem' and contains(., 'Import')]")
    private WebElement importDataEmployeeButton;

    @FindBy (xpath = "//input[@type='file' and contains(@id, 'import-employees')]")
    private WebElement importFileEmployee;

    @FindBy (id = "import-employees-button")
    private WebElement importEmployeeSubmitButton;

    @FindBy (xpath =  "//p[text()='Succes Import Data']")
    private WebElement popUpSuccessImportDataEmployee;



    public void verifyEmployeeTitleIsDisplayed() {
        // Tunggu elemen muncul (Timeout 10 detik)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(titleManageEmployee));

        // Melakukan Assertion
        Assert.assertTrue(titleManageEmployee.isDisplayed(),
                "Dashboard Title Is Not Display : Failed Login");
    }

    public void createDivision(String divisionName, String divisionDescription){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(tabDivision));
        tabDivision.click();
        wait.until(ExpectedConditions.visibilityOf(addDivision));
        addDivision.click();
        wait.until(ExpectedConditions.visibilityOf(divisionNameTextField));
        divisionNameTextField.sendKeys(divisionName);
        divisionDescriptionTextField.sendKeys(divisionDescription);
        saveDivisionButton.click();
    }

    public void verifySuccessAddDivision (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToBeVisible(popUpSuccessCreateDivision);
        Assert.assertTrue(popUpSuccessCreateDivision.isDisplayed(),
                "Success Pop-up is not displayed: Failed to create division");
    }

    public void createEmployee(String employeeId, String employeeName, String email, String phoneNumber,String role){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(
//                By.cssSelector(".chakra-form-control")
//        ));
        wait.until(ExpectedConditions.elementToBeClickable(tabEmployee));

        tabEmployee.click();
        addEmployeeButton.click();
        employeeIdTextField.sendKeys(employeeId);
        employeeNameTextField.sendKeys(employeeName);
        emailTextField.sendKeys(email);
        phoneNumberTextField.sendKeys(phoneNumber);
        waitForElementToBeClickable(dropdowDivisionButton);
        dropdowDivisionButton.click();
        waitForElementToBeClickable(optionGeneralSecretariatIT);
        optionGeneralSecretariatIT.click();
        employeeRoleTextField.sendKeys(role);
        addEmployeeSubmitButton.click();
    }

    public void verifySuccessCreateEmployee(){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            waitForElementToBeVisible(popUpSuccessCreateEmployee);
            Assert.assertTrue(popUpSuccessCreateEmployee.isDisplayed(),
                    "Success Pop-up is not displayed: Failed to create employee");
    }

    public void fromEmployeeMoveToTraining(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.cssSelector("div.chakra-modal__content-container")
        ));
        trainingNavbarMenu.click();
    }

    public void openDetailDivision(){
        waitForElementToBeVisible(firstDivisionDetail);
        firstDivisionDetail.click();
    }

    public void moveToDivisionTab(){
        waitForElementToBeVisible(divisionTab);
        divisionTab.click();
    }

    public void moveToEmployeeTab(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToBeClickable(employeeTab);
        employeeTab.click();
    }

    public void openDetailEmployee(){
        waitForElementToBeVisible(firstEmployeeDetail);
        firstEmployeeDetail.click();
    }

    public void checkDuplicateDivisionData(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToBeVisible(popUpSuccessCreateEmployee);
        Assert.assertTrue(popUpSuccessCreateEmployee.isDisplayed(),
                "Success Pop-up is not displayed: Failed to create employee");
    }

    public void transferDivision(){
        waitForElementToBeClickable(dropdownAction);
        dropdownAction.click();
        waitForElementToBeClickable(transferButton);
        transferButton.click();
        waitForElementToBeVisible(firstTransferEmployeeButton);
        firstTransferEmployeeButton.click();
        waitForElementToBeVisible(selectedDivision);
        selectedDivision.click();
        waitForElementToBeClickable(transferEmployeeSubmitButton);
        transferEmployeeSubmitButton.click();
    }

    public void verifySuccessTransferDivision(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToBeVisible(popUpSuccessTransferDivision);
        Assert.assertTrue(popUpSuccessTransferDivision.isDisplayed(),
                "Success Pop-up is not displayed: Failed to transfer division");
    }

    public void downloadDataEmployee(){
        waitForElementToBeClickable(dropdownAction);
        dropdownAction.click();
        waitForElementToBeVisible(downloadDataEmployeeButton);
        downloadDataEmployeeButton.click();

    }

    public void verifyDownloadSuccess(String fileNamePart) {
        // 1. Verifikasi UI (Tetap lakukan ini agar yakin tidak crash)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(titleManageEmployee));
        Assert.assertTrue(titleManageEmployee.isDisplayed(), "Gagal kembali ke halaman Detail Employee");

        // 2. Verifikasi File Fisik (Gunakan Java File IO)
        String path = System.getProperty("user.dir") + java.io.File.separator + "downloads";
        java.io.File folder = new java.io.File(path);

        // Kita beri sedikit waktu tunggu agar download selesai sempurna
        boolean isFilePresent = false;
        for (int i = 0; i < 10; i++) { // Retry selama 10 detik
            java.io.File[] files = folder.listFiles();
            if (files != null) {
                for (java.io.File file : files) {
                    if (file.getName().contains(fileNamePart)) {
                        isFilePresent = true;
                        break;
                    }
                }
            }
            if (isFilePresent) break;
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }

        // Assertion Utama untuk File
        Assert.assertTrue(isFilePresent, "File dengan nama " + fileNamePart + " tidak ditemukan di folder download!");
    }

    public void importEmployee(String filePath){
        waitForElementToBeClickable(dropdownAction);
        dropdownAction.click();
        waitForElementToBeVisible(importDataEmployeeButton);
        importDataEmployeeButton.click();
        //waitForElementToBeVisible(importFileEmployee);
        importFileEmployee.sendKeys(filePath);
        waitForElementToBeClickable(importEmployeeSubmitButton);
        importEmployeeSubmitButton.click();
    }

    public void verifySuccessImportDataEmployee(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForElementToBeVisible(popUpSuccessImportDataEmployee);
        Assert.assertTrue(popUpSuccessImportDataEmployee.isDisplayed(),
                "Success Pop-up is not displayed: Failed to import data");
    }







}
