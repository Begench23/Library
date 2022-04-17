package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

abstract public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    
    @FindBy
    public WebElement el;

    @FindBy(xpath = "//a[@href='#books']")
    public WebElement booksAnchor;

    @FindBy(xpath = "//a[@href='#borrowing-books']")
    public WebElement borrowingBooksAnchor;

    @FindBy(id = "navbarDropdown")
    public WebElement userModule;

    @FindBy(xpath = "//a [text()= 'Log Out']")
    public WebElement userLogoutButton;

    @FindBy(xpath = "//strong")
    public WebElement elementStrong;
}
