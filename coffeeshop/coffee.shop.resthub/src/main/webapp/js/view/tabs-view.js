define([ 'backbone', 'resthub', 'hbs!template/tabs'],
function (Backbone, Resthub, tabsTemplate) {
    
    var TabsView = Resthub.View.extend({
        
        template: tabsTemplate,
        
        initialize:function () {
            // Render the view
            this.render();
        }

    });
    return TabsView;
});