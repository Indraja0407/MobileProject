package Demo;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import net.bytebuddy.asm.Advice.Argument;

public class cricbuzzapp extends capability {

	AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void bt() throws MalformedURLException
	{
		driver = capabilities();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void testcase1() throws MalformedURLException, InterruptedException
	{
		driver.get("https://www.cricbuzz.com");
		//menu
		driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[3]/div[2]/a/span[1]")).click();
		//home
		driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[12]/table/tbody/tr[1]/td[1]/a")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
  		WebElement ele = driver.findElement(By.xpath("//*[@id=\"top\"]/div/div[8]/h4"));
  		js.executeScript("arguments[0].scrollIntoView()",ele);
  		String actual = ele.getText();
  		String expected ="Top Stories";
  		Assert.assertEquals(actual, expected, "Headings not matched");
	}
	


}
