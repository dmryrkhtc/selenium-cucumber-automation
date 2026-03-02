Feature: Login

  Scenario: Succesful login

       Given user is on login page
       When user enters valid username and password
       Then user should see homepage