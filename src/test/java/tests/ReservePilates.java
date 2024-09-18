package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ReserveAppointment;

public class ReservePilates  extends BaseTest{

   @Test
   public static void reserve() throws Exception {
      Properties props = new Properties();
      try (FileInputStream input = new FileInputStream("src/main/resources/config.properties")) {
         props.load(input);
      } catch (IOException e) {
         e.printStackTrace();
      }

      setup("local", "firefox", "");
      driver.get("https://www.mofit.hr/book-online");

      ReserveAppointment reservePage = new ReserveAppointment(driver);
      reservePage.reserveWallPilates();

      LoginPage loginPage = new LoginPage(driver);
      loginPage.login(props.getProperty("username"), props.getProperty("password"));
      Thread.sleep(3000);
      System.out.println("AAAA" + loginPage.isUserLoggedIn());
      if (!loginPage.isUserLoggedIn()) {
         loginPage.login(props.getProperty("username"), props.getProperty("password"));
      }
      Thread.sleep(3000);
      reservePage.reserveNow();
   }

  /* @AfterMethod
   public static void tearDown() {
      if (driver != null) {
         driver.quit();
      }
   }*/

}
