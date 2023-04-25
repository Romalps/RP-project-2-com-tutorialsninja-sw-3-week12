package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

/*
● Create package laptopsandnotebooks
Create the class LaptopsAndNotebooksTest
Write the following test
1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
1.1 Mouse hover on Laptops & Notebooks Tab.and click
1.2 Click on “Show All Laptops & Notebooks”
1.3 Select Sort By "Price (High > Low)"
1.4 Verify the Product price will arrange in High to Low order.
2. Test name verifyThatUserPlaceOrderSuccessfully()
2.1 Mouse hover on Laptops & Notebooks Tab and click
2.2 Click on “Show All Laptops & Notebooks”
2.3 Select Sort By "Price (High > Low)"
2.4 Select Product “MacBook”
2.5 Verify the text “MacBook”
2.6 Click on ‘Add To Cart’ button
2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
2.8 Click on link “shopping cart” display into success message
2.9 Verify the text "Shopping Cart"
2.10 Verify the Product name "MacBook"
2.11 Change Quantity "2"
2.12 Click on “Update” Tab
2.13 Verify the message “Success: You have modified your shopping cart!”
2.14 Verify the Total £737.45
2.15 Click on “Checkout” button
2.16 Verify the text “Checkout”
2.17 Verify the Text “New Customer”
2.18 Click on “Guest Checkout” radio button
2.19 Click on “Continue” tab
2.20 Fill the mandatory fields
2.21 Click on “Continue” Button
2.22 Add Comments About your order into text area
2.23 Check the Terms & Conditions check box
2.24 Click on “Continue” button
2.25 Verify the message “Warning: Payment method required!”
 */
public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
        // Click on the currency and change into pound sterling
        clickOnElement(By.xpath("//i[@class='fa fa-caret-down']"));
        clickOnElement(By.xpath("//button[normalize-space()='£Pound Sterling']"));
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        // 1.1 Mouse hover on Laptops & Notebooks Tab.and click
        //1.2 Click on “Show All Laptops & Notebooks”
        actionMethodForMouseHover(By.xpath("//a[normalize-space()='Laptops & Notebooks']"), By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));

        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");

        //1.4 Verify the Product price will arrange in High to Low order.
        assertMethod(By.xpath("//div[@id='content']//div[1]//div[1]//div[2]//div[1]//p[2]"), "£1,225.00\nEx Tax:£1,225.00");

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        // 2.1 Mouse hover on Laptops & Notebooks Tab and click
        //2.2 Click on “Show All Laptops & Notebooks”
        actionMethodForMouseHover(By.xpath("//a[normalize-space()='Laptops & Notebooks']"), By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));

        //2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");

        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));

        //2.5 Verify the text “MacBook”
        assertMethod(By.xpath("//h1[normalize-space()='MacBook']"), "MacBook");

        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        assertMethod(By.xpath("//div[@class='alert alert-success alert-dismissible']"), "Success: You have added MacBook to your shopping cart!\n×");

        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[@title='Shopping Cart']//i[@class='fa fa-shopping-cart']"));

        //2.9 Verify the text "Shopping Cart"
        assertMethod(By.xpath("//h1[contains(text(),'Shopping Cart')]"), "Shopping Cart  (0.00kg)");

        //2.10 Verify the Product name "MacBook"
        assertMethod(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"), "MacBook");

        //2.11 Change Quantity "2"
        driver.findElement(By.cssSelector("input[value='1']")).clear();
        sendTextToElement(By.cssSelector("input[value='1']"), "2");

        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        assertMethod(By.xpath("//div[@class='alert alert-success alert-dismissible']"), "Success: You have modified your shopping cart!\n×");

        //2.14 Verify the Total £737.45
        assertMethod(By.xpath("//tbody//tr//td[6]"), "£737.45");
        Thread.sleep(1000);
        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));

        //2.16 Verify the text “Checkout”
        assertMethod(By.xpath("//h1[normalize-space()='Checkout']"), "Checkout");
        Thread.sleep(2000);
        //2.17 Verify the Text “New Customer”
        assertMethod(By.xpath("//h2[normalize-space()='New Customer']"), "New Customer");

        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        Thread.sleep(1000);
        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));

        //2.20 Fill the mandatory fields
        // Find First Name field element and send element
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"), "prime543");
        // Find Last Name field element and send element
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"), "Tester");
        // Find Email field element and send element
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"), "prime543tester12@gmail.com");
        // Find Telephone field element and send element
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"), "07963258712");
        // Find Address1 field element and send element
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"), "333, High Hill");
        // Find City field element and send element
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"), "Birmingham");
        // Find Postcode field element and send element
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"), "BR10 6TR");
        // Find Country field element and select element
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-country']"), "United States");
        // Find Region field element and select element
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-zone']"), "Colorado");
Thread.sleep(1000);
        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        Thread.sleep(1000);
        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"), "Make sure it's arrive on time and handle with care.");


        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        Thread.sleep(2000);
        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@name='agree']"));
        Thread.sleep(3000);
        //2.25 Verify the message “Warning: Payment method required!"
      //assertMethod(By.xpath("//div[@class='panel-body']//div[@class='alert alert-danger alert-dismissible']"), "Warning: Payment method required!\n×");

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
