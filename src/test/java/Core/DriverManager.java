package Core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser) {
        WebDriver webDriver = null;
        switch (browser.toLowerCase()) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();

                options.addArguments("--disable-blink-features=AutomationControlled");
                options.addArguments("--user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
                options.addArguments("--disable-web-resources");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-plugins");
                options.addArguments("--disable-component-extensions-with-background-pages");
                options.setExperimentalOption("useAutomationExtension", false);
                options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

                java.util.Map<String, Object> prefs = new java.util.HashMap<>();
// Matikan pop-up "Save As" sistem operasi
                prefs.put("download.prompt_for_download", false);
// Tentukan folder download otomatis ke folder 'downloads' di project kamu
                String downloadPath = System.getProperty("user.dir") + java.io.File.separator + "downloads";
                prefs.put("download.default_directory", downloadPath);
// Izinkan download otomatis tanpa konfirmasi tambahan
                prefs.put("profile.default_content_settings.popups", 0);
                prefs.put("download.directory_upgrade", true);

                options.setExperimentalOption("prefs", prefs);
                String githubActions = System.getenv("GITHUB_ACTIONS");
                if (githubActions != null && githubActions.equals("true")) {
                    options.addArguments("--headless");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                }
                webDriver = new ChromeDriver(options);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
            }
        }
        driver.set(webDriver);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

}
