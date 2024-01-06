package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyProductRemove2 {

	WebDriver driver;

	@Test
	public void RemoveProduct() {
		setupWebDriver();
		login("standard_user", "secret_sauce");
		verifyLogin();
		String productName = addProductToCart("Sauce Labs Backpack");
		removeProductFromCart(productName);
		driver.quit();
	}

	private void setupWebDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}

	private void login(String username, String password) {
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		sleep(2000);
	}

	private void verifyLogin() {
		WebElement addToCartIcon = driver.findElement(By.id("shopping_cart_container"));
		System.out.println(addToCartIcon.isDisplayed() ? "User is logged in" : "User is unable to log in");
		sleep(2000);
	}

	private String addProductToCart(String productName) {
		WebElement product = driver.findElement(By.xpath("//div[contains(text(),'" + productName + "')]"));
		String productPrice = driver
				.findElement(By.xpath("//*[@id='inventory_container']/div/div[1]/div[2]/div[2]/div")).getText();
		System.out.println("Product Name - " + product);
		System.out.println("Product Price - " + productPrice);
		driver.findElement(By.id("add-to-cart-" + productName.toLowerCase().replace(" ", "-"))).click();
		sleep(2000);
		return productName;
	}

	private void removeProductFromCart(String productName) {
		WebElement removeButton = driver.findElement(By.id("remove-" + productName.toLowerCase().replace(" ", "-")));
		System.out.println(
				removeButton.isDisplayed() ? "Product added to cart successfully" : "Product not added to cart");
		removeButton.click();
		sleep(2000);
		WebElement productRemovedMsg = driver.findElement(By.xpath("//div[contains(text(),'" + productName + "')]"));
		System.out.println(productRemovedMsg.isDisplayed() ? "Product removed from cart successfully"
				: "Product not removed from cart");
	}

	private void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
