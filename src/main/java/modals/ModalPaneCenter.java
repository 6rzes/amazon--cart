package modals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalPaneCenter extends ModalAbstract {
    private WebDriver driver;

    @FindBy(id = "siNoCoverage-announce")
    private WebElement btnNoThanks;

    public ModalPaneCenter(WebDriver driver) {
        super(driver);
    }

    public void closeModal() {
        clickNoThanks(btnNoThanks);
    }
}