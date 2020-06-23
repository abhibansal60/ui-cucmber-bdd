@UI
Feature: Login and Post status on facebook

  Background: Common steps before every scenario in the feature
    Given user has access to the application

  Scenario Outline: Validate Login and Post status on facebook
    When user enters "<username>" and "<password>"
    Then validate user is logged in
    And post the status "<message>"
    Examples:
      | username | password | message     |
      |          |          | Hello World |


