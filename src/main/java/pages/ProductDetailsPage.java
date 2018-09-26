package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.math.BigDecimal;

public class ProductDetailsPage {

    private static final String US_DOLAR_SIGN = "$";

    @FindBy(id="priceblock_ourprice")
    private WebElement lblPrice;

    @FindBy(id="quantity")
    private WebElement lstQuantityWebElement;

    @FindBy(id = "add-to-cart-button")
    private WebElement btnAddToCart;

    @FindBy(id = "productTitle")
    private WebElement productTitle;

    public ProductDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getProductName() {
        return productTitle.getText();
    }

    public BigDecimal getBuyNowPrice() {
        return new BigDecimal(lblPrice.getText().replace(US_DOLAR_SIGN,""));
    }

    public void selectQty(final Integer quantity) {
        Select quantityListSelect =  new Select(lstQuantityWebElement);
        quantityListSelect.selectByVisibleText(quantity.toString());
    }

    public void clickAddToCart() {
        btnAddToCart.click();
    }

}
