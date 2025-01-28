Feature: Register User
Scenario: Reagister a user in automation Excercise portal
	Given User is logged into automation Excercise portal
	Then Verify that home page is visible successfully
	When Click on 'Signup / Login' button
  Then Verify 'New User Signup!' is visible
	When Enter name and email address
	And Click on 'Signup' button
	Then Verify 'ENTER ACCOUNT INFORMATION' is visible
	When USer eneters the mandory details
	Then Click on 'Create Account' button in SignUp page
	