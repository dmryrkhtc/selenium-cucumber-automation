Feature: Login
Background:
  Given user is on login page

  Scenario Outline: Succesful login with multiple users
       When user enters valid "<username>" and "<password>"
       Then user should see homepage
Examples:
    | username | password |
    | performance_glitch_user|secret_sauce|
    | problem_user|secret_sauce|
    | standard_user|secret_sauce|

Scenario Outline: Unsuccessful login with invalid credentials
  When user enters invalid "<username>" and "<password>"
  Then user should see error message
  Examples:
  |username|password|
  | wrong_user1| wrong_pass1 |
  | locked_out_user|secret_sauce  |

