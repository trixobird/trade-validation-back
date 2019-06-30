# Getting Started

### Swagger
The easiest way to see the endpoints is swagger. Please visit this [link](http://localhost:8080/swagger-ui.html), after you have run the application

### jUnit Test
Unfortunately there was no time for jUnit test, but there is a single integration test. You may find the input at the project's test resources.

### Things that fail
* "SPOT, FORWARD: 
   - validate the value date against the product type"
   Couldn't determine what constitutes a Product so this validation is not working
* I tried to be cute and made the validations as annotations and as generic as possible. This is not efficient, cause it uses reflection to find members. Also I don't have as much control as I would like to on the fields. I would do it programmatically if I would start over.
* Cache: The call to find all the currencies it meant to be called only once and then stay in cache. For some unknown at his moment reason the cache does not work. I have applied the workarounds mentioned [here](https://stackoverflow.com/questions/16899604/spring-cache-cacheable-not-working-while-calling-from-another-method-of-the-s), but nothing. I am probably missing something very small.
* No logs at all
* Input has no id to return in order to identify the row of the error. The index used is the order of the input rows. 