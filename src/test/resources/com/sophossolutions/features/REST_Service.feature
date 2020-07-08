Feature: Register user through api

  Scenario: Registration user
    Given "Cloud" create a user with the post method in "https://gorest.co.in/"
    When Candidate provide information the post method with "public-api/users"
    |first_name|Cloud|
    |last_name |Strife|
    |gender    |male|
    |dob       |1935-10-28|
    |email     |Candig7ugf@mail.com|
    |status    |inactive              |
    Then Candidate verify the creation of this user with the get method


