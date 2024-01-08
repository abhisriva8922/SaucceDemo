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

	@Test
	public void loginWithWrongUsername() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}

		WebElement usernameTextBox = driver.findElement(By.id("user-name"));
		usernameTextBox.sendKeys("incorrect_user");
		WebElement passwordTextBox = driver.findElement(By.id("password"));
		passwordTextBox.sendKeys("secret_sauce");
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		WebElement errorMessage = driver
				.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
		if (errorMessage.isDisplayed()) {
			System.out.println("Login failed with incorrect username. Error message: " + errorMessage.getText());
		} else {
			System.out.println("Unexpected behavior. Error message not displayed for incorrect username.");
		}

		driver.close();
	}

	@Test
	public void loginWithWrongPassword() {

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
		passwordTextBox.sendKeys("incorrect_password");
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		WebElement errorMessage = driver
				.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
		if (errorMessage.isDisplayed()) {
			System.out.println("Login failed with incorrect password. Error message: " + errorMessage.getText());
		} else {
			System.out.println("Unexpected behavior. Error message not displayed for incorrect password.");
		}

		driver.quit();
	}

	@Test
	public void loginWithWrongCredentials() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}

		WebElement usernameTextBox = driver.findElement(By.id("user-name"));
		usernameTextBox.sendKeys("incorrect_user");
		WebElement passwordTextBox = driver.findElement(By.id("password"));
		passwordTextBox.sendKeys("incorrect_password");
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		WebElement errorMessage = driver
				.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
		if (errorMessage.isDisplayed()) {
			System.out.println("Login failed with incorrect credentials. Error message: " + errorMessage.getText());
		} else {
			System.out.println("Unexpected behavior. Error message not displayed for incorrect credentials.");
		}

		driver.close();
	}

}
