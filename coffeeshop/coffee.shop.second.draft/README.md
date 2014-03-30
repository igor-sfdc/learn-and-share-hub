This update is a data layer built on top of MySQL database and restful services. 

It is going to be incorporated into the overall project so that more advanced features like editing existing records and adding new records would be possible.

All our data is stored in a database. The database has 2 tables: coffee and country.
Coffee has fields such as name, region, country, and weight. Country has fields such as name, lattitude, longitude, and zoom. 

To access the data from the database we are using Jersey RESTful Webservices.

To set this up and run (assuming you have Java 1.6 or newer, Git and Maven installed):

1. Install and configure your database. More details on setting up the database are in the sql folder.

2. Download or clone code from Github and run the following commands
<code><div>
<div>$ cd coffeeshop\coffee.shop.second.draft </div>
<div>$ mvn clean package jetty:run </div>
</div></code>

3. After making sure your Jetty server is running, enter the following URL's in your browser:

- to get a list of coffee records use: localhost:8080/rest/coffee 

- to get a specific coffee record use: localhost:8080/rest/coffee/1

- or for countries, use: localhost:8080/rest/country
