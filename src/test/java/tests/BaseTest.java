package tests;

import org.openqa.selenium.WebDriver;

import common.WebDriverConfiguration;

public class BaseTest {
   protected static WebDriver driver;

 //  @BeforeMethod
   public static void setup(String executionType, String browser, String hubUrl) throws Exception {
      if ("remote".equalsIgnoreCase(executionType)) {
         driver = WebDriverConfiguration.createRemoteWebDriver(browser, hubUrl);
      } else {
         driver = WebDriverConfiguration.createLocalWebDriver(browser);
      }

      driver.manage().window().maximize();
   }
}
