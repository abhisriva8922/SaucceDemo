package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	@Test
	public void loginTestCase() {

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
		WebElement addToCartIcon = driver.findElement(By.id("shopping_cart_container"));
		if (addToCartIcon.isDisplayed()) {
			System.out.println("User is logged in");

		} else {
			System.out.println("User is unable to logged in");
		}

		driver.close();
	}

}
