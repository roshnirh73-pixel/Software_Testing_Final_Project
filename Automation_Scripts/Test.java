package com.automationexercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	
	public static void main(String[] args){
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://automationexercise.com/#google_vignette");
		System.out.println("Application Launched");
		
		driver.findElement(By.xpath("//a[.=' Signup / Login']")).click();
		driver.findElement(By.name("email")).sendKeys("testuser2026@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Testuser@2026");
		driver.findElement(By.xpath("//button[.='Login']")).click();
		System.out.println("Login successful");
		
		driver.findElement(By.xpath("(//a[contains(@href,'products')])[1]")).click();
		driver.findElement(By.id("search_product")).sendKeys("Dress");
		driver.findElement(By.id("submit_search")).click();
		System.out.println("Product Search completed");
		
		WebElement viewproduct = driver.findElement(By.xpath("(//a[.='View Product'])[2]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", viewproduct);
		viewproduct.click();
		driver.findElement(By.xpath("//button[@type='button']")).click();
		System.out.println("Product added to cart");
		
		driver.findElement(By.linkText("View Cart")).click();
		driver.findElement(By.linkText("Proceed To Checkout")).click();
		System.out.println("Proceeded to checkout");
		
		WebElement placeorder = driver.findElement(By.linkText("Place Order"));
		js.executeScript("arguments[0].scrollIntoView(true)", placeorder);
		placeorder.click();
		System.out.println("Placed Order");
		
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		System.out.println("Logout Successful");
		driver.quit();
		
	}
	

}
