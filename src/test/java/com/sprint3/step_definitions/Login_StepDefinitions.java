package com.sprint3.step_definitions;

import com.sprint3.pages.LoginPage;
import com.sprint3.utilities.BrowserUtils;
import com.sprint3.utilities.ConfigurationReader;
import com.sprint3.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.w3c.dom.Text;

import java.util.Objects;

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
    public void user_enters_an_invalid_username(String userName) {
        loginPage.inputUsername.sendKeys(userName);
    }
    @When("User enters a valid password {string}")
    public void user_enters_a_valid_password(String password) {
        loginPage.InputPassword.sendKeys(password);

    }
    @Then("Wrong username or password should be displayed")
    public void wrong_username_or_password_should_be_displayed() {


        String actualWarningText = loginPage.warningMessage.getText();
        String expectedWarningText = "Wrong username or password.";

        Assert.assertEquals(actualWarningText, expectedWarningText);


        /*try {
            String actualWarningText = loginPage.warningMessage.getText();
            String expectedWarningText = "Wrong username or password.";

            Assert.assertEquals(actualWarningText, expectedWarningText);
        }
        catch (WebDriverException e){
            System.out.println("Logged in with False username!");
        }*/

    }

    @When("User enters  a valid username {string}")
    public void user_enters_a_valid_username(String userName) {
        loginPage.inputUsername.sendKeys(userName);
    }
    @When("User enters an invalid password {string}")
    public void user_enters_an_invalid_password(String password) {
        loginPage.InputPassword.sendKeys(password);
    }


    @Then("\"Please fill out this field.\" message should be displayed if the username field is empty")
    public void please_fill_out_this_field_message_should_be_displayed_if_the_username_field_is_empty() {

        Assert.assertEquals(loginPage.inputUsername.getAttribute("validationMessage"),"Please fill out this field.");

    }

    @Then("\"Please fill out this field.\" message should be displayed if the password field is empty")
    public void please_fill_out_this_field_message_should_be_displayed_if_the_password_field_is_empty() {

        Assert.assertEquals(loginPage.InputPassword.getAttribute("validationMessage"),"Please fill out this field.");
    }

    @When("User types text {string} in password field")
    public void user_types_text_in_password_field(String string) {
        loginPage.InputPassword.sendKeys(string);
    }
    @Then("The password should be displayed in Dots form")
    public void the_password_should_be_displayed_in_dots_form() {

        if (Objects.equals(loginPage.InputPassword.getAttribute("type"), "password")){
            Assert.assertTrue(loginPage.InputPassword.isDisplayed());
        }else {
            System.out.println("The password is not in Dot Form");
        }

    }

    @When("User clicks on eye icon in password field")
    public void user_clicks_on_eye_icon_in_password_field() {
        loginPage.eyeIcon.click();
    }
    @Then("User should be able to see the password explicitly.")
    public void user_should_be_able_to_see_the_password_explicitly() {
        Assert.assertTrue(loginPage.InputPassword.isDisplayed());
    }

    @When("User can see Forgot Password? link")
    public void user_can_see_forgot_password_link()  {

        String expectedText = "Forgot password?";
        String actualText = loginPage.forgotPassword.getText();

        Assert.assertTrue(actualText.equals(expectedText));
    }

    @When("User clicks on Forgot Password? link")
    public void user_clicks_on_forgot_password_link() {
        loginPage.forgotPassword.click();
    }
    @Then("User can see Reset Password button")
    public void user_can_see_reset_password_button() {

        String expectedResetPasswordText = "Reset Password";
        String actualResetPasswordText = loginPage.resetPasswordBtn.getAttribute("value");

        Assert.assertTrue(expectedResetPasswordText.equalsIgnoreCase(actualResetPasswordText));
    }

    @When("User can see valid placeholder for username field")
    public void user_can_see_valid_placeholder_for_username_field() {

        String expectedUsernamePlaceHolder = "Username";
        String actualUsernamePlaceHolder = loginPage.inputUsername.getAttribute("placeholder");

        Assert.assertTrue(actualUsernamePlaceHolder.contains(expectedUsernamePlaceHolder));


    }
    @When("User can see valid placeholder for password field")
    public void user_can_see_valid_placeholder_for_password_field() {

        String expectedPasswordPlaceHolder = "Password";
        String actualPasswordPlaceHolder = loginPage.InputPassword.getAttribute("placeholder");

        Assert.assertTrue(actualPasswordPlaceHolder.equalsIgnoreCase(expectedPasswordPlaceHolder));
    }


}
