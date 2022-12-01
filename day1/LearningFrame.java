package week4.day1;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearningFrame {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame("frame1");
		WebElement topic = driver.findElement(By.xpath("//b[@id ='topic']/following-sibling::input"));
		topic.sendKeys("Test");
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		WebElement aniList = driver.findElement(By.xpath("//select[@id ='animals']"));
		aniList.click();
		Select dd =new Select(aniList);
		dd.selectByVisibleText("Big Baby Cat");
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snap/leafgroundFrame.png");
		FileUtils.copyFile(source, destination);
		driver.switchTo().defaultContent();
		driver.quit();
		
		
		

	}

}
