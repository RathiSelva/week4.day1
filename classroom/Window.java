package week4.classroom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//a[contains(text(),' FLIGHTS')]")).click();
		String parentWin = driver.getWindowHandle();
		System.out.println(parentWin);
		
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		
		List<String>windows = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		System.out.println(driver.getTitle());
		driver.switchTo().window(windows.get(0));
		driver.close();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class = 'Nav-icons Maharajas']")).click();
		Set<String> windowNew = driver.getWindowHandles();
		System.out.println(windowNew);
		List<String> maharajaWin =new ArrayList<String>(windowNew);
		driver.switchTo().window(windows.get(2));
		
		
		
		
		
	}

	
}
