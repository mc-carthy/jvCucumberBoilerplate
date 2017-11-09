Feature: Test the login function

Scenario: The user should be able to login with valid credentials
	Given user is on the login page
	When user enters valid credentials
	Then user sees login confirmation
	
Scenario Outline: The user should be able to login
	Given user is on the login page
	When user enters username <username>
	And user enters password <password>
	And user submits the login form
	Then user sees login confirmation
	
	Examples:
	| username 					| password 			|
	| tim@testemail.com	| trpass				|
	| ep@testemail.com	| ep1password		|
	| jv@testemail.com	| jv4password		|