package week4.classroom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Alert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertLearn {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("accept-choices")).click();
		driver.switchTo().frame("iframeResult");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Rathi");
		alert.accept();
		WebElement name = driver.findElement(By.id("demo"));
		String text = name.getText();
		System.out.println(text);

		if (text.contains("Rathi")) {
			System.out.println("successfully done");
		} else {
			System.out.println("Have to try");
		}

	}
}
