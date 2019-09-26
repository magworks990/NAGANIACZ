package facebook;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddFriends extends Public {
    public static void main(String[] args) throws InterruptedException {

//        WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        loginFacebook(wait, driver);

//        <><><><><><><><><><><><><><><> Strony zagraniczne <><><><><><><><><><><><><><><>
//        driver.get("https://www.facebook.com/groups/bmw02/members/"); --> BMW 2002
//        driver.get("https://www.facebook.com/groups/115023058840474/members/"); --> BMW E3 New Six Bavaria Enthusiasts
//        driver.get("https://www.facebook.com/groups/bmw850/members/"); --> BMW 850 & 840 (E31) World Owners Association
//        driver.get("https://www.facebook.com/groups/579196652112445/members/"); --> BMW PARTS!
//        driver.get("https://www.facebook.com/groups/688014824593987/members/"); --> BMW E36 world
//        driver.get("https://www.facebook.com/groups/1526653707352511/members/"); --> Best for BMW
//        driver.get("https://www.facebook.com/groups/1403548269911665/"); --> BMW Cars and Parts For Sale/Wanted
//        driver.get("https://www.facebook.com/groups/1403548269911665/"); --> BMW E30

//        driver.get("https://www.facebook.com/groups/173969213254239/members/"); --> Porsche 911 Sale & Swap
//        driver.get("https://www.facebook.com/groups/1609009792739751/"); --> Porsche 911 Buy and Sell
//        driver.get("https://www.facebook.com/groups/DailyDrivenPorsches/members/"); --> Porsche Parts & Cars 911 993 996 997  Buy / Sell / Trade
//        driver.get("https://www.facebook.com/groups/1610963219178885/members/"); --> Porsche 986&996 buy/sell/trade
//        driver.get("https://www.facebook.com/groups/232090670277264/members/"); --> 98-04 Porsche Carrera 996 Owners and Parts for Sale (Buy / Sell / Trade)




//        driver.get("https://www.facebook.com/groups/222664904823804/members/");
//        driver.get("https://www.facebook.com/groups/385823398185966/members/");
//        driver.get("https://www.facebook.com/groups/1111229682332268/members/");
//        driver.get("https://www.facebook.com/groups/CzesciAutBMW/members/");
        driver.get("https://www.facebook.com/groups/663314357106581/members/");
//        driver.get("https://www.facebook.com/groups/910212789097640/");
//        driver.get("https://www.facebook.com/groups/649243808606203/"); -- BMW F30/F31/F32/F33/F34/F36/F80 giełda, części, auta porady :)
//        driver.get("https://www.facebook.com/groups/1057932024308213/members/"); -- BMW Seria 5 F10/F11 Polska giełda/części/porady
//        driver.get("https://www.facebook.com/groups/782057918519221/members/"); -- BMW E38 Giełda części
//        driver.get("https://www.facebook.com/groups/186670581710272/"); -- BMW X5/X6/X3/X4/X1 giełda/części/samochody/porady
//        driver.get("https://www.facebook.com/groups/920847614628438/"); -- BMW X5 | F15 E70
//        driver.get("https://www.facebook.com/groups/645628732193696/"); -- BMW F80/F82/F83 M3 & M4 Discussion/Marketplace
//        driver.get("https://www.facebook.com/groups/334210040360504/"); -- BMW ///MPower 🔵
//        driver.get("https://www.facebook.com/groups/1617206405241924/"); -- BMW 5 G30 F10 F11 Polska Giełda Forum Kupię Sprzedam Porady ZAPRASZAMY !!!
//        driver.get("https://www.facebook.com/groups/215046048847455/members/"); -- BMW e90/91/92/93 Polska
//        driver.get("https://www.facebook.com/groups/225083915090915/members/"); -- BMW F10 F11 Polska Giełda/porady
//        driver.get("https://www.facebook.com/groups/1208345632628270/"); -- BMW Garage √
//        driver.get("https://www.facebook.com/groups/1562850254038917/?ref=discover_related_groups"); -- BMW e39 Forum.PL





        try {
            for (int i = 0; i < 1; i++) {
                System.out.print("\nSkrola użyto " + i + " razy");
                if (driver.findElement(By.id("groupsMemberBrowser")).getText().contains("Paweł Grzegorczyk123")) {
                    System.out.println("\nStrona została przewinięta do końca");
                    break;
                } else if (!driver.findElement(By.id("groupsMemberBrowser")).getText().contains("Paweł Grzegorczyk123")) {
                    JavascriptExecutor scroll = (JavascriptExecutor) driver;
                    scroll.executeScript("window.scrollBy(0, 5000)", "");
                }
            }
        } catch (Exception ignored) {
        }

        try {
            List<WebElement> friendButtons = driver.findElements(By.className("FriendButton"));
            int size = friendButtons.size();
            int licznik = 0;
            System.out.println("Pokaż rozmiar: " + size);
            for (WebElement friendButton : friendButtons) {
//                Thread.sleep(100);
                if (friendButton.getText().contains("Dodaj")) {
//                    Thread.sleep(50);
                    friendButton.click();
                    JavascriptExecutor scroll = (JavascriptExecutor) driver;
                    scroll.executeScript("window.scrollBy(250,350)", "");
//                    friendButton.sendKeys(Keys.ARROW_DOWN);
                    checkExceptionDialog(wait, driver);
                    checkConfirmationMessage(wait, driver);
                    System.out.println("Wysłano " + licznik++ + " zaproszenie");
                }
            }
        } catch (WebDriverException ignored) {
//        } catch (Exception e) {
        }
    }

    private static void checkConfirmationMessage(WebDriverWait wait, WebDriver driver) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='confirmation_message'][contains(text(),'Zalecamy wysyłanie zaproszeń do grona znajomych tylko do osób')]")));
            System.out.println("Kliknij klawisz: POTWIERDŹ aby kontynuować dodawanie znajomych ");
            driver.findElement(By.xpath("//a[contains(text(),'Anuluj')]/following-sibling::button")).click();
        } catch (WebDriverException ignored) {
        }
    }

    private static void checkExceptionDialog(WebDriverWait wait, WebDriver driver) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Osoby, które możesz znać” to lista znajomych sugerowana')]")));
            System.out.println("Kliknij klawisz: ZAMKNIJ aby kontynuować dodawanie znajomych ");
            driver.findElement(By.xpath("//a[contains(text(),'Zamknij')]")).click();
        } catch (WebDriverException ignored) {
        }
    }

}

//h3[contains(@class,'_52c9')]


