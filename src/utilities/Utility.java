package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * This method will send text on element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }


// **************************** Alert Methods **********************************

    /**
     * This method will switch to alert
     */
    public void switchToAlert() {
        driver.switchTo().alert();
    }
    /**
     * This method will send text to alert
     */
    public void sendTextToAlert(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }
    /**
     * This method will use to accept to alert
     */
    public void acceptToAlert() {
        driver.switchTo().alert().accept();
    }
    /**
     * This method will use to dismiss to alert
     */
    public void dismissToAlert() {
        driver.switchTo().alert().dismiss();
    }
    /**
     * This method will use to getTExtFromAlert to alert
     */
    public void getTextFromAlert() {
        driver.switchTo().alert().getText();
    }

    public void verifyText(String text, By by){

        // find the expected message element
        String expectedMessage = text;

        // This is text from requirement
        String actualMessage = getTextFromElement(by);

        // verifying actual and expected message
        Assert.assertEquals(expectedMessage, actualMessage);

        // Print to be sure expecting write message or not
        System.out.println("Expected Message : "+ expectedMessage);

        // Print to be sure about Actual message
        System.out.println("Actual Message : " + actualMessage);

    }

    public void clearBody(By by) {
        WebElement clearText = driver.findElement(by);
        clearText.clear();
    }


    // **************************** Select class Method **********************************

    /**
     * This method will select option by visible text
     */
    public void selectByVisibleTextFromDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        //select by visibletext
        select.selectByVisibleText(text);
    }
    /**
     * This method will select the option by value
     */
    public void selectByValue(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        //select by value
        select.selectByValue(text);
    }
    /**
     * This method will select the option by index
     */
    public void selectByIndex(By by, int a){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        //select by index
        select.selectByIndex(a);
    }
    /**
     * This method will select the option by contains text
     */


    //********************** window handle ****************************
    //********************** Action class *****************************

    // mouseHoverToElement(By by), mouseHoverToElementAndClick(By by)

    public void mouseHover(By by) {
        Actions actions = new Actions(driver);

        //mouse hoovering
        WebElement element = driver.findElement(by);
        actions.moveToElement(element).build().perform();
    }

    public void mouseHoverClick(By by) {
        Actions actions = new Actions(driver);

        //mouse hoovering
        WebElement element = driver.findElement(by);
        //click on element
        actions.moveToElement(element).click().build().perform();
    }
}

