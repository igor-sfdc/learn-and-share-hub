define(['backbone', 'resthub'], function(Backbone, Resthub) {
	var Coffee = Backbone.Model.extend({

		// Class name is a fully-qualified java class name for coffee model
		// For more details see https://github.com/bmeurant/resthub-validation-sample/blob/master/src/main/webapp/js/model/user.js
		className: "coffeeshop.model.Coffee",
		messages: {
			// Optional message overrides
			// 'validation.NotNull.message': 'the field should not be null'
		},
		initialize: function(attributes, options) {
			// Capture current value of "this" to pass it into the function
			var _this = this;
			Resthub.Validation.synchronize(Coffee, function(response) {
				alert("Error when trying to synchronize with server-side validation API."
						+ "\n\nStatus: " + response.statusText
						+ "\nModel class: " + _this.className);
			});
		},		
		defaults: {
			name: "name",
			description: "description",
			country: "country",
			region: "region",
			processed: "processed",
			weight: 1
		},
		url: function() {
			var idSuffix = this.id ? "/" + this.id : "";
			return '/api/coffee' + idSuffix;
		}
	});
	return Coffee;
});