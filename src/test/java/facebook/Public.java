package facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Public {

    static void loginFacebook(WebDriverWait wait, WebDriver driver){

        String baseUrl = "https://www.facebook.com";
        driver.get(baseUrl);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("lukasz.samsel21@wp.pl");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass"))).sendKeys("lukaszsamsel", Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bluebarRoot")));
    }

    static  void processing (int waitTime)throws InterruptedException{
        for (int j = waitTime; j >= 0; j--) {
            System.out.print("\rWaiting " + j + " seconds for transaction realization...");
            Thread.sleep(1000);
        }
        System.out.print("\r");
    }
}
git