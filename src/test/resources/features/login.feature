@Smoke @login
Feature: TryCloud app Login Features

  User Story:
  As a user, I should be able to login
  so that I can land on the dashboard page.


  Background: User is in the login page
    Given user is in the login page

  @ValidCredentialsLoginButton
  Scenario Outline: User can login with valid credentials (either clicking on the "Login button" or hitting the "Enter" key from the keyboard as the last step)
    When user enters valid username "<username>"
    And user enters valid password "<password>"
    And user click Login button
    Then user should successfully log in to the Dashboard

    Examples: Valid login credentials
    |username|password|
    |Employee35|Employee123|

  @ValidCredentialsEnterKey
  Scenario Outline: User can login with valid credentials (either clicking on the "Login button" or hitting the "Enter" key from the keyboard as the last step)
    When user enters valid username "<username>"
    And user enters valid password "<password>"
    And user hit enter key from Keyboard
    Then user should successfully log in to the Dashboard

    Examples: Valid login credentials
      |username|password|
      |Employee35|Employee123|


  @InvalidCredentialsWrongUserName
  Scenario Outline: User can not login with any invalid credentials
  -"Wrong username or password." should be displayed for invalid credentials
  -"Please fill out this field" message should be displayed if the password or username is empty

    When User enters an invalid username "<username>"
    And User enters a valid password "<password>"
    Then Wrong username or password should be displayed

    Examples: Invalid login credentials
        |username|password|
        |EEmployee35|Employee123|
        |employee35 |Employee123|
        |employeE351|Employee123|
        |EMployee35 |Employee123|
        |EMployeE35	|Employee123|
        |EMPLOYEE35 |Employee123|



