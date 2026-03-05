Feature: Login

  Scenario Outline: Succesful login with multiple users

       Given user is on login page
       When user enters valid "<username>" and "<password>"
       Then user should see homepage
Examples:
    | username | password |
    | error_user    |  secret_sauce  |
    | problem_user         |  secret_sauce  |
    | standard_user    | secret_sauce  |


