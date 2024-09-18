package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BasePage;

public class LoginPage extends BasePage {

   @FindBy(className = "VGMdYn")
   private static WebElement loginButton;
   @FindBy(id = "input_comp-kyjvk6gq")
   private static WebElement usernameField;
   @FindBy(id = "input_comp-kyjvk6hc")
   private static WebElement passwordField;
   @FindBy(xpath = "//span[text()='Log In']")
   private WebElement logIn;
   @FindBy(id = "comp-k7but0of")
   private WebElement user;


   public LoginPage(WebDriver pWebDriver) {
      super(pWebDriver);
   }

   public void login(String username, String password) throws InterruptedException {
      Thread.sleep(6000);
      click(loginButton);
      sendText(usernameField, username);
      sendText(passwordField, password);
      Thread.sleep(2000);
      click(logIn);
   }

   public boolean isUserLoggedIn() throws InterruptedException {
      System.out.println("BBBBB" + user.getText() );
      return !user.getText().equals("Prijavi se") ? true : false;
   }
}
