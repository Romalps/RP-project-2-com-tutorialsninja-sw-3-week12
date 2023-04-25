package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {

    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //******************  Select Methods  *******************
    public void selectByVisibleTextFromDropDown(By by, String text) {

        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        // select by visible text
        select.selectByVisibleText(text);

    }
    public void selectOptions(By by){
        WebElement dropDown = driver.findElement(by);
        Select select =new Select(dropDown);
        List<WebElement> allOptions = select.getOptions();

    }

    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        // Select by value
        select.selectByValue(value);

    }
    //**********************************   Assert method************************

    public void assertMethod(By by, String expectedMessage) {
        WebElement actualTextElement = driver.findElement(by);
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    //*******************Actions Method for Mouse Hover ******************

    public void actionMethodForMouseHover(By by1, By by2) {
        WebElement element_1 = driver.findElement(by1);
        WebElement element_2 = driver.findElement(by2);
        Actions actions = new Actions(driver);
        actions.moveToElement(element_1).moveToElement(element_2).click().build().perform();

    }
    public void actionsMethodForMouseHoverOnlyOneElement(By by){
        Actions actions=new Actions(driver);
        WebElement element= driver.findElement(by);
        actions.moveToElement(element).perform();
    }


    //*******************Alert Methods   *****************************************

    public void switchToAlert(){
        Alert alert = driver.switchTo().alert();
    }
    public String switchToAlertAndGetTextFromAlert(){
        Alert alert =driver.switchTo().alert();
        return alert.getText();
    }

    public void switchToAlertAndAcceptAlertFromAlert(){
        Alert alert= driver.switchTo().alert();
        alert.accept();
    }
    public void switchToAlertAndDismissAlertFromAlert(){
        Alert alert =driver.switchTo().alert();
        alert.dismiss();
    }
}
