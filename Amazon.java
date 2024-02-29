package assignment8;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro", Keys.ENTER);
		String a = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println(a);
		String b=driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println(b);
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		Set<String> w1 = driver.getWindowHandles();
		List<String> window1=new ArrayList<String>(w1);
		System.out.println(window1.get(0));
		System.out.println(window1.get(1));
		driver.switchTo().window(window1.get(1));
		
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
		String f = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println(f);
		
		WebElement n = driver.findElement(By.xpath("//img[@class='sc-product-image celwidget']"));
		File screen=n.getScreenshotAs(OutputType.FILE);
		File dst=new File("./snap/img1.png");
		FileUtils.copyFile(screen, dst);
        
		driver.close();
		driver.switchTo().window(window1.get(0));
		driver.close();
}
}