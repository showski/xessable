@someScenarios
Feature: Some scenarios

  @checkForBrokenImages
  Scenario: Broken Images
    Given the user opens the test home page
    Then user verifies images on page are not broken

  @filterResults
  Scenario Outline: Filter results
    Given the user opens the test home page
    When user selects "<activityOption>" for activity
    Then results should reflect filter selection

    Examples: 
      | activityOption |
      | test           |
      | test 2         |

  @sortBy
  Scenario Outline: Sort by
    Given the user opens the test home page
    When user selects "<sortByValue>" for result sorting
    Then results should be displayed in correct order

    Examples: 
      | sortByValue		 |
      | high to low    |
      | low to high    |

  @endToEndScenario
  Scenario Outline: E2E
    Given the user opens the test home page
    When user clicks the "I want this" button for "<itemName>"
    And selects "<numberOfAdults>" for adults
    And selects "<numberOfChildren>" for children
    And enters "<dateValue>" for date
    And clicks on "Check availability" button
    And clicks on "Select your time" button
    And chooses "<timeValue>" from list
    And clicks on "Next step" button
    And fills form using random information
    And clicks on "Go to confirmation" button
    And clicks on "Confirm booking" button
    Then user verifies valiues from previous selection

    Examples: 
      | itemName | numberOfAdults | numberOfChildren | dateValue | timeValue  |
      | test     |              2 |                0 |        23 | 11:30 a.m. |
