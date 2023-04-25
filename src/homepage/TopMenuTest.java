package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

/*
Project-2 com-tutorialsninja-sw-3
baseUrl: http://tutorialsninja.com/demo/index.php?
Requirement:
● Create the package homepage
1. create class "TopMenuTest"
1.1 create method with name "selectMenu" it has one parameter name "menu" of type
string
1.2 This method should click on the menu whatever name is passed as parameter.
Write the following Test:
1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
1.1 Mouse hover on “Desktops” Tab and click
1.2 call selectMenu method and pass the menu = “Show All Desktops”
1.3 Verify the text ‘Desktops’
2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
2.1 Mouse hover on “Laptops & Notebooks” Tab and click
2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
2.3 Verify the text ‘Laptops & Notebooks’
3. verifyUserShouldNavigateToComponentsPageSuccessfully()
3.1 Mouse hover on “Components” Tab and click
3.2 call selectMenu method and pass the menu = “Show All Components”
3.3 Verify the text ‘Components’
 */
public class TopMenuTest extends Utility {

    String baseUrl = " http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        clickOnElement(By.linkText(menu));
    }

    @Test
    public void verifyUserShouldNavigateToDesktopPageSuccessfully() throws InterruptedException {

        // 1.1 Mouse hover on “Desktops” Tab and click
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        actionsMethodForMouseHoverOnlyOneElement(By.xpath("//a[normalize-space()='Desktops']"));

        Thread.sleep(2000);
        selectMenu("Show AllDesktops");
        //1.3 Verify the text ‘Desktops’
        assertMethod(By.xpath("//h2[normalize-space()='Desktops']"), "Desktops");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        // 2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        actionsMethodForMouseHoverOnlyOneElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");
        //2.3 Verify the text ‘Laptops & Notebooks’
        assertMethod(By.xpath("//h2[normalize-space()='Laptops & Notebooks']"), "Laptops & Notebooks");

    }
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){

        // 3.1 Mouse hover on “Components” Tab and click
        actionsMethodForMouseHoverOnlyOneElement(By.xpath("//a[normalize-space()='Components']"));

        //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show AllComponents");

        //3.3 Verify the text ‘Components’
        assertMethod(By.xpath("//h2[normalize-space()='Components']"),"Components");


    }

    @After
    public void tearDown() {
        closeBrowser();
    }


}
