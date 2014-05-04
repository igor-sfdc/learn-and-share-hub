define(['backbone', 'model/coffee'], function (Backbone, Coffee) {

    var Coffees = Backbone.Collection.extend({

        // Reference to this collection's model.
        model: Coffee,
        url:'/api/coffee'

    });
    return Coffees;
});
