//See https://github.com/MattSurabian/gmaps-requirejs-example/blob/master/libs/google-maps-loader.js
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