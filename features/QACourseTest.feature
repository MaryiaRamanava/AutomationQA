Feature: Login Testing
  Background:
    Given Set up driver

  Scenario Outline: Test of sending positive data due login

    When enter valid Email "<email>"
    And enter valid Password
    And click SignIn Button
    Then I see Profile Page "<email>"

    Examples:
      |  email |
      |  user_1@user.user|

  Scenario: Test of new user registration with valid data

    When open registration page
    And enter First Name
    And enter Last Name
    And enter Date of birth
    And enter generated  Email
    And enter valid Password
    And enter Confirm password
    And click Submit
    Then I see Profile Page with Logo

  Scenario Outline: Test of Edit personal information

    When sign in
    And open AQAPractice
    And open Select practice page
    And select country "<country>"
    And select type "<type>"
    And click search
    And choose course
    Then get right result text
    Examples:
      | country | type |
      |  Belarus| Testing|

