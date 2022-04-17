@US0
Feature: User uses login credentials of student2 user

  Scenario: user login with valid credentials

    When user enters username press tab enters password hits enter
    Then user should be on homePage and see name on Module
    |Test Student 2|

