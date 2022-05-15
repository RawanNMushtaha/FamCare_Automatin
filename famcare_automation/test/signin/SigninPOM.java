package signin;

import driver.WebBaseTest;
import driver.ClientDriver;
import org.openqa.selenium.WebElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author HP
 */
public class SigninPOM {

    private static final WebBaseTest baseTest = ClientDriver.base;

    public static WebElement emailAddressFiled() {
        return baseTest.getElementByName("email");
    }

    public static WebElement createNewAccountOption() {
        return ClientDriver.base.getElementByLinkText("CREATE NEW ACCOUNT");
    }

    public static WebElement passwordField() {
        return baseTest.getElementByName("password");
    }

    public static WebElement rememberMeOption() {
        return baseTest.getElementByXpath("//*[@id=\"flexCheckDefault\"]");
    }

    public static WebElement forgetPasswordOption() {
        return baseTest.getElementByLinkText("Forget Password?");
    }

    public static WebElement rememberMeText() {
        return baseTest.getElementByXpath("/html/body/div[1]/div/div/div/div[1]/div/section/form/div/div[3]/div/span");
    }

    public static WebElement loginTitle() {
        return baseTest.getElementByXpath("/html/body/div[1]/div/div/div/div[1]/div/section/label");
    }

    public static WebElement sloganText() {
        return baseTest.getElementByXpath("/html/body/div[1]/div/div/div/div[1]/div/section/p");
    }

    public static WebElement loginButton() {
//        return baseTest.getElementByCss("//*[@id=\"root\"]/div/div/div/div[1]/div/section/form/div/div[4]/button");
//        return baseTest.getElementByXpath("//button[contains(text()='LOGIN')]");
        return baseTest.getElementById("login");
    }

    public static WebElement wrongCredentialsAlert() {
        return baseTest.getElementByXpath("//*[@id=\"root\"]/div/div/div/div[1]/div/div[1]");
//        return baseTest.getElementByXpath("//div[text()='user not found']");

    }

    public static WebElement notVerifiedAlert() {
        return baseTest.getElementByXpath("//*[@id=\"root\"]/div/div/div/div[1]/div/div[1]");
//        return baseTest.getElementByXpath("//div[@role='alert']");

    }

    public static WebElement createNewAccount() {
//        return baseTest.getElementByLinkText("CREATE NEW ACCOUNT");
        return baseTest.getElementByXpath("/html/body/div[1]/div/div/div/div[1]/div/span/a");
    }

}
