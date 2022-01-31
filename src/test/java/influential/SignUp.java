package influential;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;

public class SignUp {

    @Test
    public void signUp() {
        System.setProperty("chromedriver.driver", "home/dm/IdeaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://influential.co/");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//span[@class='adroll_consent_title']")));

        driver.findElement(By.xpath("//div[@id='adroll_allow_all']")).click();

        driver.findElement(By.xpath("//a[text()='Sign In']")).click();
        driver.findElement(By.xpath("//p[text()='Influencer Authentication']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//section[@class='form']")));
        Random random = new Random();
        int n = random.nextInt(100)+1;
        String email = "klichko"+ n + "@gmail.com";
        String username = "Vitalii";

        driver.findElement(By.id("first")).sendKeys(username);
        driver.findElement(By.id("last")).sendKeys("Klichko");
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.xpath("//i[@class='box far fa-square']")).click();
        driver.findElement(By.id("next")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                    ("//section[@class='title']")));
        String title = driver.getTitle();
        System.out.println(title);

        if (title.equals("Influential")) {
            System.out.println("Test Passed Successfully!!!");
//            driver.quit();
        } else {
            System.out.println("Test Failed!!!");
        }

//        driver.manage().window().setSize(new Dimension(300, 300));
//        driver.quit();
    }
}
