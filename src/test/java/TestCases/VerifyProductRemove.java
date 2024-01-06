package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyProductRemove {
	@Test
	public void RemoveProduct() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		WebElement userName = driver.findElement(By.id("user-name"));
		userName.sendKeys("standard_user");
		WebElement userPassword = driver.findElement(By.id("password"));
		userPassword.sendKeys("secret_sauce");
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement addToCartIcon = driver.findElement(By.id("shopping_cart_container"));
		if (addToCartIcon.isDisplayed()) {
			System.out.println("User is logged in ");
		} else {
			System.out.println("User is unable to logged in");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement productName1 = driver.findElement(By.xpath("//div[contains(text(),\"Sauce Labs Backpack\")]"));
		WebElement productPrice1 = driver
				.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div"));
		String productName = productName1.getText();
		String productPrice = productPrice1.getText();
		System.out.println("Product Name - " + productName);
		System.out.println("Product Price -" + productPrice);
		WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		addToCartButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement removeButtonFound = driver.findElement(By.id("remove-sauce-labs-backpack"));
		if (removeButtonFound.isDisplayed()) {
			System.out.println("Product added to cart successfully");
		} else {
			System.out.println("Product not added into the cart");
		}
		removeButtonFound.click();
		if (productName1.isDisplayed()) {
			System.out.println("Product removed from cart successfully");
		} else {
			System.out.println("Product not removed from cart");
		}
		driver.close();
	}

}
