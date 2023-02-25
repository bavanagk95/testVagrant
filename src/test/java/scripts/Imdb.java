package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Imdb {
	
@Test
	
	public void wikipedia() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.imdb.com/title/tt9389998/");
		WebElement ele = driver.findElement(By.xpath("//a[text()='Release date']"));
		Point loc = ele.getLocation();
		int x = loc.x;
		int y = loc.y;
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
		WebElement date = driver.findElement(By.xpath("//a[text()='Release date']/following-sibling::div[@class='ipc-metadata-list-item__content-container']"));
		WebElement con = driver.findElement(By.xpath("//button[text()='Country of origin']/following-sibling::div[@class='ipc-metadata-list-item__content-container']"));
		String rdate = date.getText();
		String country = con.getText();
		System.out.println("release date="+rdate);
		System.out.println("country="+country);
		
}
}
