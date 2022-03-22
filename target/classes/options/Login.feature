Feature: Website Functionality

	@Login @Regression
	Scenario Outline: Login Functionality
	Given Intitilize the browser with "chrome"
	And Navigate to "http://qaclickacademy.com" site
	And Click on Login link in home page to land on Sign in Page
	When User enters "<username>" and "<password>" and logs in
	When Verify that "<username>" is successfully reset password
	Then Close browsers
	
	
	Examples:
	|username                   |password             |
	|nonrestricteduser@qw.com   |123456               |
	|restricteduser@qw.com      |456788               |
	
	
	
	@Title @Validate @Regression
	Scenario: Validating Website Title
	Given Intitilize the browser with "chrome"
	And Navigate to "http://qaclickacademy.com" site
	When Title is Validated
	Then Close browsers
	
	@NavBar @Validate @Regression
	Scenario: Validating Website Navigation Bar
	Given Intitilize the browser with "chrome"
	And Navigate to "http://qaclickacademy.com" site
	When Navigaton Bar is Validated
	Then Close browsers
	