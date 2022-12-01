package week4.classroom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableeRail {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		// Launch Firefox / Chrome
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		//Thread.sleep(2000);
		from.sendKeys("MAS",Keys.TAB);
		 
		WebElement destination = driver.findElement(By.id("txtStationTo"));
		destination.clear();
		destination.sendKeys("Coimbatore", Keys.TAB);
		
	
		
	
		
	}

}
