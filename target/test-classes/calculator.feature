Feature: Calculator to addition of two number
  I want to use this template for calculator feature file

  Scenario: Addition of two numbers
    When Two numbers 2 and 3
    Then Result of addtion with status code 200
    
	Scenario Outline:  wants to add two numbers
    When two numbers are <number1> and <number2>
    Then Result with Status code 200
 
    Examples:
      | number1 | number2 | 
      | 2       | 3       | 
      | 4       | 6       | 
      | 7       | 8       | 