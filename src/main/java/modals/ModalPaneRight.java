package modals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ModalPaneRight extends ModalAbstract {
    private WebDriver driver;

    @FindBy(id = "attachSiNoCoverage-announce")
    private List<WebElement> btnNoThanks;

    @FindBy(id = "attach-close_sideSheet-link")
    private WebElement btnXModal;

    public ModalPaneRight(WebDriver driver) {
        super(driver);
    }

    public void closeModal() {
        if(btnNoThanks.size()>0) {
            clickNoThanks(btnNoThanks.get(0));
        }
        clickXButton(btnXModal);
    }
}
