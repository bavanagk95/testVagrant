package scripts;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.Baseclass;
import com.GenericUtilities.FileUtilies;
import com.GenericUtilities.WebdriverUtilties;
import com.ObjectRepo.Imdb;
import com.ObjectRepo.Wikipedia;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CompareTest extends Baseclass{
	@Test
	public void movieDataComparisonTest()
	{
		//Navigate to imdb 
		try {
			String imdbUrl = fu.getPropertyKeyValue("imdburl");
			driver.get(imdbUrl);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		wb.waitForElementInDOM(driver);
		
		//Scroll to particular element in imdb
		Imdb imdb = new Imdb(driver);
		wb.ScrollToParticularElement(driver, imdb.getDate());
							
		//Fetch Data from imdb
		String imdbCountry = imdb.getCountry().getText();
		System.out.println(imdbCountry);
		String imdbDate = imdb.getDate().getText();
		System.out.println(imdbDate);
		
		//Navigate to Wikipedia portal
		try {
			String wikiUrl = fu.getPropertyKeyValue("wurl");
			driver.get(wikiUrl);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		wb.waitForElementInDOM(driver);
		
		//Scroll to particular element in wikipedia
		Wikipedia wiki = new Wikipedia(driver);
		wb.ScrollToParticularElement(driver, wiki.getDate());
		
		
		//Fetch Data from wikipedia 
		String wikiCountry = wiki.getCountry().getText();
		System.out.println(wikiCountry);
		String wikiDate = wiki.getDate().getText();
		System.out.println(wikiDate);
		
		//validation//
		Assert.assertEquals(imdbCountry, wikiCountry);
		Assert.assertEquals(imdbDate, wikiDate);
		
	}
}

	


