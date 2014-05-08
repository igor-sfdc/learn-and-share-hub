define([ 'backbone', 'resthub', 'model/coffee', 'collection/countries', 'hbs!template/coffee-readonly'],
function (Backbone, Resthub, Coffee, Countries, coffeeReadonlyTemplate) {
    
    var CoffeeReadonlyView = Resthub.View.extend({
        
        // Define view template
        template: coffeeReadonlyTemplate,
        
        initialize: function() {

                // Initialize the model
                this.model = new Coffee({id: this.id});
                
                // Render the view when the model is retrieved from the server
                this.listenTo(this.model, 'sync', this.render);
                
                // Request un-paginated URL
                this.model.fetch({ data: { page: 'no'} });
                
        },
        render: function() {
        	var html = this.template(this);
        	this.$el.html(html);
			var country = this.model.attributes.countryFrom;
			var lat = country.latitude;
			var lon = country.longitude;
			var z = country.zoom;

			this.renderMap(lat, lon, z);
        },
		events : {
			"click .back" : "backFunction"
		},
		renderMap: function(lat, ltt, z) {
			var myLatlng = new google.maps.LatLng(lat, ltt);
			var mapOptions = {
			  zoom: z,
			  center: myLatlng,
			  mapTypeId: google.maps.MapTypeId.TERRAIN
			};
			//we are assuming there is only one element that can be found with id = map
			$("#map").each(function() {
				new google.maps.Map(this, mapOptions);
			});			
		},
		
		backFunction: function() {
			window.history.back();		
		}

    });
    return CoffeeReadonlyView;
});