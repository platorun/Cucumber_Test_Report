Feature: Selenium Web UI Testing

  @SeleniumWebTesting @device_Chrome @author_PlatoTester1
  Scenario Outline: Chrome Online Shopping
    Given I want to purchase items online using Google Chrome
    And I login with my "<Username>" and "<Password>" credentials
    And I add "<InventoryItem>" to my cart
    And I checkout and fill in my "<FirstName>", "<LastName>", "<PostalCode>" shipping details
    When I continue and click Finish
    Then A confirmation message "<ConfirmMessage>" should be displayed on the screen

    Examples:
      | Username      | Password     | InventoryItem         | FirstName | LastName | PostalCode   | ConfirmMessage            |
      | standard_user | secret_sauce | Sauce Labs Bike Light | Johnny    | Bravo    | 90210        | Thank you for your order! |

  @SeleniumWebTesting @device_Firefox @author_PlatoTester1
  Scenario Outline: Firefox Online Shopping
    Given I want to purchase items online using Mozilla Firefox
    And I login with my "<Username>" and "<Password>" credentials
    And I add "<InventoryItem>" to my cart
    And I checkout and fill in my "<FirstName>", "<LastName>", "<PostalCode>" shipping details
    When I continue and click Finish
    Then A confirmation message "<ConfirmMessage>" should be displayed on the screen

    Examples:
      | Username      | Password     | InventoryItem           | FirstName | LastName | PostalCode   | ConfirmMessage            |
      | standard_user | secret_sauce | Sauce Labs Bike Light 1 | John      | Doe      | 62812        | Thank you for your order! |

  @SeleniumWebTesting @device_Edge @author_PlatoTester1
  Scenario Outline: Edge Online Shopping
    Given I want to purchase items online using Microsoft Edge
    And I login with my "<Username>" and "<Password>" credentials
    And I add "<InventoryItem>" to my cart
    And I checkout and fill in my "<FirstName>", "<LastName>", "<PostalCode>" shipping details
    When I continue and click Finish
    Then A confirmation message "<ConfirmMessage>" should be displayed on the screen

    Examples:
      | Username      | Password     | InventoryItem         | FirstName | LastName | PostalCode   | ConfirmMessage            |
      | standard_user | secret_sauce | Sauce Labs Bike Light | Ryzen      | Intel   | 924272       | Thank you for your order! |