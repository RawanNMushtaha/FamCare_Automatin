package driver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Ibrahim
 */
public class WebBaseTest {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final JavascriptExecutor javascriptExecutor;

    public WebBaseTest(WebDriver driver, WebDriverWait wait, JavascriptExecutor javascriptExecutor) {
        this.driver = driver;
        this.javascriptExecutor = javascriptExecutor;
        this.wait = wait;
    }

    /**
     *
     * @param xpath
     * @return
     */
    public WebElement getElementByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    /**
     *
     * @param id
     * @return
     */
    public WebElement getElementById(String id) {
        return driver.findElement(By.id(id));
    }

    /**
     *
     * @param cssSelector
     * @return
     */
    public WebElement getElementByCss(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector));
    }

    /**
     *
     * @param linkText
     * @return
     */
    public WebElement getElementByLinkText(String linkText) {
        return driver.findElement(By.linkText(linkText));
    }

    /**
     *
     * @param className
     * @return
     */
    public WebElement getElementByClass(String className) {
        return driver.findElement(By.className(className));
    }

    /**
     *
     * @param name
     * @return
     */
    public WebElement getElementByName(String name) {
        return driver.findElement(By.name(name));
    }

    public List<WebElement> getAllElementsById(By by) {
        return driver.findElements(by);
    }

    /**
     * Scroll 150 down by java script
     */
    public void scrollDown150() {
        javascriptExecutor.executeScript("window.scrollBy(0,150)", "");
    }

    /**
     * Scroll 50 down by java script
     */
    public void scrollDown50() {
        javascriptExecutor.executeScript("window.scrollBy(0,50)", "");
    }

    /**
     * Scroll 30 down by java script
     */
    public void scrollDown30() {
        javascriptExecutor.executeScript("window.scrollBy(0,30)", "");
    }

    /**
     * Scroll by a positive value to scroll down or negative value to scroll up
     *
     * @param value
     */
    public void scrollBy(int value) {
        switch (value) {
            case 30:
                javascriptExecutor.executeScript("window.scrollBy(0,30)", "");
                break;
            case 50:
                javascriptExecutor.executeScript("window.scrollBy(0,50)", "");
                break;
            case 100:
                javascriptExecutor.executeScript("window.scrollBy(0,100)", "");
                break;
            case 150:
                javascriptExecutor.executeScript("window.scrollBy(0,150)", "");
                break;
            case -30:
                javascriptExecutor.executeScript("window.scrollBy(0,-30)", "");
                break;
            case -50:
                javascriptExecutor.executeScript("window.scrollBy(0,-50)", "");
                break;
            case -100:
                javascriptExecutor.executeScript("window.scrollBy(0,-100)", "");
                break;
            case -150:
                javascriptExecutor.executeScript("window.scrollBy(0,-150)", "");
                break;
            default:
                javascriptExecutor.executeScript("window.scrollBy(0,-500)", "");
                break;

        }

    }

    /**
     * Scroll 150 up by java script
     */
    public void scrollUp150() {
        javascriptExecutor.executeScript("window.scrollBy(0,-150)", "");
    }

    public void scrolltoElement(WebElement ScrolltoThisElement) {
        Coordinates coordinate = ((Locatable) ScrolltoThisElement)
                .getCoordinates();
        coordinate.onPage();
        coordinate.inViewPort();
    }

    public void scrollDownToElement(WebElement element) {
        while (!element.isDisplayed()) {
            scrollDown150();
        }

    }

    public void scrollUpToElement(WebElement element) {
        while (!element.isDisplayed()) {
            scrollUp150();
        }
    }
//method to highlight

    public void highlightelement(WebElement element) {
        for (int i = 0; i < 4; i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                    element, "color: yellow; border: 4px solid blue;");
            js.executeScript("arguments[0].setAttribute('style’' arguments[1]);",
                    element, "");
        }
    }

    /**
     * Click item which have onclick function
     *
     * @param id
     */
    public void clickItem(String id) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        System.out.println("id= " + id);
        switch (id) {
            case "payfort_fort":
                js.executeScript("$('input[id=payfort_fort]').click()");
                break;
            case "checkout-button":
                js.executeScript("$('input[id=checkout-button]').click()");
                js.executeScript("$('input[id=checkout-button]').click()");
                break;
            case "cod":
                js.executeScript("$('input[id=cod]').click()");
                break;

        }

    }

    /**
     *
     * @return focused element
     */
    public WebElement getFocusedElement() {
        return driver.switchTo().activeElement();
    }

    /**
     * Implicit wait
     *
     * @param numOfSeconds
     */
    public void Wait(int numOfSeconds) {
        driver.manage().timeouts().implicitlyWait(numOfSeconds, TimeUnit.SECONDS);
    }

//    /**
//     * Wait for presence of element
//     *
//     * @param locator
//     */
//    public void waitForElementToBeVisibleBy(By locator) {
//        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//    }
//
//    /**
//     * Wait for element to be click able
//     *
//     * @param locator
//     */
//    public void waitForElementToBeClickableBy(By locator) {
//        wait.until(ExpectedConditions.elementToBeClickable(locator));
//    }
//
//    /**
//     * Wait for element to be Click able
//     *
//     * @param element
//     */
//    public void waitForElementToBeClickable(WebElement element) {
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//    }
    /**
     *
     * @param element
     * @param index
     */
    public void SelectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

//    /**
//     * Wait for the element to be click able then try to click element toClick
//     * until element is shown
//     *
//     * @param toClick
//     * @param by
//     */
//    public void clickUntillVisibilityOfBy(WebElement toClick, By by) {
//        waitForElementToBeClickable(toClick);
//
//        while (driver.findElements(by).size() < 1) {
//            toClick.click();
//            Wait(10);
//        }
//    }
    public void clearText(WebElement element) {

        element.clear();
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
    }

}
