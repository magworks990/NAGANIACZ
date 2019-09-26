import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestMaven {

    @Test
    public void sayHello(){
        System.out.println("TestMaven <%><#><@><$>R$");
        WebDriver driver = new FirefoxDriver();
    }
}
