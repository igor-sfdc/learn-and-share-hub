(function(){
	window.App = {   // defining app name space, You can rename it as per your project name..
			Models: {},
			Collections: {},
			Instances: {},
			Views: {},
			Routers: {}
	};
	console.log("defined app");
	
	google.load("maps", "3.4", {
		other_params : "sensor=false&language=en"
	});
	console.log("initialized googlemaps");
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
			countryFromId: '',
			processed: 'roasted',
			weight: 'weight'
		},
		validate: function(attrs, options) {
			if (isNaN(parseInt(attrs.weight)) || attrs.weight.toString() !== parseInt(attrs.weight).toString()) {
				return "weight must be an int number. Provided value: " + attrs.weight;
			}
			if (attrs.weight < 1 || attrs.weight > 5) {
				return "Weight must be between 1 and 5. Provided value: " + attrs.weight;
			}
		},
		urlRoot: '/rest/coffee'
	});
/**
 * Coffee collection list
 */
App.Collections.CoffeeCollection = Backbone.Collection.extend({
	model: App.Models.Coffee,
	url: '/rest/coffee' 
});
/**
 * Country model
 */
App.Models.Country = Backbone.Model.extend({
	defaults: {
		name: 'name',
		latitude: 'latitude',
		longitude: 'longitude',
		zoom: 'zoom'
	}
});
/**
 * Country collection
 */
App.Collections.CountryCollection = Backbone.Collection.extend({
	model: App.Models.Country,
	url: '/rest/country', //This is how you access it to test it from the browser: http://localhost:8080/rest/country
	countryNameFromId: function(id) {
		return this.get(id).attributes.name; 
	}
});
/**
 * reads coffee from database
 */
	App.Instances.coffeeCollection = new App.Collections.CoffeeCollection();	
	App.Instances.coffeeCollection.fetch({success: function(){
		console.log("fetched coffee collection " + App.Instances.coffeeCollection.models);
	}});
