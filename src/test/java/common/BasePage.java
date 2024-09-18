package common;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
   protected WebDriver driver;
   public static final Duration TIMEOUT_PAGELOAD = Duration.ofSeconds(10);
   public static final Duration TIMEOUT_IMPLICITLYWAIT = Duration.ofSeconds(10);
   public static final Duration TIMEOUT_WAIT_FOR_CLICKABLE = Duration.ofSeconds(20);
   public static final Duration TIMEOUT_WAIT_FOR_VISIBILITY = Duration.ofSeconds(10);

   protected BasePage(WebDriver pWebDriver) {
      driver = pWebDriver;
      PageFactory.initElements(driver, this);
   }

   public static void switchWindows(WebDriver driver, String currentWindowHandle) {
      Set<String> allWindowHandles = driver.getWindowHandles();
      for (String windowHandle : allWindowHandles) {
         if (!windowHandle.equals(currentWindowHandle)) {
            driver.switchTo().window(windowHandle);
            break;
         }
      }
   }

   public void waitUntilElementIsClickable(WebElement element) {
      WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_WAIT_FOR_CLICKABLE);
      wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
   }

   public void waitUntilElementIsVisible(WebElement element) {
      WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_WAIT_FOR_VISIBILITY);
      wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
   }

   public boolean isElementVisible(WebElement element) {
      return element.isDisplayed();
   }


   public void click (WebElement element) {
      waitUntilElementIsClickable(element);
      element.click();
   }

   public void sendText (WebElement element, String text) {
      waitUntilElementIsVisible(element);
      element.sendKeys(text);
   }
}
