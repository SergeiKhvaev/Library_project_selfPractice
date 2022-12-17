Feature: as user i should be able to login
  user story: login functionality verification

 @ui @loginAsLibrarian
  Scenario: librarian login with valid credentials
    When librarian login with credentials "librarian43@library" and  "9Wa02cAu"
    Then verify the user should be at dashboard page with title "Library"


 @ui
 Scenario Outline:
    When librarian login with credentials "<email>" and  "<password>"
    Then verify the user should be at dashboard page with title "Library"
    Examples:
      | email               | password |
      | librarian55@library | 67UQi3Ol |
      | librarian56@library | pBQnq0NN |
      | student5@library    | i1oDgf2d |
      | student6@library    | NXhpXJdC |


  @loginAsStudent
  Scenario: student login with valid credentials
    When student login with credentials "student2@library" and  "zyxa10vg"
    Then verify the user should be at dashboard page with title "Library"