package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsLearning {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// 1. Launch URL
		driver.get("https://www.leafground.com/window.xhtml;jsessionid=node010nx464jtc8vzxsmrg4fp0yu9138.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Click and Confirm new Window Opens
		driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();
		System.out.println("The Title of the opened new Window is " + driver.getTitle());
		Set<String> newWindow = driver.getWindowHandles();
		System.out.println(newWindow);
		List<String> openWindow = new ArrayList<String>(newWindow);
		System.out.println(openWindow.size());

		// back to first window
		driver.switchTo().window(openWindow.get(0));
		// Find the number of opened tabs
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		newWindow = driver.getWindowHandles();
		openWindow = new ArrayList<String>(newWindow);
		System.out.println(driver.getWindowHandles().size());

		System.out.println(openWindow.size());
		// System.out.println(openWindow);
		driver.switchTo().window(openWindow.get(0));
		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		driver.switchTo().window(openWindow.get(0));
		String present = driver.getWindowHandle();
		for (String string1 : openWindow) {
			if (string1.equals(present))
				driver.switchTo().window(present);

			else {
				driver.switchTo().window(string1);
				driver.close();
			}
		}

	}
}