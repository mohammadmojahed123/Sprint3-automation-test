@TCLOUD-819  @login  @smoke
Feature: TryCloud app Login Features

  User Story:
  As a user, I should be able to login
  so that I can land on the dashboard page.


  Background: User is in the login page
    Given user is in the login page

  @TCLOUD-789
  Scenario Outline: User can login with valid credentials (either clicking on the "Login button" or hitting the "Enter" key from the keyboard as the last step)
    When user enters valid username "<username>"
    And user enters valid password "<password>"
    And user click Login button
    Then user should successfully log in to the Dashboard

    Examples: Valid login credentials
    |username|password|
    |Employee35|Employee123|


  @TCLOUD-790
  Scenario Outline: User can login with valid credentials (either clicking on the "Login button" or hitting the "Enter" key from the keyboard as the last step)
    When user enters valid username "<username>"
    And user enters valid password "<password>"
    And user hit enter key from Keyboard
    Then user should successfully log in to the Dashboard

    Examples: Valid login credentials
      |username|password|
      |Employee35|Employee123|


  @TCLOUD-793
  Scenario Outline: User can not login with any invalid credentials wrong user name
  -"Wrong username or password." should be displayed for invalid credentials
  -"Please fill out this field" message should be displayed if the password or username is empty

    When User enters an invalid username "<username>"
    And User enters a valid password "<password>"
    And user click Login button
    Then Wrong username or password should be displayed

    Examples: Invalid login credentials
        |username|password|
        |EEmployee35|Employee123|
        |employee35 |Employee123|
        |employeE351|Employee123|
        |EMployee35 |Employee123|
        |EMployeE35	|Employee123|
        |EMPLOYEE35 |Employee123|


  @TCLOUD-794
  Scenario Outline: User can not login with any invalid credentials wrong password
  -"Wrong username or password." should be displayed for invalid credentials
  -"Please fill out this field" message should be displayed if the password or username is empty

    When User enters  a valid username "<username>"
    And User enters an invalid password "<password>"
    And user click Login button
    Then Wrong username or password should be displayed

    Examples: Invalid login credentials
      |username|password|
      |Employee35|Employee1234|
      |Employee35 |Eemployee123|
      |Employee35|employee123|
      |Employee35 |EmployEE123|

  @TCLOUD-797
  Scenario: User can not login with any invalid credentials Username field empty
  -"Wrong username or password." should be displayed for invalid credentials
  -"Please fill out this field." message should be displayed if the password or username is empty

    When User enters  a valid username ""
    And User enters an invalid password "Employee123"
    And user click Login button
    Then "Please fill out this field." message should be displayed if the username field is empty

  @TCLOUD-798
  Scenario: User can not login with any invalid credentials Password field empty
  -"Wrong username or password." should be displayed for invalid credentials
  -"Please fill out this field." message should be displayed if the password or username field is empty

    When User enters  a valid username "Employee35"
    And User enters an invalid password ""
    And user click Login button
    Then "Please fill out this field." message should be displayed if the password field is empty

   @TCLOUD-802
   Scenario: User can see the password in a form of dots by default
     When User types text "randomText" in password field
     Then The password should be displayed in Dots form

  @TCLOUD-803
  Scenario: User can see the password explicitly if needed
    When User types text "randomText" in password field
    And User clicks on eye icon in password field
    Then User should be able to see the password explicitly.

  @TCLOUD-804
  Scenario: User can see the "Forgot password?" link on the login page
    When User can see Forgot Password? link

  @TCLOUD-805
  Scenario: User can see "Reset Password" button on the next page after clicking on forget password link
    When User clicks on Forgot Password? link
    Then User can see Reset Password button

  @TCLOUD-806
  Scenario: User can see valid placeholders on Username and Password fields
    When User can see valid placeholder for username field
    And User can see valid placeholder for password field







