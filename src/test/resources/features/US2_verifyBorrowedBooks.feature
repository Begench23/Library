@US2
Feature: borrowedBooks matching
  As a librarian, I want to know the amount of borrowed books

  @singular
  Scenario: verify the amount of borrowed books
    Given I am in the homepage of the library app
      | 22 |
    When I take borrowed books number
    Then borrowed books number information must match with DB
      | 22 |

  @multiple
  Scenario Outline: verify the amount of borrowed books for all Students
    Given I am in the homepage of the library app2 <userUI>
    When I take borrowed books number
    Then borrowed books number information must match with DB2 <userDB>
    Examples:
      | userUI | userDB |
      | 1      | 1      |
      | 12     | 12     |
      | 35     | 35     |
      | 47     | 47     |
      | 56     | 55     |

