package CUPI;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Assignment {
public static void main(String[] args) throws InterruptedException, IOException {
	WebDriver driver= new ChromeDriver();Thread.sleep(2000);
	driver.manage().window().maximize();Thread.sleep(2000);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.flipkart.com/");Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='✕']")).click();Thread.sleep(2000);
    WebElement search = driver.findElement(By.xpath("//input[contains(@title,'Search for Products')]"));
	search.sendKeys("Bluetooth Speakers");
	search.sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("//div[text()='Brand']")).click();
	driver.findElement(By.xpath("//div[text()='boAt']")).click();Thread.sleep(2000);
	driver.findElement(By.xpath("//div[contains(text(),'4★ & above')]")).click();
	driver.findElement(By.xpath("//div[text()='Price -- Low to High']")).click();
	driver.findElement(By.xpath("(//a[contains(@href,'/p/')])[1]")).click();
	Set<String> allwin = driver.getWindowHandles();
	for(String window:allwin) {
		driver.switchTo().window(window);
	}
	List<WebElement> offers = driver.findElements(By.xpath("//div[contains(text(),'Bank offers')]/following::div[contains(text(),'Apply')]"));Thread.sleep(2000);
	int count = offers.size();
	System.out.println("Number of Offers : " +count);
	driver.findElement(By.xpath("//div[contains(text(),'Add to cart')]")).click();Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='Cart']")).click();Thread.sleep(2000);
	TakesScreenshot ts= (TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest = new File("./screensort/result.png");
	FileHandler.copy(src, dest);
	driver.quit();


}
}
