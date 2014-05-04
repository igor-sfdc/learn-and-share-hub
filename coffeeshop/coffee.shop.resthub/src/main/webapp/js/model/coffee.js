define(['backbone', 'resthub'], function(Backbone, Resthub) {
	var Coffee = Backbone.Model.extend({

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