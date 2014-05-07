define([ 'backbone', 'resthub', 'model/coffee', 'collection/countries', 'hbs!template/coffee', 'backbone-validation'],
		function (Backbone, Resthub, Coffee, Countries, coffeeTemplate) {

	var CoffeeView = Resthub.View.extend({

		// Define view template
		template: coffeeTemplate,
		
		errors: [],

		initialize: function() {       	        	
			// Initialize the model
			this.model = new Coffee({id: this.id}, {errorCallback: _.bind(this.showError)}); 
			// Enable backbone validation
			Backbone.Validation.bind(this, {
				valid: function(view, attr) {
					// Do nothing (should probably clear the previous error message if any).
				},
				invalid: function(view, attr, error) {
					view.errors.push({attribute: attr, message: error});
				}
			});
			
			// Register a function to handle validation errors
			this.model.on("invalid", this.showValidationError, this);
			
			// Start loading country collection after the model is retrieved from the server 
			this.listenTo(this.model, 'sync', this.startLoadingCountryCollection);               
			// Request un-paginated URL
			this.model.fetch({ data: { page: 'no'} });                
		},
		startLoadingCountryCollection: function() {
			// Initialize the country collection and call render when it is retrieved from the server 
			this.countryCollection = new Countries();            	
			this.listenTo(this.countryCollection, 'sync', this.render);
			this.countryCollection.fetch({ data: { page: 'no'} });
		},
		render: function() {
			var html = this.template(this);
			this.$el.html(html);
			var country = this.model.attributes.countryFrom;
			// If country is undefined use default values for lat, lon and z
			var lat = country ? country.latitude : 0;
			var lon = country ? country.longitude : 0;
			var z = country ? country.zoom : 1;

			this.renderMap(lat, lon, z);
		},
		events : {
			"click .save" : "saveCoffee",
			"click .cancel" : "cancelCoffee",
			//here we bind the country to the update when you update the country field in the form.
			'change #countryFrom' : 'updateMap'
		},
		renderMap: function(lat, lon, z) {
			var myLatlng = new google.maps.LatLng(lat, lon);
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
		updateMap: function(event) {
			var selectedCountryId = event.target.value;
			var countryModel = this.countryCollection.get(selectedCountryId);
			this.renderMap(countryModel.attributes.latitude, countryModel.attributes.longitude, countryModel.attributes.zoom);	     
		},
		showError: function (resp) {
			alert("show error: " + resp);
		},		
		showValidationError: function () {
			var errorMessage  = "";
			// Concatenate all the error messages and apply them to the target <div>
			this.errors.forEach(function(errorElement){
				errorMessage += "<div>" + errorElement.attribute + ": " + errorElement.message + "</div>";
			});
			$("#error-messages").html(errorMessage);
		},		
		saveCoffee: function() {
			console.log("coffee saved: " + $('#name').val());

			var coffeeDetailsUpdated = {
					name: $('#name').val(),
					description: $('#description').val(),
					processed: $('#processed').val(),
					countryFrom: this.countryCollection.get($('#countryFrom').val()),
					region: $('#region').val(),
					weight: $('#weight').val(),
			};
			
			// Clear potential left-over errors before validation
			this.errors = [];
			$("#error-messages").html("");
			
			var tempAppRouter = this.appRouter;
			this.model.save(coffeeDetailsUpdated, {
				success : function(modelSaved, response) {
					console.log("model successfully saved");
					tempAppRouter.navigate('#coffees', {trigger: true});
				},
				error : function(modelSaved, response) {
					console.log("error saving model");
				}
			});
			
			return false;		
		}

	});
	return CoffeeView;
});