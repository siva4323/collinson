package stepdefinations;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.LoginPage;
import util.TestBase;

import java.awt.*;
import java.io.IOException;

public class Loginpagesteps extends TestBase {
    LoginPage loginPage=new LoginPage();

    @Given("^Enter the url$")
    public void enter_the_url() throws IOException, AWTException {

        TestBase.initialization();
        TestBase.takeSnapShot();

    }
    @When("^Go to the required option$")
    public void go_to_the_required_option() throws Throwable {
        TestBase.implicitwait();
        TestBase.windowshandles();
        loginPage.clickOnDeveloperApplyButton();

        TestBase.scroledown();
        loginPage.rApplyButton();


    }
    @And("^Validate the page$")
    public void validate_the_page() throws Throwable {
TestBase.scroledown();
loginPage.ApplyButton();

    }

}
