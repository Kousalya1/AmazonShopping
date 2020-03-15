package pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import managers.PageObjectManger;
import utilities.ElementFactory;

public class LoginPage {

	@FindBy(how = How.XPATH, using = "//span[text()='Hello, Sign in']")
	private WebElement signIn;

	@FindBy(how = How.CSS, using = "input[name='email']")
	private WebElement email;

	@FindBy(how = How.CSS, using = "input[type='submit']")
	private WebElement continueButton;

	@FindBy(how = How.ID, using = "nav-item-signout")
	private WebElement signOut;

	@FindBy(how = How.ID, using = "nav-link-accountList")
	private WebElement accountList;

	@FindBy(how = How.CSS, using = "input[id='ap_password']")
	private WebElement password;

	@FindBy(how = How.XPATH, using = "//div[@class='a-alert-content']//li//span")
	private WebElement errorMsgIncorrectInput;

	@FindBy(how = How.ID, using = "signInSubmit")
	private WebElement signInSubmit;

	@FindBy(how = How.CSS, using = "a[aria-label='Amazon']")
	private WebElement title;

	@FindBy(how = How.CSS, using = "div[id='navbar']")
	private WebElement headers;

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Sign-In')]")
	private WebElement signInLabel;

	WebDriver driver;
	ElementFactory elementFactory;
	PageObjectManger pageObjectManger;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		pageObjectManger = new PageObjectManger(driver);
		elementFactory = pageObjectManger.getElementFactory();
	}

	public void validateHeader() {
		assertTrue("The page title 'Amazon' is not displayed.", title.isDisplayed());
		assertTrue("The Login page headers are not displayed.", headers.isDisplayed());
	}

	public void provideIncorrectUsername(String incorrectUN) {
		elementFactory.elementClick(signIn);
		elementFactory.enterTextBox(email, incorrectUN);
		elementFactory.elementClick(continueButton);
	}

	public void validateErrorForIncorrectUsername(String errorMsgIncorrectUN) {
		assertTrue("Error message for incorrect Username does not contain the expected string: " + errorMsgIncorrectUN,
				elementFactory.elementGetText(errorMsgIncorrectInput).contains(errorMsgIncorrectUN));
	}

	public void provideIncorrectPassword(String username, String incorrectPW) {
		elementFactory.elementClick(signIn);
		elementFactory.enterTextBox(email, username);
		elementFactory.elementClick(continueButton);
		elementFactory.enterTextBox(password, incorrectPW);
		elementFactory.elementClick(signInSubmit);
	}

	public void validateErrorForIncorrectPwd(String errorMsgIncorrectPW) {
		assertTrue("Error message for incorrect password does not contain the expected string: " + errorMsgIncorrectPW,
				elementFactory.elementGetText(errorMsgIncorrectInput).contains(errorMsgIncorrectPW));
	}

	public void clickOnSignIn() {
		elementFactory.elementClick(signIn);
	}

	public void login(String username, String passwd) {
		elementFactory.enterTextBox(email, username);
		elementFactory.elementClick(continueButton);
		elementFactory.enterTextBox(password, passwd);
		elementFactory.elementClick(signInSubmit);
	}

	public void logout() {
		elementFactory.elementClick(accountList);
		elementFactory.elementClick(signOut);
		assertTrue("Application is not logged out.", signInLabel.isDisplayed());
	}

}
