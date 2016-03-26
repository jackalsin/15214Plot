package main.src;

import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by jacka on 3/26/2016.
 */
public class WikiTest {

    private static final String URL = "https://www.linkedin.com/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get(URL);


        WebElement loginUsername = driver.findElement(By.id("login-email"));
        loginUsername.clear();
        loginUsername.sendKeys("zxviagra@yahoo.com");

        WebElement loginPassword = driver.findElement(By.id("login-password"));
        loginPassword.clear();
        loginPassword.sendKeys("xinzhiwei2589064");

        driver.findElement(By.name("submit")).click();


        System.out.println(driver.getPageSource());

        driver.findElement(By.cssSelector("li[data-li-activity-type='addconnections'] > :first-child")).click();

        WebElement searchBox = driver.findElement(By.id("main-search-box"));

        searchBox.sendKeys("micheal sean");

        driver.findElement(By.cssSelector("button.search-button")).click();

        

        Thread.sleep(5000);

//        driver.quit();

    }
}
