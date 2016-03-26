package main.src;

import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jacka on 3/26/2016.
 */
public class WikiTest {

    private static final String URL = "https://www.linkedin.com/";

    private static final String keywordToSearch = "Jeff Dean Google";

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


//        System.out.println(driver.getPageSource());

        driver.findElement(By.cssSelector("li[data-li-activity-type='addconnections'] > :first-child")).click();

        WebElement searchBox = driver.findElement(By.id("main-search-box"));

        searchBox.sendKeys(keywordToSearch);

        driver.findElement(By.cssSelector("button.search-button")).click();

        List<WebElement> allPeople = driver.findElements(By.cssSelector(".title.main-headline"));
        /* use find elements here */

        /* example 0 here */
        WebElement zeroPerson = allPeople.get(0);
        zeroPerson.click();


        WebElement skillSection = driver.findElement(By.className("skills-section"));
        List<WebElement> skillList = skillSection.findElements(By.tagName("li"));

        for (WebElement webElement : skillList) {
            String text = webElement.getAttribute("data-endorsed-item-name");
            if (text != null && !text.equals("")) {
                System.out.println("\t" + text.trim());

                // create template methods to

            }
        }


//        List<WebElement> skillList = driver.findElements(By.cssSelector("li [data-endorsed-item-name]"));


//        System.out.println("\n\n\nskills = \t" + Arrays.toString(skillList.toArray()));




//        driver.quit();

    }
}
