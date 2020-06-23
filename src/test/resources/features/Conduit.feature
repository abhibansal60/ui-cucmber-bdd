@conduit
Feature: Login and Post status on facebook

  Background: Common steps before every scenario in the feature
    Given user has access to the conduit application

  Scenario Outline: Validate Login and Post article on conduit
    When user logs in with "<username>" and "<password>"
    Then user posts an article about "<description>" with title as "<title>" and having content "<content>"
    And verifies that the article is posted
    Examples:
      | username | password | description | title         | content      |
      |          |          | Hello World | titlesadfasdf | adsfsadfasdf |


