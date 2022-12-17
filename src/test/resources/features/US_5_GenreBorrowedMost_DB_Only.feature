Feature: As a librarian, I want to know what genre of books is being borrowed the most
  user story genre of books is being borrowed the most popular
  Background:
    When librarian login with credentials "librarian43@library" and  "9Wa02cAu"
    Then verify the user should be at dashboard page with title "Library"

    @mostBorrowedGenre @db
  Scenario: verify the common book genre that’s being borrowed
    ## done by Hook klass --> Given Establish the database connection
    When I execute query to find most popular book genre
    Then verify "Action and Adventure" is the most popular book genre.