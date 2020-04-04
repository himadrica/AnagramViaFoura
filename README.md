# Anagrams checkers
## Definitions of Anagram: 
a word, phrase, or name formed by rearranging the letters of another, such as cinema, formed from iceman.

# Technology used:
* It is a spring boot(2.2.6) application.
* java version 1.8
* maven
* google guava
# Assumed valid input string
* not null
* not empty
* alphanumeric with whitespace

# How to run junit test?
```
	mvn clean test
```	
# how to run integration test?
```
	mvn clean integration-test
```
# How  to run the program?

* Clone the project 
* Go the the project directory cloned in step 1
* Run the below command to execute the program
```
	mvn spring-boot:run
```
* The server will start in port 8080, you should be able to access the below url to see the home page

```
http://localhost:8080
```

* To check anagaram please use the url: http://localhost:8080/anagrams/cinema/iceman

	it will be a json response
```	
	{
		areAnagrams: true
	}
```		
* if you use this url, http://localhost:8080/anagrams/abc
  It will return all the possible anagrams of string "abc"

```
	{
		anagrams: [
			"abc",
			"acb",
			"bac",
			"bca",
			"cba",
			"cab"
		]
	}
```
	
* For invalid inputs the response will be 

```
	{
		message: "400 - Bad Request",
		details: [
			"Not a valid input string to generate anagrams"
		],
		statusCode: 400
	}
```

```	
	{
		message: "400 - Bad Request",
		details: [
			"Invalid input strings to check anagrams"
		],
		statusCode: 400
	}
```
