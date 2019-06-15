package stepdefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitions {
	
	
	public static WebDriver driver;
	@Before
	public void startBrowser()
	{
//		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	
	@After
	public void closeBrowser(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			String Base64 = "data:image/gif;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			Reporter.addScreenCaptureFromPath(Base64);
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
					
		}
		driver.quit();
	}

}
