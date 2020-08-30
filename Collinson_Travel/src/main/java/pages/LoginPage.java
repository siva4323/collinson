package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;

import java.util.List;

public class LoginPage extends TestBase {

    By whoweare = By.xpath("//*[@class='caret']");
    By leadership = By.xpath("//*[@class ='text-center inner-navigation']/li[2]/a");
    By founder = By.xpath("//*[@id='countrydivcontainer']/div/div/div/div/div[2]/span[2]/p");


    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnDeveloperApplyButton() {

        driver.findElement(whoweare).click();
    }

    public void rApplyButton() {

        driver.findElement(leadership).click();
    }
    public void ApplyButton() {
        System.out.println("Text is absent");
        List<WebElement> list = driver.findElements(founder);
        Assert.assertTrue("Text not found!", list.size() > 0);
    }



}