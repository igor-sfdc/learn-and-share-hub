define([ 'backbone', 'resthub', 'collection/coffees', 'hbs!template/coffees' ],
function (Backbone, Resthub, Coffees, coffeesTemplate) {
    
    var CoffeesView = Resthub.View.extend({
        
        // Define view template
        template: coffeesTemplate,

        initialize:function () {
        	
            // Initialize the collection
            this.collection = new Coffees();
            
            // Render the view when the collection is retreived from the server
            this.listenTo(this.collection, 'sync', this.render);
            
            // Request unpaginated URL
            this.collection.fetch({ data: { page: 'no'} });
        },   
        render: function() {
        	var html = this.template(this);
        	this.$el.html(html);
        },
		events : {
			"click .delete" : "deleteCoffee"
		},
		deleteCoffee: function(event) {
			//We are using custom attribute value to store the id in a hyperlink <a>
	        var id=event.target.getAttribute("value");
			console.log('deleting coffee ' + id);
            var elementToDelete = this.collection.get(id);
            elementToDelete.destroy();
			this.render();
			return false;		
		}

    });
    return CoffeesView;
});