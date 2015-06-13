package bigdata.datascraper.flipkart;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestFlipkart {
	public static void main(String[] args) throws Exception {
        // Instantiate the full fledged FF selenium webdriver object. 
        WebDriver driver = new FirefoxDriver();
        
        // Load up the Flipjart's home page.
        driver.get("http://www.flipkart.com");
        
        // Enter the query string "whatever", this will soon be replaced with strings added 
        // in an excel file
        WebElement query = driver.findElement(By.id("fk-top-search-box"));
        //Send search query to the top search bar.
        query.sendKeys("nokia lumia");
        
        //Submit the search form now.
        driver.findElement(By.id("fk-header-search-form")).submit();
        
        //On the resulting page, load up all the elements with class as pu-title
        List<WebElement> lstProducts = driver.findElements(By.className("pu-title"));
        for (WebElement webElement : lstProducts) {
        	System.out.println(webElement.getText());
        	WebElement aLink = webElement.findElement(By.xpath(".//a"));
        	String aHref = aLink.getAttribute("href");
        	System.out.println("aj - " + aHref);
 		}
        driver.quit();
    }
}
