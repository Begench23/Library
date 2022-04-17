package step_defs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfReader;
import utils.Driver;

public class US0_stepDef {


    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);


    @When("user enters username press tab enters password hits enter")
    public void userEntersUsernamePressTabEntersPasswordHitsEnter() {

        Driver.getDriver().get(ConfReader.getValue("env"));

        actions.moveToElement(loginPage.inputUsername).sendKeys(ConfReader.getValue("studentEmail2")).sendKeys(Keys.TAB).
                moveToElement(loginPage.inputPassword).sendKeys(ConfReader.getValue("studentPassword2")).sendKeys(Keys.ENTER).
                build().perform();

    }

    @Then("user should be on homePage and see name on Module")
    public void userShouldBeOnHomePage(String expectedUsernameInfo) {

        wait.until(ExpectedConditions.visibilityOf(homePage.userName));

        Assert.assertEquals(expectedUsernameInfo, homePage.userName.getText(), "LoginFail");

        Driver.quitDriver();
    }

}
