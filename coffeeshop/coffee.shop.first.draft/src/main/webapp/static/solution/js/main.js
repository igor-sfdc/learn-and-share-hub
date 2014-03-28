(function(){
	window.App = {   // defining app name space, You can rename it as per your project name..
			Models: {},
			Collections: {},
			Instances: {},
			Views: {},
			Routers: {}
	};
})(); 


$( document ).ready(function() {
	/**
	 * coffee model
	 */
		App.Models.Coffee = Backbone.Model.extend({
			defaults: {
				name: 'name',
				description: 'description',
				region: 'region',
				country: 'country',
				processed: 'roasted',
				weight: 'weight'
			}
		});
	/**
	 * Coffee collection list
	 */
	App.Collections.CoffeeCollection = Backbone.Collection.extend({
		model: App.Models.Coffee
	});
	
	
	// initialize coffee collection
	
	App.Instances.coffeeCollection = new App.Collections.CoffeeCollection(
			[
			 new App.Models.Coffee({name: "coffeeOne", description: "dark", region: "mountain", country: "countryOne", processed: "roasted", weight: 1}),
			 new App.Models.Coffee({name: "coffeeTwo", description: "dark", region: "mountain", country: "countryTwo", processed: "roasted", weight: 1}),
			 new App.Models.Coffee({name: "coffeeThree", description: "dark", region: "mountain", country: "countryThree", processed: "roasted", weight: 1})
			 ]
	);	
	
	/**
	 * the view for tabs
	 */
	App.Views.Tabs = Backbone.View.extend({
		template: _.template($('#tabContainerTemplate').html()),
		initialize: function() {
			this.render();
		},
		render: function(){
			this.$el.html( this.template());
			return this;
		},
		events: {
			'click .tabHomePage' : 'goToHomePage',
			'click .tabCoffeeCollectionPage' : 'goToCoffeeCollectionPage'
		},
		goToHomePage: function(){
			App.Instances.appRouter.visitHomePage();
			return false;
		},
		goToCoffeeCollectionPage: function(){
			App.Instances.appRouter.visitCoffeeCollectionPage();
			return false;
		}
	});
	/**
	 * The view instance for tabs
	 */
	App.Instances.tabsView = new App.Views.Tabs({
		el: $("#tabsArea")
	}); 
	/**
	 * The view for homepage, content view only
	 */
	App.Views.HomePage = Backbone.View.extend({
		template: _.template($('#homePageViewTemplate').html()),
		initialize: function() {
			this.render();
		},
		render: function(){
			this.$el.html( this.template());
			return this;
		}
	});
	/**
	 * The view for coffee collection template
	 */
	App.Views.CoffeeCollection = Backbone.View.extend({
		template:  _.template($('#coffeeCollectionTemplate').html()),
		initialize: function(){
			this.render();
		},
		render: function(){
			this.$el.html( this.template());

			// Need to add everything to #coffeeCollectionViewContainer
			this.collection.each(this.addOne, this);
			return this;
		},
		// called upon add event or from render for each initially existing coffee
		addOne: function(coffee){
			var coffeeView = new App.Views.CoffeeItem({ model: coffee });
			$("#coffeeCollectionViewContainer").append(coffeeView.render().el);
		}
	});
	/**
	 * view for coffee item
	 */
	App.Views.CoffeeItem = Backbone.View.extend({
		tagName: 'tr',
		/**
		 * coffee item template
		 */
		template: _.template($('#coffeeItemTemplate').html()),
		initialize: function(){
		},
		render: function(){
			this.$el.html( this.template(this.model.toJSON()));
			return this;
		}
	});
/**
 * Routes
 */
	App.Routers.ApplicationRouter = Backbone.Router.extend ({
		routes: {
			//HOME PAGE
			'': 'renderHomePage',
			//COFFEE COLLECTION PAGE
			'coffeeCollectionPageUrlPattern': 'renderCoffeeCollectionPage'
		},
/**
 * render home page
 */
		renderHomePage: function () {
			console.log('going home');

			if (App.Instances.homePageView) {
				App.Instances.homePageView.render();
			} else {
				App.Instances.homePageView = new App.Views.HomePage({
					el: $("#content-container"),
				}); 	    	
			}
		},

		/**
		 * render coffee collection page
		 */ 
		renderCoffeeCollectionPage: function () {
			console.log('you are viewing coffee collection page');
			App.Instances.coffeeCollectionView = new App.Views.CoffeeCollection({
				el: $("#content-container"),
				collection: App.Instances.coffeeCollection
			}); 
		},    
		/**
		 * Trigger Navigation Functions
		 */
		visitHomePage: function(){
			App.Instances.appRouter.navigate('', {trigger: true});
		},
		visitCoffeeCollectionPage: function (){
			App.Instances.appRouter.navigate('coffeeCollectionPageUrlPattern', {trigger: true});
		}
	});

	App.Instances.appRouter = new App.Routers.ApplicationRouter();
	Backbone.history.start();

	//navigate to home page upon loading.
	App.Instances.appRouter.visitHomePage();	

});

