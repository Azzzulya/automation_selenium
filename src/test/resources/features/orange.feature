@orange

Feature: Website Orange HRM

  Scenario: Validate login
    Given I access Website OrangeHRM
    When I enter a username "Admin"
    And I enter a password admin123
    And I click a login button
    Then Should be presented homepage

  Scenario: validate logout
    Given I access Website OrangeHRM
    When I enter a username "Admin"
    And I enter a password admin123
    And I click a login button
    And I click a user dropdown
    And I click a logout
    Then Should be presented login page

  Scenario: Update personal detail
    Given I access Website OrangeHRM
    When I enter a username "Admin"
    And I enter a password admin123
    And I click a login button
    And I click MyInfo
    And I click personal details
    And I enter a nickname
    Then Nickname should be update

  Scenario: Update contact details
    Given  I access Website OrangeHRM
    When I enter a username "Admin"
    And I enter a password admin123
    And I click a login button
    And I click MyInfo
    And I click contact details
    And I enter a city
    Then City should be update

