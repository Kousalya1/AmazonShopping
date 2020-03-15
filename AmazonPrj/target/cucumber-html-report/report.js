$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AmazonShopping.feature");
formatter.feature({
  "line": 2,
  "name": "Amazon Shopping feauture",
  "description": "",
  "id": "amazon-shopping-feauture",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Regression"
    }
  ]
});
formatter.before({
  "duration": 23745828400,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Launch Amazon page and validate page header",
  "keyword": "Given "
});
formatter.match({
  "location": "AmazonShoppingSteps.launch_Amazon_page_and_validate_page_header()"
});
formatter.result({
  "duration": 2445866600,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Provice incorrect username and validate error",
  "description": "",
  "id": "amazon-shopping-feauture;provice-incorrect-username-and-validate-error",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "Click on login link and provide incorrect username",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Validate error for incorrect username",
  "keyword": "Then "
});
formatter.match({
  "location": "AmazonShoppingSteps.click_on_login_link_and_Provide_incorrect_username_and_validate_error()"
});
formatter.result({
  "duration": 5549006900,
  "status": "passed"
});
formatter.match({
  "location": "AmazonShoppingSteps.validate_error_for_incorrect_username()"
});
formatter.result({
  "duration": 252923700,
  "status": "passed"
});
formatter.after({
  "duration": 24700,
  "status": "passed"
});
formatter.before({
  "duration": 22889267000,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Launch Amazon page and validate page header",
  "keyword": "Given "
});
formatter.match({
  "location": "AmazonShoppingSteps.launch_Amazon_page_and_validate_page_header()"
});
formatter.result({
  "duration": 675234100,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "Provice incorrect password and validate error",
  "description": "",
  "id": "amazon-shopping-feauture;provice-incorrect-password-and-validate-error",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "Click on login link and provide incorrect password",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Validate error for incorrect password",
  "keyword": "Then "
});
formatter.match({
  "location": "AmazonShoppingSteps.provide_incorrect_password_and_validate_error()"
});
formatter.result({
  "duration": 14141734100,
  "status": "passed"
});
formatter.match({
  "location": "AmazonShoppingSteps.validate_error_for_incorrect_password()"
});
formatter.result({
  "duration": 579099800,
  "status": "passed"
});
formatter.after({
  "duration": 15700,
  "status": "passed"
});
formatter.before({
  "duration": 27790293600,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "Launch Amazon page and validate page header",
  "keyword": "Given "
});
formatter.match({
  "location": "AmazonShoppingSteps.launch_Amazon_page_and_validate_page_header()"
});
formatter.result({
  "duration": 1679135200,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Login with valid credentials, add item and validate",
  "description": "",
  "id": "amazon-shopping-feauture;login-with-valid-credentials,-add-item-and-validate",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "Provide correct username/password and validate home page header",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "Search for \"iphone x 64gb\" and click on first product and move to product page",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "Capture product name and price and add 1 quantity to basket",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "Validate product is added into basket on product page",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "Vaidate product price and name on basket page",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "Logout and login again validate product in basket is present or not",
  "keyword": "And "
});
formatter.match({
  "location": "AmazonShoppingSteps.provide_correct_username_password_and_validate_home_page_header()"
});
formatter.result({
  "duration": 15324299800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "iphone x 64gb",
      "offset": 12
    }
  ],
  "location": "AmazonShoppingSteps.search_for_iphone_x_gb_and_click_on_first_product_and_move_to_product_page(String)"
});
formatter.result({
  "duration": 14930537000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 39
    }
  ],
  "location": "AmazonShoppingSteps.capture_product_name_and_price_and_add_quantity_to_basket(int)"
});
formatter.result({
  "duration": 13367845100,
  "status": "passed"
});
formatter.match({
  "location": "AmazonShoppingSteps.validate_product_is_added_into_basket_on_product_page()"
});
formatter.result({
  "duration": 2353912900,
  "status": "passed"
});
formatter.match({
  "location": "AmazonShoppingSteps.vaidate_product_price_and_name_on_basket_page()"
});
formatter.result({
  "duration": 6760248600,
  "status": "passed"
});
formatter.match({
  "location": "AmazonShoppingSteps.logout_and_login_again_validate_product_in_basket_is_present_or_not()"
});
formatter.result({
  "duration": 43208197800,
  "status": "passed"
});
formatter.after({
  "duration": 20300,
  "status": "passed"
});
});