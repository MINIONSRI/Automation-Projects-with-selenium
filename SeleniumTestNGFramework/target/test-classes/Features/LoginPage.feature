Feature: Test the SauceDemo user login
  @sanity @TC001
  Scenario: Register using valid details to login the Website
    Given user navigates to Register Page
    When Verify the RegisterPage Title
    Then Enter Valid details

  @sanity @TC002
  Scenario: Login using valid username and password
    Given Verify the Loginpage title
    Then User logged into the application


  @sanity @TC003
  Scenario: Validate Home Page Features
    Given user should see the correct title
    When user check All Link and Button
    Then Verify password change functionality

  @sanity @TC004
  Scenario: Validate Desktop Page
    Given user navigates to Desktop Page
    When Verify the DesktopPage Title
    Then Verify desktop items are displayed
    And user Add item to AddtoCard and WishList

  @sanity @TC005
  Scenario: Validate Shopping Page
    Given user navigates to Shopping Page
    When Verify the ShoppingPage Title
    Then user can update cart
    And user can check delivery cost

  @sanity @TC006
  Scenario: Validate Address Book Page
    Given user navigates to Address Book Page
    When Verify the AddressBookPage Title
    Then Check All Button is Enable
    And user can set edit details

  @sanity @TC007
  Scenario Outline: Login using multiple  username and password
    Given User Enter the username "<username>" and password "<password>"
    Then Verify the homepage title
    Examples:
      | username             | password     |
      | onepiece@gmail.com   | aceluffy     |
      |rock65@gmail.com      |wwebrocklesnar|
#      | Testcase@gmail.com   | smoke@21     |

  @sanity @regression @endFlow
  Scenario: Register, Login, and Validate All Major Features
    Given user navigates to Register Page
    When Verify the RegisterPage Title
    Then Enter Valid details

    Given Verify the Loginpage title
    Then User logged into the application

    Then Verify password change functionality

    And user Add item to AddtoCard and WishList

    When Verify the ShoppingPage Title
    Then user can update cart
    And user can check delivery cost

    Given user navigates to Address Book Page
    When Verify the AddressBookPage Title
    Then Check All Button is Enable
    And user can set edit details
