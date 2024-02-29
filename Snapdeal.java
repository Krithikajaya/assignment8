package assignment8;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Snapdeal {
	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");
		driver.findElement(By.xpath("(//span[@class='catText'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		List<WebElement> s = driver.findElements(By.xpath("//p[@class='product-title']"));
		System.out.println(s.size());
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
		List<WebElement> s1 = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		System.out.println(s1.size());
		
		
		WebElement scroll = driver.findElement(By.xpath("//div[@data-show-div='#js-255-nav']"));
		scroll.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-plus'])[1]")).click();
		Thread.sleep(1000);
		WebElement x = driver.findElement(By.xpath("(//input[@class='input-filter'])[1]"));
		x.clear();
		x.sendKeys("600",Keys.ENTER);
		WebElement y = driver.findElement(By.xpath("(//input[@class='input-filter'])[2]"));
		y.clear();
		y.sendKeys("700",Keys.ENTER);
		
		WebElement a = driver.findElement(By.xpath("//div[@class='col-xs-6  favDp product-tuple-listing js-tuple ']"));
		Actions b=new Actions(driver);
		b.moveToElement(a).perform();
		b.click();
						
		driver.findElement(By.xpath("(//div[contains(text(),'Quick')])[1]")).click();
		String j = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println(j);
		
		String k = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println(k);
		
		WebElement h = driver.findElement(By.xpath("//img[@class='cloudzoom']"));
		File k1=h.getScreenshotAs(OutputType.FILE);
		File k2=new File("./snap/img2.png");
		FileUtils.copyFile(k1, k2);
		
		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
		driver.close();

}
}