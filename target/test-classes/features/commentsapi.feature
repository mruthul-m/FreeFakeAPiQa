Feature: FreeFakeApi Comments API Testing

Background:
	* url 'https://freefakeapi.io'
	* configure ssl = true
	* def schema = 
	"""
		{
		"id": "#string",
		"content": "#string",
		"user": "#string",
		"post": "#string",
		"_links": "#object"
		}
		
	"""

	Scenario: GET all method Testing
    Given path '/api/comments'
    When method GET
    Then status 200
    And match each response == schema
    
  Scenario: GET a comment by id 
  	Given path '/api/comments/2'
    When method GET
    Then status 200
    And match response == schema
    
   Scenario: Create a new comment
    Given path '/api/comments'
    And request {"content": "foundation api testing", "user": 1, "post": 3}
    When method POST
    Then status 201
    And match response.content == "foundation api testing"
    And match response.user == "/api/users/1"
    And match response.post == "api/posts/3"
    
    Scenario: Delete a comment by id
    Given path '/api/comments/3'
    When method DELETE
    Then status 204


