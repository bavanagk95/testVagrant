package scripts;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericUtilities.Baseclass;
import com.GenericUtilities.FileUtilies;
import com.GenericUtilities.WebdriverUtilties;
import com.ObjectRepo.Imdb;
import com.ObjectRepo.Wikipedia;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wiki extends Baseclass{
	@Test
	
	public ArrayList<String> wikipedia() throws Throwable {
		/*WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		WebElement date = driver.findElement(By.xpath("//th[text()='Pushpa: The Rise – Part 01']/../following-sibling::tr/th/div[text()='Release date']/../following-sibling::td[@class='infobox-data']/div/ul/li"));
		WebElement con = driver.findElement(By.xpath("//th[text()='Pushpa: The Rise – Part 01']/../following-sibling::tr/th[text()='Country']/following-sibling::td"));
		String rdate = date.getText();
		String country = con.getText();
		System.out.println("release date="+rdate);
	    System.out.println("country="+country);*/
		
		WebdriverUtilties wb=new WebdriverUtilties();
		FileUtilies fu=new FileUtilies();
		Wikipedia wiki=new Wikipedia(driver);
		
		//Browser launching
		
		String BROWSER = fu.getPropertyKeyValue("chrome");
		wb.waitForElementInDOM(driver);
		
		//enter url
		
		driver.get(fu.getPropertyKeyValue("wurl"));
		Point loc = wiki.getDate().getLocation();
		int x = loc.x;
		int y = loc.y;
		wb.executeJavaScript(driver, x, y);
		
		//Fetching releaseDate
		
		WebElement date = wiki.getDate();
		String wikiDate = date.getText();
		System.out.println("releaseDate="+wikiDate);
		
		
		//Fetching country name
		WebElement con = wiki.getCountry();
		String wikiCountry = con.getText();
		System.out.println("country="+wikiCountry);
		//String[] wikiData= {wikiDate,wikiCountry};
		ArrayList<String>wikiData=new ArrayList<String>();
		wikiData.add(wikiDate);
		wikiData.add(wikiCountry);
		return wikiData;
		
		
		}
	
	@Test(priority = 2)
	
	public ArrayList<String> iMDB() throws Throwable {
		WebdriverUtilties wb=new WebdriverUtilties();
		FileUtilies fu=new FileUtilies();
		Imdb im=new Imdb(driver);
		
		//Browser launching
		
		String BROWSER = fu.getPropertyKeyValue("chrome");
		wb.waitForElementInDOM(driver);
		
		//enter url
		
		driver.get(fu.getPropertyKeyValue("imdburl"));
		Point loc = im.getDate().getLocation();
		int x = loc.x;
		int y = loc.y;
		wb.executeJavaScript(driver, x, y);
		
		
		//Fetching releaseDate
		
		WebElement date = im.getDate();
		String imdbDate = date.getText();
		System.out.println("releaseDate="+imdbDate);
		
		//Fetching country name
		WebElement con = im.getCountry();
		String imdbCountry = con.getText();
		System.out.println("country="+imdbCountry);
		ArrayList<String>imdbData=new ArrayList<String>();
		imdbData.add(imdbDate);
		imdbData.add(imdbCountry);
		return imdbData; 
		
		
		}
	
	@Test(priority = 3)
	public void asserting() throws Throwable {
		Assert.assertEquals(wikipedia(),iMDB());
		System.out.println("both are same");
	}
		

		

	}


