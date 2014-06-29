define(['googleMapsLoader', 'router/app-router', 'console'], function(GoogleMapsLoader, AppRouter) {
	// See https://github.com/MattSurabian/gmaps-requirejs-example/blob/master/main.js
    GoogleMapsLoader.done(function(){
    	console.log("Finished loading Google Maps");
        new AppRouter();
    }).fail(function(){
    	console.log("Failed to load Google Maps");
    });
});