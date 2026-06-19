
Feature: Student Information Module
Background:
  Given admin is logged into the application
  

  
Scenario Outline: Search student by different values
  Given admin is on Student page
  When admin searches student by "<value>"
  Then result should be displayed

Examples:
  | value           |
  | sakshi           |
  | 90290             |
  | 2002@gmail.com |