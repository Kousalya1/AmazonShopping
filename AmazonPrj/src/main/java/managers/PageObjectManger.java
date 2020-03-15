package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import utilities.ElementFactory;

public class PageObjectManger {

	WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	ProductPage productPage;
	ElementFactory elementFactory;

	public PageObjectManger(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public ProductPage getProductPage() {
		return (productPage == null) ? productPage = new ProductPage(driver) : productPage;
	}

	public ElementFactory getElementFactory() {
		return (elementFactory == null) ? elementFactory = new ElementFactory(driver) : elementFactory;
	}

}
