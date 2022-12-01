package week4.classroom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		// Launch Firefox / Chrome
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement dragele = driver.findElement(By.id("draggable"));
		WebElement dropele = driver.findElement(By.id("droppable"));
		Actions action =new Actions(driver);
		//action.clickAndHold(dragele).moveToElement(dropele)action.release(dropele).build().perform();
		action.dragAndDrop(dragele, dropele).build().perform();
	}

}
