#college login
Feature: Login Feature
Scenario:Valid Login Test
Given:user is on home page
When user enters valid username and password
Then user should logged in successfully

Scenario: Invalid Login Test
Given user is on home page
When user enters Invalid username and password
Then error message should be displayed