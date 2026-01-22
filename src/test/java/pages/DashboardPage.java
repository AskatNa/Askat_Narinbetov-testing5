package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class DashboardPage {

    private static final Logger log = LogManager.getLogger(DashboardPage.class);

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By logoutButton = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a");
    private final By dashboardHeader = By.xpath("//h6[text()='Dashboard']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isDisplayed() {
        log.info("Check if Dashboard page is displayed");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader)).isDisplayed();
    }

    public void logout() {
        log.info("Click on Logout button");

        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));

        wait.until(ExpectedConditions.visibilityOf(logoutBtn));

        logoutBtn.click();
    }


}
