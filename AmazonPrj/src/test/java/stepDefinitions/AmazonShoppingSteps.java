package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.ReadPropertyFile;
import managers.PageObjectManger;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;

public class AmazonShoppingSteps {

	WebDriver driver;
	PageObjectManger pageObjectManger;
	HomePage homePage;
	LoginPage loginPage;
	ProductPage productPage;
	String productName;
	String price;

	@Before
	public void step() {
		System.setProperty(ReadPropertyFile.getChromeDriver(), ReadPropertyFile.getChromeDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(ReadPropertyFile.getAmazonUrl());
		pageObjectManger = new PageObjectManger(driver);
		homePage = pageObjectManger.getHomePage();
		loginPage = pageObjectManger.getLoginPage();
		productPage = pageObjectManger.getProductPage();
	}

	@Given("^Launch Amazon page and validate page header$")
	public void launch_Amazon_page_and_validate_page_header() throws Throwable {
		loginPage.validateHeader();
	}

	@When("^Click on login link and provide incorrect username$")
	public void click_on_login_link_and_Provide_incorrect_username_and_validate_error() throws Throwable {
		loginPage.provideIncorrectUsername(ReadPropertyFile.getIncorrectUsername());
	}

	@Then("^Validate error for incorrect username$")
	public void validate_error_for_incorrect_username() throws Throwable {
		loginPage.validateErrorForIncorrectUsername(ReadPropertyFile.getIncorrectUsernameErrorMsg());
	}

	@When("^Click on login link and provide incorrect password$")
	public void provide_incorrect_password_and_validate_error() throws Throwable {
		loginPage.provideIncorrectPassword(ReadPropertyFile.getAmazonUsername(),
				ReadPropertyFile.getIncorrectPassword());
	}

	@Then("^Validate error for incorrect password$")
	public void validate_error_for_incorrect_password() throws Throwable {
		loginPage.validateErrorForIncorrectPwd(ReadPropertyFile.getIncorrectPwdErrorMsg());
	}

	@Then("^Provide correct username/password and validate home page header$")
	public void provide_correct_username_password_and_validate_home_page_header() throws Throwable {
		loginPage.clickOnSignIn();
		loginPage.login(ReadPropertyFile.getAmazonUsername(), ReadPropertyFile.getAmazonPassword());
		homePage.validateHomePageHeaders();
	}

	@Then("^Search for \"(.*?)\" and click on first product and move to product page$")
	public void search_for_iphone_x_gb_and_click_on_first_product_and_move_to_product_page(String searchItem)
			throws Throwable {
		homePage.searchItem(searchItem);
		homePage.ClickOnFirstItem();
	}

	@Then("^Capture product name and price and add (\\d+) quantity to basket$")
	public void capture_product_name_and_price_and_add_quantity_to_basket(int arg1) throws Throwable {
		productName = productPage.captureProductName();
//		price = productPage.captureProductPrice();
		productPage.add1QtyToList();
	}

	@Then("^Validate product is added into basket on product page$")
	public void validate_product_is_added_into_basket_on_product_page() throws Throwable {
		productPage.validateProductIsAdded();
	}

	@Then("^Vaidate product price and name on basket page$")
	public void vaidate_product_price_and_name_on_basket_page() throws Throwable {
		productPage.viewListAndVerify(productName);
	}

	@Then("^Logout and login again validate product in basket is present or not$")
	public void logout_and_login_again_validate_product_in_basket_is_present_or_not() throws Throwable {
		loginPage.logout();
		loginPage.login(ReadPropertyFile.getAmazonUsername(), ReadPropertyFile.getAmazonPassword());
		productPage.viewShoppingList(productName);
	}

	@After
	public void end() {
		// driver.close();
	}
}
