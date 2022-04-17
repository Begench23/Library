package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class BorrowingBooksPage extends BasePage{

    public BorrowingBooksPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    
    @FindBy
    public WebElement el;

    @FindBy(xpath = "//tbody/tr/td/a")
    public List <WebElement> booksBorrowedTable;

    public int numberOfBooksBorrowed(){
        return booksBorrowedTable.size();
    }
    
}
