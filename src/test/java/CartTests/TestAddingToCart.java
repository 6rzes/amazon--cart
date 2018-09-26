package CartTests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modals.ModalPaneCenter;
import modals.ModalPaneRight;
import modals.ModalsManager;
import navigation.NavigationPane;
import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchResultPage;

import java.math.BigDecimal;


public class TestAddingToCart {

    private WebDriver driver;

    private BigDecimal totalPrice;
    private String productName;
    private Integer quantity;

    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private ProductDetailsPage productDetailsPage;
    private ModalsManager modalsManager;
    private CartPage cartPage;
    private NavigationPane navigationPane;

    private static final String SEARCH_PHRASE = "Best sellers in digital cameras";
    private static final Integer FIRST_RESULT_NUMBER = 0;


    @Given("^User is on home page$")
    public void open_amazon_home_page() {
        homePage = new HomePage(driver);
        homePage.goTo();
    }

    @When("^User goes to bestsellers in digital cameras$")
    public void go_to_best_sellers() {
        navigationPane = new NavigationPane(driver);
        navigationPane.enterSearchPhrease(SEARCH_PHRASE);
        navigationPane.clickOnNthResult(FIRST_RESULT_NUMBER);
    }

    @When("User opens details of {int} product")
    public void user_opens_details_of_product(int productNumber) {
        searchResultPage = new SearchResultPage(driver);
        searchResultPage.openDetailsNthProduct(productNumber-1);
    }

    @And("^Full product name is available$")
    public void get_product_name() {
        productDetailsPage = new ProductDetailsPage(driver);
        productName = productDetailsPage.getProductName();
    }

    @And("^Price is available$")
    public void get_product_price() {
        totalPrice = productDetailsPage.getBuyNowPrice();
    }

    @And("Qty of {int} is selected")
    public void select_numer_of_pieces(Integer quantity) {
        this.quantity = quantity;
        productDetailsPage.selectQty(quantity);
    }

    @And("User adds order to shopping cart")
    public void get_product_details_and_adds_pieces_to_shopping_cart() {
        productDetailsPage.clickAddToCart();
    }

    @When("^User reject further offers$")
    public void reject_offers() {
        modalsManager = new ModalsManager(driver);
        modalsManager.closeModal();
    }

    @When("^User goes to shopping cart$")
    public void go_to_shopping_cart() {
        navigationPane.goToCart();
    }

    @Then("Correct product was added to cart")
    public void correct_product_was_added_to_cart() {
        cartPage = new CartPage(driver);
        Assert.assertEquals(productName, cartPage.getProductName());
    }

    @Then("Subtotal price sum is correct")
    public void subtotal_price_sum_is_correct() {
        Assert.assertEquals(totalPrice.multiply(new BigDecimal(quantity)), cartPage.getTotalPrice());
    }

    @Before
    public void set_up() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
