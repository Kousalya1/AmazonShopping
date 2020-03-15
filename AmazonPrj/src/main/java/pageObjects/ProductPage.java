package pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import managers.PageObjectManger;
import utilities.ElementFactory;

public class ProductPage {

	@FindBy(how = How.ID, using = "productTitle")
	private WebElement productTitle;

	@FindBy(how = How.ID, using = "add-to-wishlist-button-submit")
	private WebElement addToList;

	@FindBy(how = How.XPATH, using = "//span[text()='Create List']")
	private WebElement createListButton;

	@FindBy(how = How.XPATH, using = "//span[@class='a-dropdown-label']")
	private WebElement qtyDropdown;

	@FindBy(how = How.ID, using = "quantity_0")
	private WebElement quantityNo1;

	@FindBy(how = How.XPATH, using = "//a[text()='View List']")
	private WebElement viewListButton;

	@FindBy(how = How.ID, using = "WLHUC_result_success")
	private WebElement itemAddedMsg;

	@FindBy(how = How.XPATH, using = "//span[text()='View Your List']")
	private WebElement viewYourList;

	@FindBy(how = How.CSS, using = "span[id='wl-list-title-2UHPUQXID3XCM']")
	private WebElement shoppingList;

	@FindBy(how = How.XPATH, using = "//a[contains(@id,'itemName')]")
	private WebElement itemName;

	@FindBy(how = How.ID, using = "nav-link-accountList")
	private WebElement accountList;

	@FindBy(how = How.XPATH, using = "//span[text()='Shopping List']")
	private WebElement yourListsShoppingList;

	@FindBy(how = How.ID, using = "add-to-cart-button")
	private WebElement addToCartButton;

	@FindBy(how = How.ID, using = "priceblock_ourprice_row")
	private WebElement price;

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Added to Cart')]")
	private WebElement addedToCart;

	@FindBy(how = How.ID, using = "nav-cart")
	private WebElement cart;

	WebDriver driver;
	ElementFactory elementFactory;
	PageObjectManger pageObjectManger;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		pageObjectManger = new PageObjectManger(driver);
		elementFactory = pageObjectManger.getElementFactory();
	}

	public String captureProductName() {
		String productName = elementFactory.elementGetText(productTitle);
		return productName;
	}

	public String captureProductPrice() {
		return elementFactory.elementGetText(price);
	}

	public void add1QtyToList() {
		elementFactory.elementClick(qtyDropdown);
		elementFactory.elementClick(quantityNo1);
		elementFactory.elementClick(addToList);
	}

	public void validateProductIsAdded() {
		if (!elementFactory.elementGetText(itemAddedMsg).equals("This item was already in Shopping List")) {
			assertTrue("Item is not added to List.",
					elementFactory.elementGetText(itemAddedMsg).equals("1 item added to Shopping List"));
		}
	}

	public void viewListAndVerify(String item) {
		elementFactory.elementClick(viewYourList);
		assertTrue("Shopping List is not 1", elementFactory.elementGetText(shoppingList).contains("Shopping List"));
		assertEquals(item, elementFactory.elementGetText(itemName));
	}

	public void viewShoppingList(String item) {
		Actions actions = new Actions(driver);
		actions.moveToElement(accountList).build().perform();
		elementFactory.elementClick(yourListsShoppingList);
		assertEquals(item, elementFactory.elementGetText(itemName));
	}

}
