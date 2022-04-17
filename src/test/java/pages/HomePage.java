package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    
    @FindBy(xpath = "//h3")
    public WebElement headerOfHomepage;

    @FindBy(id = "book_categories")
    public WebElement bookcategoriesSelect;

    @FindBy(name = "tbl_books_length")
    public WebElement tblbookslengthSelect;

    @FindBy(css = "input")
    public WebElement formcontrolInput;


    @FindBy(xpath = "//a[@id='navbarDropdown']/span")
    public WebElement userName;


    public String getUsernameAsString(){

        return userName.getText() ;
    }


}
