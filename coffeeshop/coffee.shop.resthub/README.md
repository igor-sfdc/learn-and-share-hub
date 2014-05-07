This is the same coffee project tutorial as draft three but completed using RESThub.

"RESThub is a stack based on Spring and Backbone.js designed to build HTML5 applications easily and efficiently. It provides tooling, libraries and documentation in order to build modular web applications with client-side state, stateless server and REST webservices or Websocket communication between both" -From resthub.org-

By running the RESThub archetype I was able to generate many default parts for the project and then add my custom code. 

TODO: Describe custom code changes

Applying validation

The project functions, in essence, the way it should. It saves the data that the user supplies for every coffee record into a coffee list. The pages navigate successfully.
One problem, however, exists: the user can enter null or invalid values and they will backbone.js will attempt to save them that way. This causes errors on the server-side. To be able to keep that from happening, we need to add client-side validation. 

Here is how to add the client-side validation for a RESThub backbone.js project.

First we need to navigate into the Java Coffee model and ensure it has proper constraint annotations to limit the data choices (e.g., @NotNull).

Then in the WebAppInitializer class we need to add a "resthub-validation" parameter to the setActiveProfiles() method call so that validation REST API would be enabled.

In the coffee-view.js file we need to add the 'backbone-validation' parameter in the define([...]) section to make validation API available through require.js.

To capture validation errors, let's create the error element array "errors: []" then and the code necessary to enable the backbone validation. Towards the bottom of coffee-view.js, add code that displays messages under coffee entry form.

In the coffee.js file we need to add a call that synchronizes RESThub JavaScript implementation with server-side constraints:

Resthub.Validation.synchronize(Coffee, options.errorCallback);

Once that is done, navigate to the coffee.hbs template file and add the div element needed to display the error messages "<div id="error-messages"></div>"

Now try to enter 0 into Weight field or leave Country unselected. You should see a proper error message displayed and no errors on the server-side.