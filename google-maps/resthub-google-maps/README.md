
This is an example of adding Google Maps to a resthub project

How to create a resthub project:

Open Command line and enter and enter the following command (per http://resthub.org/):
```
mvn archetype:generate -B \
	-DarchetypeGroupId=org.resthub \
	-DarchetypeArtifactId=resthub-jpa-backbonejs-archetype \
	-DarchetypeVersion=2.1.6 \
	-DarchetypeRepository=remote \
	-DgroupId=learn-and-share-hub \
	-DartifactId=resthub-google-maps \
	-Dversion=1.0-SNAPSHOT \
	-Dpackage=resthub.google.maps.example
```	
or in Windows
```
mvn archetype:generate -B ^
	-DarchetypeGroupId=org.resthub ^
	-DarchetypeArtifactId=resthub-jpa-backbonejs-archetype ^
	-DarchetypeVersion=2.1.6 ^
	-DarchetypeRepository=remote ^
	-DgroupId=learn-and-share-hub ^
	-DartifactId=resthub-google-maps ^
	-Dversion=1.0-SNAPSHOT ^
	-Dpackage=resthub.google.maps.example
```  

TODO: Steps for adding Google Maps    