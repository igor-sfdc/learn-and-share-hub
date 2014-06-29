
This is an example of adding Google Maps to a RESThub project
------------------------------------------------------------

Google Maps is a very interesting and useful tool to incorporate in your web application and it immediately adds value.

Many existing programs already utilize Google Maps for various purposes. However adding Google Maps to a RESThub Web Application requires some non-trivial steps.

-----------------

#### Create a RESThub project
 * Open Linux terminal and enter the following command (per http://resthub.org/):
```
mvn archetype:generate -B \
	-DarchetypeGroupId=org.resthub \
	-DarchetypeArtifactId=resthub-jpa-backbonejs-archetype \
	-DarchetypeVersion=2.1.6 \
	-DarchetypeRepository=remote \
	-DgroupId=learn-and-share-hub \
	-DartifactId=resthub-google-maps \
	-Dversion=1.0-SNAPSHOT \
	-Dpackage=resthub.google.maps.example
```	
 * or in Windows
```
mvn archetype:generate -B ^
	-DarchetypeGroupId=org.resthub ^
	-DarchetypeArtifactId=resthub-jpa-backbonejs-archetype ^
	-DarchetypeVersion=2.1.6 ^
	-DarchetypeRepository=remote ^
	-DgroupId=learn-and-share-hub ^
	-DartifactId=resthub-google-maps ^
	-Dversion=1.0-SNAPSHOT ^
	-Dpackage=resthub.google.maps.example
```
 
-----------------
#### Import your project into Eclipse using m2e plugin
 * File->Import->Existing Maven Projects->Browse for project root folder ```learn-and-share-hub/coffeeshop/coffee.shop.resthub``` and click Finish
  * Note that ```coffee.shop.resthub``` should be checked in the list of projects to import
 * At this point we are ready to begin incorporating Google Maps into our project

-----------------
#### Add [google-maps-loader.js](src/main/webapp/webapp/js/lib/google-maps-loader.js) script:
Since Google Maps implementation may take long time to load, we need to provide a special loader script as explained [here](http://stackoverflow.com/a/20472763):
```
var google_maps_loaded_def = null;

define(['jquery'],function($) {
    if(!google_maps_loaded_def) {
        google_maps_loaded_def = $.Deferred();
        window.google_maps_loaded = function() {
            google_maps_loaded_def.resolve(google.maps);
            console.log("Loaded google.maps: " + google.maps);
        };
        require(['http://maps.googleapis.com/maps/api/js?sensor=true&callback=google_maps_loaded'],function(){},function(err) {
            google_maps_loaded_def.reject();
            console.log("Failed to load google.maps");
        });
    }
    return google_maps_loaded_def.promise();
});
```
More details can be found [here](https://github.com/MattSurabian/gmaps-requirejs-example).

--------------------------------------
#### Add google-maps-loader.js to require.config libraries' paths
 * This line in [main.js](src/main/webapp/js/main.js) registers google-maps-loader.js location
  * ```googleMapsLoader: 'lib/google-maps-loader'```
  
--------------------------------------
#### Make sure that Google Maps are loaded before the rest of the application
* The default loading sequence of RESThub application starts with AppRouter in app.js
* By adding GoogleMapsLoader promise handler to [app.js](src/main/webapp/js/app.js) we can ensure that AppRouter is created after Google Maps loading is completed: 
```
define(['googleMapsLoader', 'router/app-router', 'console'], function(GoogleMapsLoader, AppRouter) {
	// See https://github.com/MattSurabian/gmaps-requirejs-example/blob/master/main.js
    GoogleMapsLoader.done(function(){
    	console.log("Finished loading Google Maps");
        new AppRouter();
    }).fail(function(){
    	console.log("Failed to load Google Maps");
    });
});
```
    
-----------------
#### Add Google Maps wrapper ```<div>``` element to view template
 * Add a ```<div>``` element with ```id="map"``` to RESThub archetype-generated template [samples.hbs](src/main/webapp/templates/samples.hbs):
  * ```<div id="map">Map Goes Here</div>```

----------------
#### Create a CSS rule for Google Maps wrapper ```<div>``` element
 * Add a new rule to [style.css](src/main/webapp/css/style.css)
```
#map {
	width: 600px;
	height: 600px;
	display: block;
	margin: auto;
}
```
 * Add a link to style.css to [index.html](src/main/webapp/index.html):
  * ``` <link rel="stylesheet" href="css/style.css">```

-----------------
#### Add Google Maps rendering code to [samples-view.js](src/main/webapp/js/view/samples-view.js)
 * Override the ```render()``` function and add ```renderMap()``` call to it:
```
        render: function() {
            var html = this.template(this);
            this.$el.html(html);   
            this.renderMap();
        }
```
 * Implement ```renderMap()``` function
  * Choose latitude, longitude, zoom values and create a new instance of the map:   
```
        renderMap: function() {
            var lat = 0;
            var lon = 0;
            var z = 1;        
            var myLatlng = new google.maps.LatLng(lat, lon);
            var mapOptions = {
                    zoom: z,
                    center: myLatlng,
                    mapTypeId: google.maps.MapTypeId.TERRAIN
            };
            var mapTargetElement = $("#map")[0];
            new google.maps.Map(mapTargetElement, mapOptions);
        }
```
 
 ----------------
#### Test your application
 * ```cd``` into your project root folder ```learn-and-share-hub/coffeeshop/coffee.shop.resthub```
 * ```mvn clean package```
 * ```mvn jetty:run```
 * When program loading finishes enter ```http://localhost:8080``` into your browser
 * You should see the page with a black banner and a map in the center
   
__We have now completed creating our fully-functional RESThub Web application with Google Maps!__
