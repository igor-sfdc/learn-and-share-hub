define([ 'backbone', 'resthub', 'hbs!template/home'],
function (Backbone, Resthub, homeTemplate) {
    
    var HomeView = Resthub.View.extend({
        
        // Define view template
        template: homeTemplate,
        
        initialize:function () {
            // Render the view
            this.render();
        }

    });
    return HomeView;  
});