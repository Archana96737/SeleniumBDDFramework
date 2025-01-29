Feature: Register User

  #Scenario: Reagister a user in automation Excercise portal
  #Given User is logged into automation Excercise portal
  #Then Verify that home page is visible successfully
  #When Click on 'Signup / Login' button
  #Then Verify 'New User Signup!' is visible
  #When Enter name and email address
  #And Click on 'Signup' button
  #Then Verify 'ENTER ACCOUNT INFORMATION' is visible
  #When USer eneters the mandory details
  #And Click on 'Create Account' button in SignUp page
  Scenario: Register a user in automation Excercise portal
    Given User is logged into automation Excercise portal
    Then Verify that home page is visible successfully
    When Click on 'Signup / Login' button
    Then Verify 'New User Signup!' is visible
    When Enter name and email address details
      | name  | email                     |
      | Vivek | vivekkanara1990@gmail.com |
    And Click on 'Signup' button
    Then Verify 'ENTER ACCOUNT INFORMATION' is visible
    When USer eneters the mandory details for sign up
      | password   | days | month | year | first_name | last_name | company  | address | country | state  | city   | zipcode | mobile_number |
      | Vivek@1990 |   25 |     4 | 1990 | Vivek      | KV        | NothCorp | Alkooz  | Dubai   | Alkooz | Alkooz |  256548 |     506896156 |
    And Click on 'Create Account' button in SignUp page
    Then Verify 'Account Created!' is visible
    When Click on 'Continue' button
    Then Verify 'Logged in User' is visible
    And Click on 'Delete Account' button
    Then Verify 'Account Deleted!' is visible
 	  And  Click on 'Continue' button