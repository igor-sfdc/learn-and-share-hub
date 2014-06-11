Selenium Automation Example
===========================

__This is a simple Selenium test automation example project. Below are the steps needed to create the project__

###### Create a new Maven project
###### Assemble your pom.xml file
###### Add the following dependencies:
 * ```junit```
 * ```selenium-java```
 * ```operadriver```
 * ```slf4j``` (if you want to use logging)
 * ```logback-classic``` (if you want to use logging)

###### Assemble your pom.xml file
 * ```maven-compiler-plugin```
 * ```maven-resources-plugin```
 * ```jetty-maven-plugin```

###### Now create a simple index.html containing a div with an id="hello"
###### Go into src/test/java and create a new class
 * In that class we need a simple junit test that:
  * Creates an instance of `WebDriver`
  * Loads the `http://localhost:8080/index.html` page
  * Finds div element by id
  * Asserts text in that element   

