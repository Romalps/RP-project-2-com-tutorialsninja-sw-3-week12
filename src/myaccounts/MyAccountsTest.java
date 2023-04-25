package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/*
● Create package myaccounts
1. Create the class MyAccountsTest
1.1 create method with name "selectMyAccountOptions" it has one parameter name
"option" of type string
1.2 This method should click on the options whatever name is passed as parameter.
(Hint: Handle List of Element and Select options)
Write the following test
1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
1.1 Clickr on My Account Link.
1.2 Call the method “selectMyAccountOptions” method and pass the parameter
“Register”
1.3 Verify the text “Register Account”.
2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
2.1 Clickr on My Account Link.
2.2 Call the method “selectMyAccountOptions” method and pass the parameter
“Login”
2.3 Verify the text “Returning Customer”.
3. Test name verifyThatUserRegisterAccountSuccessfully()
3.1 Clickr on My Account Link.
3.2 Call the method “selectMyAccountOptions” method and pass the parameter
“Register”
3.3 Enter First Name
3.4 Enter Last Name
3.5 Enter Email
3.6 Enter Telephone
3.7 Enter Password
3.8 Enter Password Confirm
3.9 Select Subscribe Yes radio button
3.10 Click on Privacy Policy check box
3.11 Click on Continue button
3.12 Verify the message “Your Account Has Been Created!”
3.13 Click on Continue button
3.14 Clickr on My Account Link.
3.15 Call the method “selectMyAccountOptions” method and pass the parameter
“Logout”
3.16 Verify the text “Account Logout”
3.17 Click on Continue button
4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
4.1 Clickr on My Account Link.
4.2 Call the method “selectMyAccountOptions” method and pass the parameter
“Login”
4.3 Enter Email address
4.4 Enter Last Name
4.5 Enter Password
4.6 Click on Login button
4.7 Verify text “My Account”
4.8 Clickr on My Account Link.
4.9 Call the method “selectMyAccountOptions” method and pass the parameter
“Logout”
4.10 Verify the text “Account Logout”
4.11 Click on Continue button
 */
public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
        // Click on the currency and change into pound sterling
        clickOnElement(By.xpath("//i[@class='fa fa-caret-down']"));
        clickOnElement(By.xpath("//button[normalize-space()='£Pound Sterling']"));
    }

    public void selectMyAccountOptions(String option) {
        clickOnElement(By.linkText(option));

    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {

        // 1.1 Click on My Account Link.
        clickOnElement(By.xpath("//i[@class='fa fa-user']"));

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        Thread.sleep(2000);
        //1.3 Verify the text “Register Account”.
        assertMethod(By.xpath("//h1[text()='Register Account']"), "Register Account");

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {

        // 2.1 Click on My Account Link.
        clickOnElement(By.xpath("//i[@class='fa fa-user']"));

        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        Thread.sleep(1000);
        //2.3 Verify the text “Returning Customer”.
        assertMethod(By.xpath("//h2[normalize-space()='Returning Customer']"), "Returning Customer");
    }

    @Test
    public void verifyThatUserRegisterAccountsSuccessfully() {

        // 3.1 Click on My Account Link.
        clickOnElement(By.xpath("//i[@class='fa fa-user']"));

        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");


        // 3.3 Enter First Name
        // Find First name field element and send element
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "prime111");
        //3.4 Enter Last Name
        // Find Last name field element and send element
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "tester");
        //3.5 Enter Email
        // Find Email field element and send element
        sendTextToElement(By.xpath("//input[@id='input-email']"), "prime111tester@gmail.com");
        //3.6 Enter Telephone
        // Find Telephone field element and send element
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "07123654780");
        //3.7 Enter Password
        // Find Password field element and send element
        sendTextToElement(By.xpath("//input[@id='input-password']"), "prime11Tester");
        //3.8 Enter Password Confirm
        // Find Password Confirm  field element and send element
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "prime11Tester");
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));

        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        //3.12 Verify the message “Your Account Has Been Created!”
        assertMethod(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"), "Your Account Has Been Created!");
        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//i[@class='fa fa-user']"));
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        assertMethod(By.xpath("//h1[normalize-space()='Account Logout']"), "Account Logout");
        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {

        // 4.1 Click on My Account Link.
        clickOnElement(By.xpath("//i[@class='fa fa-user']"));

        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter  “Login”
        selectMyAccountOptions("Login");

        //4.3 Enter Email address
        // Find the Email field element and send element
        sendTextToElement(By.xpath("//input[@id='input-email']"), "prime111tester@gmail.com");

        //4.5 Enter Password
        // Find the Password field element and send element
        sendTextToElement(By.xpath("//input[@id='input-password']"), "prime11Tester");
        //4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
        //4.7 Verify text “My Account”
        assertMethod(By.xpath("//h2[normalize-space()='My Account']"), "My Account");
        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//i[@class='fa fa-user']"));
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

        //4.10 Verify the text “Account Logout”
        assertMethod(By.xpath("//h1[normalize-space()='Account Logout']"), "Account Logout");
        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));


    }

    @After
    public void tearDown() {
        //closeBrowser();
    }
}
