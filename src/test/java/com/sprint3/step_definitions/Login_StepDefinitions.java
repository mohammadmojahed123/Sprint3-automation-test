package com.sprint3.step_definitions;

import com.sprint3.pages.LoginPage;
import com.sprint3.utilities.BrowserUtils;
import com.sprint3.utilities.ConfigurationReader;
import com.sprint3.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class Login_StepDefinitions {

    public LoginPage loginPage = new LoginPage();


    @Given("user is in the login page")
    public void user_is_in_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
    }
    @When("user enters valid username {string}")
    public void user_enters_valid_username(String username) {
        loginPage.inputUsername.sendKeys(username);
    }

    @When("user enters valid password {string}")
    public void user_enters_valid_password(String password) {
        loginPage.InputPassword.sendKeys(password);
    }
    @When("user click Login button")
    public void user_click_login_button() {
        loginPage.loginBtn.click();
    }
    @Then("user should successfully log in to the Dashboard")
    public void user_should_successfully_log_in_to_the_dashboard() {
        BrowserUtils.verifyTitle("Dashboard");
    }

    @And("user hit enter key from Keyboard")
    public void userHitEnterKeyFromKeyboard() {
        loginPage.InputPassword.sendKeys(Keys.ENTER);
    }


    @When("User enters an invalid username {string}")
    public void user_enters_an_invalid_username(String string) {

    }
    @When("User enters a valid password {string}")
    public void user_enters_a_valid_password(String string) {

    }
    @Then("Wrong username or password should be displayed")
    public void wrong_username_or_password_should_be_displayed() {

    }

}
