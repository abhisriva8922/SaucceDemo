package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifySingleProduct {
	@Test
	public void PurchaseProduct() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		WebElement usernameTextBox = driver.findElement(By.id("user-name"));
		usernameTextBox.sendKeys("standard_user");
		WebElement passwordTextBox = driver.findElement(By.id("password"));
		passwordTextBox.sendKeys("secret_sauce");
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// *[@id="item_4_title_link"]/div
		// *[@id="inventory_container"]/div/div[1]/div[2]/div[2]/div
		WebElement productName1 = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
		WebElement productPrice1 = driver
				.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div"));
		String productName = productName1.getText();
		String productPrice = productPrice1.getText();
		WebElement addToCartElement = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		addToCartElement.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Product name - " + productName);
		System.out.println("Product Price - " + productPrice);
		WebElement cartIconElement = driver.findElement(By.xpath("//div[@id=\"shopping_cart_container\"]"));
		cartIconElement.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// *[@id="item_4_title_link"]/div
		// *[@id="cart_contents_container"]/div/div[1]/div[3]/div[2]/div[2]/div
		WebElement productName2 = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
		WebElement productPrice2 = driver
				.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div"));
		String productNameBeforeCheckout = productName2.getText();
		String productPriceBeforeCheckout = productPrice2.getText();

		System.out.println("Product name - " + productNameBeforeCheckout);
		System.out.println("Product Price - " + productPriceBeforeCheckout);
		Assert.assertEquals(productName, productNameBeforeCheckout, "Product name is different");
		Assert.assertEquals(productPrice, productPriceBeforeCheckout, "Product price is different");
		
		WebElement checkoutButton = driver.findElement(By.id("checkout"));
		checkoutButton.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement firstNameTextBoxLocator = driver.findElement(By.id("first-name"));
		firstNameTextBoxLocator.sendKeys("Abhishek");
		WebElement lastNameTextBoxLocator = driver.findElement(By.id("last-name"));
		lastNameTextBoxLocator.sendKeys("Srivastava");
		WebElement postalCodeTextBoxLocator = driver.findElement(By.id("postal-code"));
		postalCodeTextBoxLocator.sendKeys("226026");
		WebElement continueButtonTextBoxLocator = driver.findElement(By.id("continue"));
		continueButtonTextBoxLocator.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement finishButton = driver.findElement(By.id("finish"));
		finishButton.click();
		WebElement backhomeButton = driver.findElement(By.id("back-to-products"));
		if (backhomeButton.isDisplayed()) {
			System.out.println("Thank you for your order!");
		} else {
			System.out.println("User is unable to finished");
		}
		backhomeButton.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
}
