define(['backbone'], function(Backbone) {
	var Country = Backbone.Model.extend({

		defaults: {
			id: 0,
			name: "name",
			latitude: "description",
			longitude: 0,
			zoom: 0,
		}
	});
	return Country;
});