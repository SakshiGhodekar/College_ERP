Feature: Login Feature

Scenario: Invalid Login Test
Given user is on home page
When user enters Invalid username and password
Then error message should be displayed

Scenario: Login with wrong username and correct password
Given user is on home page
When user enters wrong username and correct password
Then error message should be displayed

Scenario: Valid Login Test
Given user is on home page
When user enters valid username and password
Then user should logged in successfully