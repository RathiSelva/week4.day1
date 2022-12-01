package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	/*1.Load the URL https://www.amazon.in/
		2.search as oneplus 9 pro 
		3.Get the price of the first product
		4. Print the number of customer ratings for the first displayed product
		5. Click the first text link of the first image
		6. Take a screen shot of the product displayed
		7. Click 'Add to Cart' button
		8. Get the cart subtotal and verify if it is correct.
		9.close the browser*/

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get(" https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("oneplus 9 pro",Keys.ENTER);
		WebElement firstPhone = driver.findElement(By.xpath("//span[@class='a-price-whole']"));
		String fPPrice = firstPhone.getText();
		System.out.println(fPPrice );
		
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
		Thread.sleep(3000);
		WebElement fPrat = driver.findElement(By.xpath("//span[@class='a-declarative']//following::span[@class]"));
		String ratings = fPrat.getText();
		System.out.println("The number of customer ratings for the first displayed product is  " + ratings);
		Set<String> proList = driver.getWindowHandles();
		List<String>pro9List = new ArrayList<String>(proList);
		driver.switchTo().window(pro9List.get(1));
		driver.findElement(By.xpath("//div[@class='a-section a-spacing-none']/a[@id='bylineInfo']")).click();
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File snap = new File("./snap/firstpro.png");
		FileUtils.copyFile(source, snap);
		driver.switchTo().window(pro9List.get(0));
		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
		Thread.sleep(3000);
		proList = driver.getWindowHandles();
		pro9List = new ArrayList<String>(proList);
		driver.switchTo().window(pro9List.get(2));
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
		//System.out.println(pro9List);
		
		WebElement subTotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']"));
		String text = subTotal.getText();
		System.out.println("The Cart Total Amount is :" + text);
		String replaced = text.replace(".00", "").replace(",", "").replace("₹", "");
		System.out.println(replaced);
		int amountNum = Integer.parseInt(replaced);
		System.out.println("Int of subtotal is = " + amountNum);
		Thread.sleep(4000);
		String fPHPrice = fPPrice.replace(",", "");
		int firstPhonePrice = Integer.parseInt(fPHPrice);
		System.out.println("Int of firstphoneprice is = " + firstPhonePrice);
		if(amountNum == firstPhonePrice)
		{
			System.out.println("The cart Amount is equal to First one Price");
		}
		else
		{
			System.out.println("The cart Amount is not equal to First one Price");
		}
		
		

	}

}
