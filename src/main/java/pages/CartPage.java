package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.math.BigDecimal;

public class CartPage {

    private static final String US_DOLAR_SIGN = "$";
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"activeCartViewForm\"]/div[2]/div/div[4]/div/div[1]/div/div/div[2]/ul/li[1]/span/a/span")
    private WebElement productAdded;

    @FindBy(xpath = "//*[@id=\"sc-subtotal-amount-activecart\"]/span")
    private WebElement totalPrice;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public BigDecimal getTotalPrice() {
        return new BigDecimal(totalPrice.getText().replace(US_DOLAR_SIGN, ""));
    }

    public String getProductName() {
        return productAdded.getText();
    }
}
