Feature: Login

  Scenario Outline: Succesful login with multiple users

       Given user is on login page
       When user enters valid "<username>" and "<password>"
       Then user should see homepage
Examples:
    | username | password |
    | x_user    |  secret_sauce  |
    | y_user         |  secret_sauce  |
    | standard_user    | secret_sauc  |


