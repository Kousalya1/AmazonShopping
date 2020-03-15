package pageObjects;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import managers.PageObjectManger;
import utilities.ElementFactory;

public class HomePage {

	WebDriver driver;

	@FindBy(how = How.CSS, using = "a[aria-label='Amazon']")
	private WebElement homePageTitle;

	@FindBy(how = How.ID, using = "nav-belt")
	private WebElement homePageHeaders;

	@FindBy(how = How.ID, using = "twotabsearchtextbox")
	private WebElement search;

	@FindBy(how = How.CSS, using = "input[type='submit']")
	private WebElement searchIcon;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'a-section aok-relative s-image')]")
	private List<WebElement> searchLists;

	@FindBy(how = How.CSS, using = "span[class='a-color-base']")
	private List<WebElement> prices;

	@FindBy(how = How.ID, using = "nav-cart")
	private WebElement cartIcon;

	@FindBy(how = How.ID, using = "add-to-wishlist-button-submit")
	private WebElement addToList;

	ElementFactory elementFactory;
	PageObjectManger pageObjectManger;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		pageObjectManger = new PageObjectManger(driver);
		elementFactory = pageObjectManger.getElementFactory();
	}

	public void validateHomePageHeaders() {
		assertTrue("The page title 'Amazon' is not displayed.", homePageTitle.isDisplayed());
		assertTrue("The home page headers are not displayed.", homePageHeaders.isDisplayed());
	}

	public void searchItem(String item) {
		elementFactory.enterTextBox(search, item);
		elementFactory.elementClick(searchIcon);
	}

	public String ClickOnFirstItem() {
		String price = elementFactory.elementGetText(prices.get(0));
		elementFactory.elementClick(searchLists.get(0));
		assertTrue("The product page is not loaded.", addToList.isDisplayed());
		return price;
	}
}
