package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully(){

        //1.1 Mouse Hover on “Electronics” Tab
      mouseHover(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));

        //1.2 Mouse Hover on “Cell phones” and click
        mouseHoverClick(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        //1.3 Verify the text “Cell phones”
        verifyText("Cell phones", By.xpath("//h1[contains(text(),'Cell phones')]"));

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHover(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));

        //2.2 Mouse Hover on “Cell phones” and click
        mouseHoverClick(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        //2.3 Verify the text “Cell phones”
        verifyText("Cell phones", By.xpath("//h1[contains(text(),'Cell phones')]"));

        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));

        //2.6 Verify the text “Nokia Lumia 1020”
        verifyText("Nokia Lumia 1020", By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));

        //2.7 Verify the price “$349.00”
        verifyText("$349.00", By.xpath("//span[@id='price-value-20']"));

        //2.8 Change quantity to 2
        clearBody(By.id("product_enteredQuantity_20"));
        sendTextToElement(By.id("product_enteredQuantity_20"), "2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.id("add-to-cart-button-20"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        verifyText("The product has been added to your shopping cart", By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        //closing green notification bar
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.12 Verify the message "Shopping cart"
        verifyText("Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]") );

        //2.13 Verify the quantity is 2
        verifyText("(2)", By.xpath("//span[contains(text(),'(2)')]"));

        //2.14 Verify the Total $698.00
        verifyText("$698.00", By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]") );

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //2.16 Click on “CHECKOUT”
        Thread.sleep(1500);
        clickOnElement(By.id("checkout"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        verifyText("Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

        //2.18 Click on “REGISTER” tab
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        //2.19 Verify the text “Register”
        verifyText("Register", By.xpath("//h1[contains(text(),'Register')]"));

        //2.20 Fill the mandatory fields
        sendTextToElement(By.id("FirstName"), "Raj");
        sendTextToElement(By.id("LastName"), "Patel");
        sendTextToElement(By.id("Email"), "Raj.patel007@gmail.com");
        sendTextToElement(By.id("Password"), "Rajpatel007");
        sendTextToElement(By.id("ConfirmPassword"), "Rajpatel007");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));
        Thread.sleep(1500);

        //2.22 Verify the message “Your registration completed”
        verifyText("Your registration completed", By.xpath("//div[contains(text(),'Your registration completed')]"));

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        Thread.sleep(2000);

        //2.24 Verify the text “Shopping card”
        verifyText("Shopping cart",By.xpath("//h1[contains(text(),'Shopping cart')]"));

        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        Thread.sleep(2000);

        //2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //2.27 Fill the Mandatory fields
        selectByValue(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"233");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "1 london street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "en1 6lo");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "06784561231");
        Thread.sleep(2000);

        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));

        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));

        //2.32 Select “Visa” From Select credit card dropdown
        selectByValue(By.id("CreditCardType"), "visa");

        //2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Akshay kumar");
        sendTextToElement(By.id("CardNumber"), "5555555555554444");
        selectByValue(By.id("ExpireMonth"), "4");
        selectByValue(By.id("ExpireYear"), "2023");
        sendTextToElement(By.id("CardCode"), "345");

        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));
        Thread.sleep(2000);

        //2.35 Verify “Payment Method” is “Credit Card”
        verifyText("Credit Card", By.xpath("//span[contains(text(),'Credit Card')]"));
        Thread.sleep(2000);

        //2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyText("2nd Day Air", By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));

        //2.37 Verify Total is “$698.00”
        verifyText("$698.00",By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));

        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        Thread.sleep(2000);

        //2.39 Verify the Text “Thank You”
        verifyText("Thank you", By.xpath("//h1[contains(text(),'Thank you')]"));

        //2.40 Verify the message “Your order has been successfully processed!”
        verifyText("Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.42 Verify the text “Welcome to our store”
        verifyText("Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]"));

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        Thread.sleep(2000);

        //2.44 Verify the URL is “https://demo.nopcommerce.com/
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://demo.nopcommerce.com/");

    }

    @After
    public void testDown(){
        closeBrowser();
    }

}
