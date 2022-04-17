package step_defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BorrowingBooksPage;
import utils.Driver;
import utils.JdbcUtils;
import utils.LibraryUtils;

import java.sql.ResultSet;

public class US2_stepDef {

    BorrowingBooksPage borrowingBooksPage = new BorrowingBooksPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3);

    int expectedNumberBorrowedBooks;


    @Given("I am in the homepage of the library app")
    public void iAmInTheHomepageOfTheLibraryApp(int user) {
        LibraryUtils.Login(user);
    }

    @When("I take borrowed books number")
    public void iTakeBorrowedBooksNumber() {
        borrowingBooksPage.borrowingBooksAnchor.click();

        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(borrowingBooksPage.booksBorrowedTable));
            expectedNumberBorrowedBooks = borrowingBooksPage.numberOfBooksBorrowed();

        }catch (RuntimeException e) {
            expectedNumberBorrowedBooks = 0;
            System.out.println("NoBorrowedBooksException-IGNORE:)");
        }
            //borrowingBooksPage.userLogoutButton.click();
            Driver.quitDriver();

        }

    @Then("borrowed books number information must match with DB")
    public void borrowedBooksNumberInformationMustMatchWithDB(int user) {
        String forQuery = "SELECT * from users inner join book_borrow on users.id = book_borrow.user_id" +
                " where user_id = (select id from users where full_name = 'Test Student " + user + "');" ;

        JdbcUtils.connectConnection();
        ResultSet rs = JdbcUtils.assignQuery(forQuery);
        int actualNumberBorrowedBooks = JdbcUtils.getRowsNumberOfQuery(rs);

        Assert.assertEquals(expectedNumberBorrowedBooks, actualNumberBorrowedBooks, "BorrowedBooksNum Failed");


    }


    // Scenario Outline


    @Given("I am in the homepage of the library app2 {int}")
    public void iAmInTheHomepageOfTheLibraryApp2(int userUI) {

            LibraryUtils.Login(userUI);

    }
    @Then("borrowed books number information must match with DB2 {int}")
    public void borrowedBooksNumberInformationMustMatchWithDB2(int userDB) {

        String forQuery = "SELECT * from users inner join book_borrow on users.id = book_borrow.user_id" +
                " where user_id = (select id from users where full_name = 'Test Student " + userDB + "');" ;

        JdbcUtils.connectConnection();
        ResultSet rs = JdbcUtils.assignQuery(forQuery);
        int actualNumberBorrowedBooks = JdbcUtils.getRowsNumberOfQuery(rs);

        Assert.assertEquals(expectedNumberBorrowedBooks, actualNumberBorrowedBooks, "BorrowedBooksNum Failed");

    }




}
