package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;

public class LibraryUtils {


    public static void Login(int studentNum){

        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        Actions actions = new Actions(Driver.getDriver());
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3);
        String expectedUsernameInfo = "Test Student " + studentNum;

        Driver.getDriver().get(ConfReader.getValue("env"));


            actions.moveToElement(loginPage.inputUsername).sendKeys(ConfReader.getValue("studentEmail" + studentNum)).sendKeys(Keys.TAB).
                    moveToElement(loginPage.inputPassword).sendKeys(ConfReader.getValue("studentPassword" + studentNum)).sendKeys(Keys.ENTER).
                    build().perform();

            wait.until(ExpectedConditions.visibilityOf(homePage.userName));

            Assert.assertEquals(expectedUsernameInfo, homePage.userName.getText(), "LoginFail");


        }
    }

