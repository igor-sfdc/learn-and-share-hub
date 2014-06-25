Coffeeshop Resthub Application
==============================
##### This is the same Coffeeshop project tutorial as draft three but developed using RESThub framework
"RESThub is a stack based on Spring and Backbone.js designed to build HTML5 applications easily and efficiently. It provides tooling, libraries and documentation in order to build modular web applications with client-side state, stateless server and REST webservices or Websocket communication between both" -From resthub.org-

By running the RESThub archetype I was able to generate many default parts for the project and then add my custom code.

##### The following are changes needed to convert from the RESThub archetype template to a fully-featured web application:
 * On the Server-side:
  * Create the actual Models, Controllers, and Repositories for Coffee and Country entities
  * Add the relationship and validation rules for the models
 * On the Client-side:
  * Create Backbone.js models for Coffee and Country entities
  * Create Backbone.js views for tabs, home, new coffee, edit coffee, view coffee, coffee list, about, help, and contact us
  * Create Handlebar.js templates for the views above
  * Create tabs menu and integrate it with the Backbone.js router
  * Add client-side validation
 * Testing:
  * Implement Selenium-integration test for the primary flow
  * Implement Selenium-integration test for the validation/error handling flow

=======================
#### Creating models
 * The models provide the framework for the entity storage in the database and exchanging data between the server and the client.
 * The two models we are going to use, ```Coffee``` and ```Country```, each have their own specific fields. 
 * The coffee model has fields like id, name, description, country, region, processed, and weight, which we need to create.
 * The country model has fields like id, name, latitude, longitude, and zoom which we need to create.
 * The easiest way to create your model is to refactor/rename the RESThub archetype-generated ```Sample.java``` model class to [```Coffee.java```](https://github.com/pshmulevich/learn-and-share-hub/blob/master/coffeeshop/coffee.shop.resthub/src/main/java/coffeeshop/model/Coffee.java) and add getters/setters. 
 * The same thing can be done by copying the original ```Sample.java``` model and converting it to [```Country.java```](https://github.com/pshmulevich/learn-and-share-hub/blob/master/coffeeshop/coffee.shop.resthub/src/main/java/coffeeshop/model/Country.java)

=======================	
#### Creating Repositories
 * Repositories are generally a place where data is kept and maintained. We'll need them to persist coffee and country information.
 * Just as with the steps in models section above, start with the RESThub archetype-generated ```SampleRepository``` class and refactor/rename it to [```CoffeeRepository```](https://github.com/pshmulevich/learn-and-share-hub/blob/master/coffeeshop/coffee.shop.resthub/src/main/java/coffeeshop/repository/CoffeeRepository.java). 
 * The repository class must include a reference to the model type. Note that the generics type parameter for the ```JpaRepository``` superclass is already updated, reflecting the previous model refactoring.
 * Also note that there is no more code specific to your application besides just the model type parameter.
 
=======================
#### Creating Controllers
  * The controllers are needed to expose data models as REST services. RESThub provides a good foundation for building controllers.
  * Refactor/rename RESThub archetype-generated ```SampleController``` class to [```CoffeeController```](https://github.com/pshmulevich/learn-and-share-hub/blob/master/coffeeshop/coffee.shop.resthub/src/main/java/coffeeshop/controller/CoffeeController.java).
  * Change the string ```sample``` to ```coffee``` for both the ```@RequestMapping``` annotation and the ```@Named``` annotation.
  * The controller class must include a reference to the model type. Note that the generics type parameters for the ```RepositoryBasedRestController``` superclass are already updated, reflecting the previous model and repository refactoring.
  * The same steps can be done for [```CountryController```](https://github.com/pshmulevich/learn-and-share-hub/blob/master/coffeeshop/coffee.shop.resthub/src/main/java/coffeeshop/controller/CountryController.java).

=======================
#### Creating Backbone.js models
 * [This](http://backbonejs.org/#Model) is a good resource to use for writing models
 * Rename RESThub archetype-generated Backbone.js file ```sample.js``` to [```coffee.js```](https://github.com/pshmulevich/learn-and-share-hub/blob/master/coffeeshop/coffee.shop.resthub/src/main/webapp/js/model/coffee.js).
 * Inside of [```coffee.js```](https://github.com/pshmulevich/learn-and-share-hub/blob/master/coffeeshop/coffee.shop.resthub/src/main/webapp/js/model/coffee.js) file rename Sample model class to Coffee and add default values for coffee attributes like name, description, country, region, processed, and weight.
 * The same procedure can be done for [```country.js```](https://github.com/pshmulevich/learn-and-share-hub/blob/master/coffeeshop/coffee.shop.resthub/src/main/webapp/js/model/country.js).

=======================	
#### Creating Backbone.js views:
 * [This](http://backbonejs.org/#View) is a good resource to use when writing Backbone.js views.
 * Backbone views are used to reflect what your applications' data models look like. They are also used to listen to events and react accordingly ([tutorial](http://backbonetutorials.com/what-is-a-view/)).
 * RESThub archetype generates ```samples-view.js``` and ```about-view.js```.
 * Copy/rename provided sample files to develop our own [views](https://github.com/pshmulevich/learn-and-share-hub/tree/master/coffeeshop/coffee.shop.resthub/src/main/webapp/js/view): ```about-view.js```,  ```coffee-readonly-view.js```, ```coffees-view.js```, ```contact-view.js```, ```help-view.js```, ```home-view.js```, ```help-view.js```, ```tabs-view.js```.
 * This should be straightforward in that we need to create the functionality behind the appearance we wish to have for the these views. It will be different for each view.

=======================
#### Creating Handlebar.js templates for the views above
 * Handlebar templates provide the framework for the HTML content needed to render views.
 * RESThub creates a ```samples.hbs``` template and the ```about.hbs``` template.
 * Copy/rename provided sample files to create our own [templates](https://github.com/pshmulevich/learn-and-share-hub/tree/master/coffeeshop/coffee.shop.resthub/src/main/webapp/template): ```about.hbs```, ```coffee-readonly.hbs```, ```coffee.hbs```, ```coffees.hbs```, ```contact.hbs```, ```help.hbs```, ```home.hbs```, ```tabs.hbs```.

=======================
#### Creating tabs menu and integrating it with the Backbone.js router:
 * The router transfers the user to the page based on the URL from the tab a link they clicked on.
 * RESThub creates ```app-router.js``` Backbone.js file.
 * Simply add the new routes to be able to navigate between your various views like [so](https://github.com/pshmulevich/learn-and-share-hub/blob/master/coffeeshop/coffee.shop.resthub/src/main/webapp/js/router/app-router.js). 

=======================	
#### Adding validation
 * The project functions, in essence, the way it should. It saves the data that the user supplies for every coffee record into a coffee list. The pages navigate successfully.
 * One problem, however, exists: the user can enter null or invalid values and they will backbone.js will attempt to save them that way. This causes errors on the server-side. To be able to keep that from happening, we need to add client-side validation. 
 * Certain values in the program have expected limiters. Weight cannot be zero, the name needs to be between 4 and 32 letters long, and a country option needs to be selected.
 * Simple check-statements can be used in regards to these options and more if the need arises.
 * Here is how to add the client-side validation for a RESThub backbone.js project
  * First we need to navigate into the Java Coffee model and ensure it has proper constraint annotations to limit the data choices (e.g., @NotNull).
  * Then in the WebAppInitializer class we need to add a ```resthub-validation``` parameter to the ```setActiveProfiles()``` method call so that validation REST API would be enabled.
  * In the coffee-view.js file we need to add the ```backbone-validation``` parameter in the define([...]) section to make validation API available through ```require.js``` .
 * To capture validation errors, let's create the error element array ```errors: []``` then and the code necessary to enable the backbone validation. Towards the bottom of coffee-view.js, add code that displays messages under coffee entry form.
  * In the ```coffee.js``` file we need to add a call that synchronizes RESThub JavaScript implementation with server-side constraints:
  * ```Resthub.Validation.synchronize(Coffee, options.errorCallback);```
 * Once that is done, navigate to the coffee.hbs template file and add the div element needed to display the error messages ```<div id="error-messages"></div>```.
 * Now try to enter 0 into Weight field or leave Country unselected. we should see a proper error message displayed and no errors on the server-side.

=======================	
#### Implement Selenium-integration test for the primary flow;
 * Now that the project is set up, we need to test the flow of operations. The optimal test would be to create a new coffee element.
 * The automated test should go navigate from the home page to the new coffee page, it should find and access the edit coffee feature, and should successfully create a new coffee element and cease upon saving.
 * The critical features of this are:
  * Set up the driver
  * Quit the driver on tear down
  * Use the driver to get to the url in question (the ```edit``` page)
  * Find the condition we wish to test by id (Ex.: ```name```)
  * Edit that condition and move to the next we wish to edit
  * End and save by locating the "save" feature and use the click to activate it
  * To optimize performance, include conditional messages to catch failures
		
=======================
#### Implement Selenium-integration test for the validation/error handling flow:
 * Now that a best-case scenario has proven fruitful and demonstrates an automated test, another is needed to be able to test the validation features of the project.
 * To do this, key issues need to be triggered like a name of appropriate length, a weight above zero, and the selection of an actual country rather than left blank.
 * The same procedures apply as stated above with the exception that they are designed to intentionally trigger validation conflict.

 