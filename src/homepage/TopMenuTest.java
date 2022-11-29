package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    public void selectMenu(String menu) {

        switch (menu) {
            case "Computers":
                clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a[1]"));
                break;
            case "Electronics":
                clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/a[1]"));
                break;
            default:
                System.out.println("Selection not valid");
                break;
        }

    }

    @Test
    public void verifyPageNavigation() {

        selectMenu("Electronics");

        verifyText("Categories", By.xpath("//strong[contains(text(),'Categories')]"));
    }

    @After
    public void testDown(){
        closeBrowser();
    }

}
