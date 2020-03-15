@Regression
Feature: Amazon Shopping feauture

  Background: 
    Given Launch Amazon page and validate page header

  Scenario: Provice incorrect username and validate error
    When Click on login link and provide incorrect username
    Then Validate error for incorrect username

  Scenario: Provice incorrect password and validate error
    When Click on login link and provide incorrect password
    Then Validate error for incorrect password

  Scenario: Login with valid credentials, add item and validate
    When Provide correct username/password and validate home page header
    And Search for "iphone x 64gb" and click on first product and move to product page
    And Capture product name and price and add 1 quantity to basket
    And Validate product is added into basket on product page
    And Vaidate product price and name on basket page
    And Logout and login again validate product in basket is present or not
