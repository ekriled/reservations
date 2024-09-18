package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.BasePage;

public class ReserveAppointment extends BasePage {

   @FindBy(id = "comp-km4lagd8_r_comp-k0ywzbu5")
   private static WebElement rightArrow;

   @FindBy(xpath = "//*[contains(@aria-label, 'Rezerviraj, BASIC PILATES, 16:30')]")
   private static WebElement reservePilatesButton;

   @FindBy(xpath = "//span[text()='Rezerviraj odmah']")
   private static WebElement reserveNow;

   @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/main/div/div/div/div[2]/div/div/div/section/div[2]/div/div/div/div/div/div[2]/div[1]/div[3]/div/div[3]/fieldset/div/div[2]/div/div")
   private static WebElement phoneNumber;

   public ReserveAppointment(WebDriver pWebDriver) {
      super(pWebDriver);
   }

   public void reserveWallPilates() throws InterruptedException {
      Thread.sleep(7000);
      click(rightArrow);
      waitUntilElementIsClickable(reservePilatesButton);
      click(reservePilatesButton);
   }

   private void selectDay(String day) throws InterruptedException {
      Thread.sleep(3000);
      WebElement dayElement = driver.findElement(By.xpath("//*[contains(@aria-label, '" + day + "')]"));
      waitUntilElementIsClickable(dayElement);
      click(dayElement);
   }

   public void reserveNow() throws InterruptedException {
      driver.navigate().refresh();
      waitUntilElementIsClickable(reserveNow);
      click(reserveNow);
   }
}
