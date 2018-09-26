package modals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class ModalAbstract {

    private WebDriver driver;

    public ModalAbstract(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void clickNoThanks(WebElement noThanksButton) {
        noThanksButton.click();
    }

    protected void clickXButton(WebElement xButton) {
        xButton.click();
    }

    protected abstract void closeModal();
}
