define([ 'backbone', 'resthub', 'hbs!template/contact'],
function (Backbone, Resthub, contactTemplate) {
    
    var ContactView = Resthub.View.extend({
        
        // Define view template
        template: contactTemplate,
        
        initialize:function () {
            // Render the view
            this.render();
        }

    });
    return ContactView;
});