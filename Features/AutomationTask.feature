Feature: To test various report scenarios

  Background: User is Logged In
    Given I navigate to the login page
    When I submit username and password
      | UserName | Password    |
      | at_009   | TechGeek12! |
    When I click on Login Button

  Scenario: To create Report Template
    Given You Traverse to report template Design
    And Click on Create Button
    And On the popup fill required details
      |ReportName|StyleTemplateValue|
      |Test5001   |1                 |
    And Click on Save Button
    And In the name column enter name entered previously
      |ReportName|
      |Test5001  |
    Then Verify whether Template is present
    And Logout from the application

  Scenario: To edit Report Template
    Given You Traverse to report template Design
    And Select Template created in first Scenario
    And Click on edit template icon
    And Select Status Ready to Assign
    And Click on Save Button
    Then Vefiy whether the status is Ready to Assign
    And Logout from the application

  Scenario: To copy Report Template
    Given You Traverse to report template Design
    And Select Template created in first Scenario
    And Click on the copy template icon
    And On the popup fill unique name
      |ReportName|
      |Test500  |
    And Click on Save Button
    Then Verify whether Template Copy is present
    And Logout from the application

  Scenario: To delete Report Template
    Given You Traverse to report template Design
    And Select Template created in first Scenario
    And Select Template created in second Scenario
    And Click on Delete as well as Ok button
    Then Verify whether created templates are not present
    And Logout from the application

  Scenario: To calculate the networth
    Given You Traverse to Account Holdings
    And Select account as "acdc4ever (335)"
    Then Verify whether Current Value USD is present
    And Save the USD Value
    And Sum up the values from Contract Type Headers
    Then Verify whether Current Value USD is equal to sum
    And Logout from the application
