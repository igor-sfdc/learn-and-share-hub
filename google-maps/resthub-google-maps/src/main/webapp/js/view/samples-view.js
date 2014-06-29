define([ 'backbone', 'resthub', 'collection/samples', 'hbs!template/samples' ],
function (Backbone, Resthub, Samples, samplesTemplate) {
    
    var SamplesView = Resthub.View.extend({
        
        // Define view template
        template: samplesTemplate,

        initialize:function () {
            // Initialize the collection
            this.collection = new Samples();
            
            // Render the view when the collection is retreived from the server
            this.listenTo(this.collection, 'sync', this.render);
            
            // Request unpaginated URL
            this.collection.fetch({ data: { page: 'no'} });
        },
        render: function() {
            var html = this.template(this);
            this.$el.html(html);
    
            this.renderMap();
        },
        renderMap: function() {
            var lat = 0;
            var lon = 0;
            var z = 1;        
            var myLatlng = new google.maps.LatLng(lat, lon);
            var mapOptions = {
                    zoom: z,
                    center: myLatlng,
                    mapTypeId: google.maps.MapTypeId.TERRAIN
            };
            var mapTargetElement = $("#map")[0];
            new google.maps.Map(mapTargetElement, mapOptions);
        },

    });
    return SamplesView;
});