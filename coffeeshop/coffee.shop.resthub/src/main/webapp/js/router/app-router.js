define(
		['backbone', 
		 'view/tabs-view', 
		 'view/home-view', 
		 'view/about-view', 
		 'view/coffees-view', 
		 'view/coffee-view',
		 'view/coffee-readonly-view',
		 'view/contact-view', 
		 'view/help-view',
		 'collection/coffees'],
function (Backbone, TabsView, HomeView, AboutView, CoffeesView, CoffeeView, CoffeeReadonlyView, ContactView, HelpView, Coffees) {			
    
    var AppRouter = Backbone.Router.extend({

        initialize: function() {
        	// Adding a custom handlebars helper for use in coffee template      	
        	// Need to do this only once per application initialization so we placed it here
        	Handlebars.registerHelper('ifeq', function(a, b, block) {
        	    return a == b ? block.fn() : block.inverse();
        	});
        	
        	this.tabsView = new TabsView({ root: $('#tabs') });
        	//Before, if we navigated to a different tab and refreshed the page, it would give us a 404 error when pushState was True.
        	//Now that we set pushState to False, it doesn't giv us that error.
        	//In the process of analyzing why this happens.
            Backbone.history.start({ pushState: false, root: "/" });
        },

        routes:{
            '': 'home',
            'home': 'home',
            'coffees': 'coffees',
            'coffee': 'newCoffee',
			'coffee/:id': 'editCoffee',
			'coffeeReadonly/:id': 'coffeeReadonly',
			'coffeeDelete/:id': 'coffeeDelete',
            'contact': 'contact',
            'help': 'help',
            'about': 'about'
        },

        home: function () {
           new HomeView({ root: $('#main') });
        },
        about: function () {
            new AboutView({ root: $('#main') });
        },
        coffees: function () {
            new CoffeesView({ root: $('#main') });
        },
        coffee: function () {
        	var coffeeView = new CoffeeView({ root: $('#main') });
        	coffeeView.appRouter = this;
        },
        newCoffee: function () {
            var newCoffeeView = new CoffeeView({ root: $('#main') });
            newCoffeeView.appRouter = this;
        },
        editCoffee: function (id) {
            var editCoffeeView = new CoffeeView({ root: $('#main'), id: id });
            editCoffeeView.appRouter = this;
        },
        coffeeReadonly: function (id) {
            new CoffeeReadonlyView({ root: $('#main'), id: id });
        },
        coffeeDelete: function (id) {
 //           new CoffeeView({ root: $('#main'), id: id });
        },
        contact: function () {
            new ContactView({ root: $('#main') });
        },
        help: function () {
            new HelpView({ root: $('#main') });
        }      
    });

    return AppRouter;

});