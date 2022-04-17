@US1
Feature: As a data consumer, I want the user information
  are stored in mySql DB correctly in users table.

  Scenario: verify users has unique IDs

    Given Establish the database connection

    When Execute "select count(id) from users;" query to get total number of all IDs from users
#      |"Select * from books"|
    And Execute "select distinct count(id) from users;" query to get all unique total number IDs from users
#      |"Select * from books"|
    Then verify all users has unique ID

  Scenario: verify users table columns
    Given Establish the database connection

    When Execute "select * from users;" query to get all columns
    Then verify the below columns are listed in result:
      | id            |
      | full_name     |
      | email         |
      | password      |
      | user_group_id |
      | image         |
      | extra_data    |
      | status        |
      | is_admin      |
      | start_date    |
      | end_date      |
      | address       |