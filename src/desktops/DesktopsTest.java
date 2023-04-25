package desktops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/*
● Create the package name desktops
1. Create class “DesktopsTest”
Write the following Test:
1.Test name verifyProductArrangeInAlphaBaticalOrder()
1.1 Mouse hover on Desktops Tab.and click
1.2 Click on “Show All Desktops”
1.3 Select Sort By position "Name: Z to A"
1.4 Verify the Product will arrange in Descending order.
2. Test name verifyProductAddedToShoppingCartSuccessFully()
2.1 Mouse hover on Desktops Tab. and click
2.2 Click on “Show All Desktops”
2.3 Select Sort By position "Name: A to Z"
2.4 Select product “HP LP3065”
2.5 Verify the Text "HP LP3065"
2.6 Select Delivery Date "2022-11-30"
2.7.Enter Qty "1” using Select class.
2.8 Click on “Add to Cart” button
2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
2.10 Click on link “shopping cart” display into success message
2.11 Verify the text "Shopping Cart"
2.12 Verify the Product name "HP LP3065"
2.13 Verify the Delivery Date "2022-11-30"
2.14 Verify the Model "Product21"
2.15 Verify the Todat "£74.73
 */
public class DesktopsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
        // Click on the currency and change into pound sterling
        clickOnElement(By.xpath("//i[@class='fa fa-caret-down']"));
        clickOnElement(By.xpath("//button[normalize-space()='£Pound Sterling']"));
        }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {


        // 1.1 Mouse hover on Desktops Tab.and click
        //1.2 Click on “Show All Desktops”
        actionMethodForMouseHover(By.xpath("//a[normalize-space()='Desktops']"), By.xpath("//a[normalize-space()='Show AllDesktops']"));

        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");

        //1.4 Verify the Product will arrange in Descending order
        assertMethod(By.xpath("//a[normalize-space()='Sony VAIO']"), "Sony VAIO");

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {

        // 2.1 Mouse hover on Desktops Tab. and click
        //2.2 Click on “Show All Desktops”
        actionMethodForMouseHover(By.xpath("//a[normalize-space()='Desktops']"), By.xpath("//a[normalize-space()='Show AllDesktops']"));

        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");
        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[normalize-space()='HP LP3065']"));

        //2.5 Verify the Text "HP LP3065"
        assertMethod(By.xpath("//h1[normalize-space()='HP LP3065']"), "HP LP3065");

        //2.6 Select Delivery Date "2022-11-30"
        String year = "2022";
        String month = "November";
        String date = "30";

        clickOnElement(By.xpath("//i[@class='fa fa-calendar']"));
        while (true) {
            String monthYear = driver.findElement(By.cssSelector("div[class='datepicker-days'] th[class='picker-switch']")).getText();
            //System.out.println(monthYear);// Apr 2011
            String[] a = monthYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]"));

            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='datepicker']//table//td"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }
        //2.7.Enter Qty "1” using Select class.
        driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
        sendTextToElement(By.xpath("//input[@id='input-quantity']"), "1");

        Thread.sleep(2000);
        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        assertMethod(By.xpath("//div[@class='alert alert-success alert-dismissible']"), "Success: You have added HP LP3065 to your shopping cart!\n×");
        Thread.sleep(1000);
        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[@title='Shopping Cart']//i[@class='fa fa-shopping-cart']"));
        //2.11 Verify the text "Shopping Cart"
        assertMethod(By.xpath("//h1[contains(text(),'Shopping Cart')]"), "Shopping Cart  (1.00kg)");
        //2.12 Verify the Product name "HP LP3065"
        assertMethod(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"), "HP LP3065");

        //2.13 Verify the Delivery Date "2022-11-30"
        assertMethod(By.xpath("//small[normalize-space()='Delivery Date:2022-11-30']"), "Delivery Date:2022-11-30");

        //2.14 Verify the Model "Product21"
        assertMethod(By.xpath("//td[normalize-space()='Product 21']"), "Product 21");

        //2.15 Verify the Total "£74.73
        assertMethod(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]"),"£74.73");

    }

    @After
    public void tearDown() {
           closeBrowser();
    }


}
