package TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductItemTest {

	@Test
	public void ProductTest() {
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
		List<WebElement> addToCart = driver.findElements(By.xpath("//button[contains(text(),\"Add to cart\")]"));
		System.out.println("Total no. of Products - " + addToCart.size());
		// div[@id="shopping_cart_container"]/a/span

		for (int i = 0; i < addToCart.size(); i++) {
			System.out.println(i + 1);
			addToCart.get(i).click();
			System.out.println("Clicked on " + (i + 1) + "th product");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebElement cartCount = driver.findElement(By.xpath("//div[@id=\"shopping_cart_container\"]/a/span"));
			String actualCartCount = cartCount.getText();
			int actualCount = Integer.parseInt(actualCartCount);
			Assert.assertEquals(actualCount, (i + 1));
			System.out.println("Product " + (i + 1) + "th verified");

		}

		driver.close();
	}

}