/**
 * read country collection from database
 */	
	App.Instances.countryCollection = new App.Collections.CountryCollection();
	App.Instances.countryCollection.fetch({success: function(){
		console.log("fetched country collection " + App.Instances.countryCollection.models);
	}});
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
			'click .tabAboutUsPage' : 'goToAboutUsPage',
			'click .tabNewCoffeePage' : 'goToNewCoffeePage',
			'click .tabCoffeeCollectionPage' : 'goToCoffeeCollectionPage',
			'click .tabContactUsPage' : 'goToContactUsPage',
			'click .tabHelpPage' : 'goToHelpPage'
		},
		goToHomePage: function(){
			App.Instances.appRouter.visitHomePage();
			return false;
		},
		goToAboutUsPage: function(){
			App.Instances.appRouter.visitAboutUsPage();
			return false;
		},
		goToNewCoffeePage: function(){
			App.Instances.appRouter.visitNewCoffeePage();
			return false;
		},
		goToCoffeeCollectionPage: function(){
			App.Instances.appRouter.visitCoffeeCollectionPage();
			return false;
		},
		goToContactUsPage: function(){
			App.Instances.appRouter.visitContactUsPage();
			return false;
		},
		goToHelpPage: function(){
			App.Instances.appRouter.visitHelpPage();
			return false;
		}
	});
	/**
	 * The instance view for tabs
	 */
	App.Instances.tabsView = new App.Views.Tabs({
		el: $("#tabsArea"), //targetting <div> element with this id
	}); 
	/**
	 * the view for homepage, content view only
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
	 * the view for about us page, content view only
	 */
	App.Views.AboutUsPage = Backbone.View.extend({
		template: _.template($('#aboutUsPageViewTemplate').html()),
		initialize: function() {
			this.render();
		},
		render: function(){
			this.$el.html( this.template());
			return this;
		}
	});
	/**
	 * the view for contact us page, content view only
	 */
	App.Views.ContactUsPage = Backbone.View.extend({
		template: _.template($('#contactUsPageViewTemplate').html()),
		initialize: function() {
			this.render();
		},
		render: function(){
			this.$el.html( this.template());
			return this;
		}
	});
	/**
	 * the view for help page, content view only
	 */
	App.Views.HelpPage = Backbone.View.extend({
		template: _.template($('#helpPageTemplate').html()),
		initialize: function() {
			this.render();
		},
		render: function(){
			this.$el.html( this.template());
			return this;
		}
	});
	/**
	 * View for coffee collection template
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
//			console.log("Last element name: " + this.collection.models[this.collection.size()-1].attributes.name + " and id: " + this.collection.models[this.collection.size()-1].attributes.id);
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
			this.model.on('change', this.render, this);
			this.model.on('destroy', this.remove, this);
		},
		events: {
			'click .edit' : 'editCoffee',
			'click .delete' : 'destroyCoffee'
		},
		editCoffee: function(){
			var newName = prompt("Please enter the new name", this.model.get('name'));
			if (!newName)return;
			this.model.set('name', newName);
		},
		destroyCoffee: function(){

			this.model.destroy({
				success : function(coffeeToDelete, response) {
					console.log("successfully deleted");							
				},
				error : function(coffeeToDelete, response) {
					console.log("error deleting");
				}
			});
			App.Instances.appRouter.visitCoffeeCollectionPage();
			return false;
		},
		remove: function(){
			this.$el.remove();
		},
		render: function(){
			this.$el.html( this.template(this.model.toJSON()));
			return this;
		}
	});
	/**
	 * the view for coffee
	 */
	App.Views.Coffee = Backbone.View.extend({
		templateView: _.template($('#coffeeViewTemplate').html()),
		templateEdit: _.template($('#coffeeEditTemplate').html()),
		templateNew: _.template($('#coffeeNewTemplate').html()),
		templateCoffeeForm: _.template($("#coffeeFormTemplate").html()),
		initialize: function(){		
			this.render();	
		},
		render: function(){
			console.log("before processing template");
			var currentTemplate;
			if (this.attributes.mode == "edit") {
				currentTemplate = this.templateEdit;
				this.$el.html(currentTemplate());
				$("#coffeeForm").html(this.templateCoffeeForm(this.model.toJSON()));
			} else if (this.attributes.mode == "new") {
				currentTemplate = this.templateNew;
				this.$el.html(currentTemplate());
				$("#coffeeForm").html(this.templateCoffeeForm(this.model.toJSON()));
			} else {
				currentTemplate = this.templateView;
				this.$el.html( currentTemplate(this.model.toJSON()));
			}
        

			var countryModel = App.Instances.countryCollection.get(this.model.attributes.countryFromId);
			if(countryModel) {
				this.renderMap(countryModel.attributes.latitude, countryModel.attributes.longitude, countryModel.attributes.zoom);
			} else {
				//if the countryModel cannot be found, then it must mean this is the default map for new coffee
				this.renderMap(1, 1, 1);
			}
	        console.log("after processing template");
			return this;
		},
		events : {
			"click .save" : "saveCoffee",
			"click .cancel" : "cancelCoffee",
			//here we bind the country to the update when you update the country field in the form.
			'change #countryFromId' : 'updateMap'
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
		updateMap: function(event) {
	        console.log('hey new country value ' + event.target.value);
	        var selectedCountryId = event.target.value;
	        var countryModel = App.Instances.countryCollection.get(selectedCountryId);
	        this.renderMap(countryModel.attributes.latitude, countryModel.attributes.longitude, countryModel.attributes.zoom);	     
	    },
//TODO:	    
		cancelCoffee: function() {
	        alert("cancel coffee not implemented");
	    },
		saveCoffee : function() {
			console.log("coffee saved: " + $('#name').val());

			var coffeeDetailsUpdated = {
					name: $('#name').val(),
					description: $('#description').val(),
					processed: $('#processed').val(),
					countryFromId: $('#countryFromId').val(),
					region: $('#region').val(),
					weight: $('#weight').val(),
			};

			if (this.model.isNew()) {
				this.model.set(coffeeDetailsUpdated);
				App.Instances.coffeeCollection.create(this.model, {
					success : function(coffeeAdded, response) {
						console.log("successfully saved/added new coffee " + coffeeAdded.id);
						// Move to the collection page ONLY after success is confirmed and the ID is received (async processing)
						App.Instances.appRouter.visitCoffeeCollectionPage();
					},
					error : function(coffeeAdded, response) {
						console.log("error saving/adding new coffee");
					}
				});			
			} else {
				this.model.save(coffeeDetailsUpdated, {
					success : function(coffeeUpdated, response) {
						console.log("successfully saved/updated coffee " + coffeeUpdated.id);
						// Move to the collection page ONLY after success is confirmed
						App.Instances.appRouter.visitCoffeeCollectionPage();
					},
					error : function(coffeeUpdated, response) {
						console.log("error saving/updating coffee");
					}
				});
			}			
			return false;		
		},
		deleteCoffee : function() {
			console.log("coffee deleted");	
			App.Instances.coffeeCollection.remove(this.model);
			App.Instances.appRouter.visitCoffeeCollectionPage();
			return false;		
		}
	});		
/**
 * Routes
 */
	App.Routers.ApplicationRouter = Backbone.Router.extend ({
		routes: {
			//HOME PAGE
			'': 'renderHomePage',
			//ABOUT US PAGE
			'aboutUsPageUrlPattern': 'renderAboutUsPage',
			//COFFEE PAGE
			'coffeePageUrlPattern/:id(/:edit)': 'renderCoffeePage',
			//NEW COFFEE PAGE
			'newCoffeePageUrlPattern': 'renderNewCoffeePage',
			//COFFEE COLLECTION PAGE
			'coffeeCollectionPageUrlPattern': 'renderCoffeeCollectionPage',
			//CONTACT US PAGE
			'contactUsPageUrlPattern': 'renderContactUsPage',
			//HELP PAGE
			'helpPageUrlPattern': 'renderHelpPage'
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
		 * render about us page
		 */ 
		renderAboutUsPage: function () {
			console.log('you are viewing about us page');
			App.Instances.aboutUsView = new App.Views.AboutUsPage({
				el: $("#content-container"),
				collection: App.Instances.aboutUs
			}); 
		}, 
		/**
		 * render coffee page
		 */    
		renderCoffeePage: function (id, editFlag) {
			console.log('you are viewing coffee page id: ' + id + " " + editFlag);

			if (App.Instances.coffeeView) {
				App.Instances.coffeeView.model = App.Instances.coffeeCollection.get(id);
				App.Instances.coffeeView.attributes.mode = Boolean(editFlag) ? "edit" : "view";
				App.Instances.coffeeView.render();
			} else {
				App.Instances.coffeeView = new App.Views.Coffee({
					el: $("#content-container"),
					model: App.Instances.coffeeCollection.get(id),
					attributes: {
						mode: Boolean(editFlag) ? "edit" : "view"
					}
				}); 	    	
			}
		},
		/**
		 * render new coffee page
		 */	    
		renderNewCoffeePage: function () {
			console.log('you are viewing new coffee page');
			App.Instances.newCoffee = new App.Models.Coffee();

			App.Instances.newCoffee.on("invalid", function(model, error) {
				alert("Error: " + error);
			});			

			if (App.Instances.coffeeView) {
				App.Instances.coffeeView.model = App.Instances.newCoffee;
				App.Instances.coffeeView.attributes.mode = "new";
				App.Instances.coffeeView.render();
			} else {
				App.Instances.coffeeView = new App.Views.Coffee({
					el: $("#content-container"),
					model: App.Instances.newCoffee,
					attributes: {
						mode: "new"
					}
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
		 * render contact us page
		 */
		renderContactUsPage: function () {
			console.log('you are viewing contact us page');
			App.Instances.contactUsView = new App.Views.ContactUsPage({
				el: $("#content-container"),
				collection: App.Instances.contactUs
			}); 
		},  
		/**
		 * render help page
		 */   
		renderHelpPage: function () {
			console.log("you are viewing help page");
			if (App.Instances.helpPageView) {
				App.Instances.helpPageView.render();
			} else {
				App.Instances.helpPageView = new App.Views.HelpPage({
					el: $("#content-container"),
				}); 	    	
			}
		},
		/**
		 * Trigger Navigation Functions
		 */
		visitHomePage: function(){
			App.Instances.appRouter.navigate('', {trigger: true});
		},
		visitCoffeePage: function (id, isEdit){
			//this is essentially an if statement and an assignment all in one
			var editFlag = isEdit ? "/true" : "";
			App.Instances.appRouter.navigate('coffeePageUrlPattern/' + id + editFlag, {trigger: true});		
		},
		visitAboutUsPage: function (){
			App.Instances.appRouter.navigate('aboutUsPageUrlPattern', {trigger: true});
		},
		visitNewCoffeePage: function (){
			App.Instances.appRouter.navigate('newCoffeePageUrlPattern', {trigger: true});
		},
		visitCoffeeCollectionPage: function (){
			App.Instances.appRouter.navigate('coffeeCollectionPageUrlPattern', {trigger: true});
		},
		visitContactUsPage: function (){
			App.Instances.appRouter.navigate('contactUsPageUrlPattern', {trigger: true});
		},
		visitHelpPage: function (){
			App.Instances.appRouter.navigate('helpPageUrlPattern', {trigger: true});
		}
	});

	App.Instances.appRouter = new App.Routers.ApplicationRouter();
	Backbone.history.start();

	//navigate to home page upon loading.
	App.Instances.appRouter.visitHomePage();	

});

