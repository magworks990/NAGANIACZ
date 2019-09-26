package facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CancelFriend extends Public {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        loginFacebook (wait, driver);

        enterInvitationsSent (wait);
        showAllInvitationsSent (wait);
        deleteInvitationsSent(wait, driver);




    }
    private static void enterInvitationsSent (WebDriverWait wait) throws InterruptedException {
        System.out.println("[" + new java.util.Date() + "] " + "Entering invitations sent..." );
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("blueBarDOMInspector")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@name='requests']"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='fbRequestsList_wrapper']//span[contains(text(),'Zobacz wszystkie')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Pokaż wysłane zaproszenia')]"))).click();
        Thread.sleep(2000);
    }

    private static void showAllInvitationsSent (WebDriverWait wait) {
        System.out.println("[" + new java.util.Date() + "] " + "Showing all invitations sent..." );
        for (int i = 0; i < 16; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Wyświetl więcej zaproszeń')]"))).click();
        }
    }



    private static void deleteInvitationsSent(WebDriverWait wait, WebDriver driver) throws InterruptedException {
        System.out.println("[" + new java.util.Date() + "] " + "Deleting invitations sent..." );
        int licznik = 0;
        List<WebElement> invitations = driver.findElements(By.className("ruResponseButtons"));
        int size = invitations.size();
        System.out.println("Pokaż rozmiar: " + size);
        for (WebElement invitation : invitations){
            if (invitation.getText().contains("Wysłano zaproszenie do grona znajomych")){
                invitation.click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("friendFlyoutContent")));
//                driver.findElement(By.xpath("//div[@id='friendFlyoutContent']//li[@class='uiMenuItem FriendListCancel selected']//span[contains(text(),'Anuluj zaproszenie')]")).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Anuluj zaproszenie')]"))).click();
                processing(5);
                System.out.print("\r[" + new java.util.Date() + "] " + "Usunięto " + licznik++ + " zaproszenie");

            }
        }

    }


}
