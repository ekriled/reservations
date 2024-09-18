package common;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverConfiguration {

   public static WebDriver createLocalWebDriver(String browser) {
      WebDriver driver;

      switch (browser.toLowerCase()) {
         case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            break;

         case "chrome":
         default:
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            break;
      }
      return driver;
   }


   public static WebDriver createRemoteWebDriver(String browser, String hubUrl) throws MalformedURLException {
      DesiredCapabilities capabilities = new DesiredCapabilities();

      switch (browser.toLowerCase()) {
         case "firefox":
            capabilities.setBrowserName("firefox");
            capabilities.setPlatform(Platform.ANY);
            break;

         case "chrome":
         default:
            capabilities.setBrowserName("chrome");
            capabilities.setPlatform(Platform.ANY);
            break;
      }

      return new RemoteWebDriver(new URL(hubUrl), capabilities);
   }


}
