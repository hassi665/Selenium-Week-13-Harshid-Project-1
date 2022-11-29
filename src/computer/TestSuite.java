package computer;

import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder () throws InterruptedException {

        // 1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//div[@class='header-menu']/ul[1]/li[1]/a[1]"));
        //  1.2 Click on Desktop
        clickOnElement(By.xpath("//div[@class='listbox']/ul[1]/li[1]//ul[1]/li[1]/a[1]"));
        // 1.3 Select Sort By position "Name: Z to A"
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='products-orderby']"));

        Thread.sleep(800);
        Select select = new Select(dropDown);
        //finding element by value
        select.selectByValue("6");
        //1.4 Verify the Product will arrange in Descending order
        verifyText("Name: Z to A", By.xpath("//select[@id='products-orderby']//option[@value='6']"));
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        // 2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));

        //  2.2 Click on Desktop
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));

        // 2.3 Select Sort By position "Name: A to Z"
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='products-orderby']"));
        Thread.sleep(1000);
        Select select = new Select(dropDown);
        //finding element by value
        select.selectByValue("5");
        Thread.sleep(1500);

        // 2.4 Click on "Add To Cart"
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));

        // 2.5  Verify the Text "Build your own computer"
        verifyText("Build your own computer", By.xpath("//h1[contains(text(),'Build your own computer')]"));

        //  2.6  Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        dropDown = driver.findElement(By.xpath("//select[@id='product_attribute_1']"));
        Thread.sleep(1000);
        select = new Select(dropDown);
        //finding element by value
        select.selectByValue("1");

        // 2.7 Select "8GB [+$60.00]" using Select class.
        dropDown = driver.findElement(By.xpath("//select[@id='product_attribute_2']"));
        Thread.sleep(500);
        select = new Select(dropDown);
        //finding element by value
        select.selectByValue("5");

        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));

        //2.9 Select OS radio "Vista Premium [+$60.00]
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));

        // 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
      //  clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        Thread.sleep(2000);

        // 2.11 Verify the price "$1,475.00"
        verifyText("$1,475.00", By.xpath("//span[@id='price-value-1']"));

        // 2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.
        verifyText("The product has been added to your shopping cart", By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        clickOnElement(By.xpath("//div[@id='bar-notification']/div[1]/span[1]"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.15 Verify the message "Shopping cart"
        verifyText("Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        clearBody(By.xpath("//td[@class='quantity']/input"));
        sendTextToElement(By.xpath("//td[@class='quantity']/input"), "2");
        clickOnElement(By.id("updatecart"));

        //2.17 Verify the Total"$2,950.00"
        verifyText("$2,950.00", By.xpath("//span[@class='value-summary']//strong"));

        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        verifyText("Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));


        //2.22 Fill the all mandatory field
        Thread.sleep(2000);
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Hritik");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Roshan");
        sendTextToElement(By.id("BillingNewAddress_Email"), "h.Roshan1@gmail.com");
        selectByValue(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "233");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "1 london street");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "E1 6AN");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "07442678934");

        //2.23 Click on “CONTINUE”
        clickOnElement(By.name("save"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        Thread.sleep(2000);

        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        Thread.sleep(2000);

        //2.27 Select “Master card” From Select credit card dropdown
        selectByValue(By.xpath("//select[@id='CreditCardType']"), "MasterCard");

        //2.28 Fill all the details
        sendTextToElement(By.id("CardholderName"), "Hritik Roshan");
        sendTextToElement(By.id("CardNumber"), "5555555555554444");
        selectByValue(By.name("ExpireMonth"), "3");
        selectByValue(By.name("ExpireYear"), "2031");
        sendTextToElement(By.id("CardCode"), "111");
        Thread.sleep(2000);

        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        //2.30 Verify “Payment Method” is “Credit Card”
        verifyText("Credit Card", By.xpath("//span[contains(text(),'Credit Card')]"));
        Thread.sleep(2000);

        //2.32 Verify “Shipping Method” is “Next Day Air”
        verifyText("Next Day Air", By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));

        //2.33 Verify Total is “$2,950.00”
        verifyText("$2,950.00",By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));

        //2.34 Click on “CONFIRM”

        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        Thread.sleep(2000);

        //2.35 Verify the Text “Thank You”
        verifyText("Thank you", By.xpath("//h1[contains(text(),'Thank you')]"));

        //2.36 Verify the message “Your order has been successfully processed!”
        verifyText("Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));

        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        Thread.sleep(2000);

        //2.37 Verify the text “Welcome to our store”
        verifyText("Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]"));

    }

    @After
    public void testDown(){
        closeBrowser();
    }

}
