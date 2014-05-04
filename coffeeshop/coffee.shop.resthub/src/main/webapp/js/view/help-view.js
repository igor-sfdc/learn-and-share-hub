define([ 'backbone', 'resthub', 'hbs!template/help'],
function (Backbone, Resthub, helpTemplate) {
    
    var HelpView = Resthub.View.extend({
        
        // Define view template
        template: helpTemplate,
        
        initialize:function () {
            // Render the view
            this.render();
        }

    });
    return HelpView;
});