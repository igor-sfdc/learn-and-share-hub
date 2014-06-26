This is an example of Selenium test automation for a resthub project

How to create a resthub project:

Open Command line and enter and enter the following command (per http://resthub.org/):
```
mvn archetype:generate -B \
	-DarchetypeGroupId=org.resthub \
	-DarchetypeArtifactId=resthub-jpa-backbonejs-archetype \
	-DarchetypeVersion=2.1.6 \
	-DarchetypeRepository=remote \
	-DgroupId=learn-and-share-hub \
	-DartifactId=resthub-selenium-automation-example \
	-Dversion=1.0-SNAPSHOT \
	-Dpackage=resthub.selenium.automation.example
```	
or in Windows
```
mvn archetype:generate -B ^
	-DarchetypeGroupId=org.resthub ^
	-DarchetypeArtifactId=resthub-jpa-backbonejs-archetype ^
	-DarchetypeVersion=2.1.6 ^
	-DarchetypeRepository=remote ^
	-DgroupId=learn-and-share-hub ^
	-DartifactId=resthub-selenium-automation-example ^
	-Dversion=1.0-SNAPSHOT ^
	-Dpackage=resthub.selenium.automation.example
```
The next step is update pom.xml with dependencies and plugins needed for test automation:

		<!-- Selenium dependencies -->
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>2.42.1</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>com.opera</groupId>
			<artifactId>operadriver</artifactId>
			<version>1.5</version>
			<exclusions>
				<exclusion>
					<groupId>org.seleniumhq.selenium</groupId>
					<artifactId>selenium-remote-driver</artifactId>
				</exclusion>
			</exclusions>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>xml-apis</groupId>
			<artifactId>xml-apis</artifactId>
			<version>1.4.01</version>
			<scope>test</scope>
		</dependency>		

After that we will update the plugins section:

            <plugin>
                <groupId>org.eclipse.jetty</groupId>
                <artifactId>jetty-maven-plugin</artifactId>
                <version>${maven.jetty.version}</version>
				<configuration>
					<httpConnector>
						<port>${jetty.port}</port>
						<idleTimeout>60000</idleTimeout>
					</httpConnector>
					<scanIntervalSeconds>5</scanIntervalSeconds>
					<stopKey>stopJetty</stopKey>
					<stopPort>9966</stopPort>
				</configuration>
				<executions>
					<execution>
						<id>start-jetty</id>
						<phase>pre-integration-test</phase>
						<goals>
							<goal>run</goal>
						</goals>
						<configuration>
							<httpConnector>
								<port>${jetty.integration.test.port}</port>
							</httpConnector>
							<daemon>true</daemon>
						</configuration>
					</execution>
					<execution>
						<id>stop-jetty</id>
						<phase>post-integration-test</phase>
						<goals>
							<goal>stop</goal>
						</goals>
					</execution>
				</executions>                
            </plugin>
			<plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>selenium-maven-plugin</artifactId>
				<version>2.3</version>
				<executions>
					<execution>
						<id>start</id>
						<phase>pre-integration-test</phase>
						<goals>
							<goal>start-server</goal>
						</goals>
						<configuration>
							<background>true</background>
							<logOutput>true</logOutput>
							<multiWindow>true</multiWindow>
						</configuration>
					</execution>
					<execution>
						<id>stop</id>
						<phase>post-integration-test</phase>
						<goals>
							<goal>stop-server</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
				<configuration>
					<systemPropertyVariables>
						<jetty.integration.test.port>${jetty.integration.test.port}</jetty.integration.test.port>
					</systemPropertyVariables>
					<excludes>
						<exclude>**/integration/*Test.java
						</exclude>
					</excludes>
				</configuration>
				<executions>
					<execution>
						<id>integration-tests</id>
						<phase>integration-test</phase>
						<goals>
							<goal>test</goal>
						</goals>
						<configuration>
							<skip>false</skip>
							<excludes>
								<exclude>none</exclude>
							</excludes>
							<includes>
								<include>**/integration/*Test.java
								</include>
							</includes>
						</configuration>
					</execution>
				</executions>
			</plugin>


Note how we specified jetty port for integration testing:

	<httpConnector>
		<port>${jetty.integration.test.port}</port>
	</httpConnector>

Next, we need to create the actual JUnit test. In this case, we are using Selenium to look for a snippet of text on the front page of our application:

		String testPort = System.getProperty("jetty.integration.test.port", "9080");
		driver.get("http://localhost:" + testPort  + "/");
		By conditionTemplate = By.tagName("h1");
		WebElement templateElement = driver.findElement(conditionTemplate);
		assertEquals("The element did not match expected.", "RESThub Backbone Bootstrap starter template", templateElement.getText()); 


Once we have completed these steps we can now run the test by using this command: 

mvn clean verify

Or if you want to run test with a custom HTTP port, say 7778, use this option:

mvn clean verify -Djetty.integration.test.port=7778
