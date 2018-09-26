package modals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ModalsManager {
    private static final int TIME_OUT_IN_SECONDS = 5;
    private WebDriver driver;
    private static final String CART_TITLE = "Amazon.com Shopping Cart";
    private ModalAbstract modalPane;

    @FindBy(id = "attach-desktop-sideSheet")
    private List<WebElement> attachModalPaneRight;

    @FindBy(className = "a-popover-inner")
    private List<WebElement> attachModalPaneCenter;


    public ModalsManager(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIME_OUT_IN_SECONDS), this);
    }

    public void closeModal() {
        if (!driver.getTitle().equals(CART_TITLE)) {
            if (attachModalPaneRight.size() > 0) {
                modalPane = new ModalPaneRight(driver);
                modalPane.closeModal();
            }
            if (attachModalPaneCenter.size() > 0) {
                modalPane = new ModalPaneCenter(driver);
                modalPane.closeModal();
            }
        }
    }
}
