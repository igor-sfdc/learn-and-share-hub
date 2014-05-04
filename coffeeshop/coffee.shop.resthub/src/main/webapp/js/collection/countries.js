define(['backbone', 'model/country'], function (Backbone, Country) {

    var Countries = Backbone.Collection.extend({

        // Reference to this collection's model.
        model: Country,
        url:'/api/country'

    });
    return Countries;
});
