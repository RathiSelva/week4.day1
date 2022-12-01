package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// 2. Enter UserName and Password Using Id Locator
		WebElement eleUsername = driver.findElement(By.id("username"));
		eleUsername.sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		// 4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		// 5. Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		// 6. Click on Merge Contacts using Xpath Locator

		driver.findElement(By.xpath("//a[text()='Find Contacts']/following::a")).click();

		// 7. Click on Widget of From Contact
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();

		// 8. Click on First Resulting Contact
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		List<String> window1 = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window1.get(1));
		WebElement firstCantact = driver.findElement(By.xpath("//a[@class ='linktext']"));
		firstCantact.click();

		driver.switchTo().window(window1.get(0));
		// 9. Click on Widget of To Contact
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();

		// 10. Click on Second Resulting Contact
		// Set<String> windowHandles2 = driver.getWindowHandles();
		windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		// List<String> window2 = new ArrayList<String>(windowHandles2);
		window1 = new ArrayList<String>(windowHandles);

		driver.switchTo().window(window1.get(1));
		WebElement secondCantact = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]"));
		secondCantact.click();

		driver.switchTo().window(window1.get(0));

		// 11. Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();

		// 12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		// 13. Verify the title of the page
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println("The title of the merged contact is" + title);

		// 13. Verify the title of the page

	}

}
