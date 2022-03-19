# Gatling Load Testing REST API

it uses Java 17

if you have issues running maven commands, for java 16 and above use maven 3.8.4 `https://maven.apache.org/install.html`


## Build Fat jar

on the main folder run `mvn clean package` to generate the jar file. It will be stored in the `target/` directory.

## run tests

run mvn verify

## code coverage

the code coverage report can be accessed in the target folder target/site/jacoco/index.html

## gatling load tests

to run gatling, first make sure the application is running `mvn spring-boot:run` then open another terminal session and run `mvn gatling:test`
test reports can be found in the `target/gatling` directory each named by timestamp they ran.

## Further help

For further assistance feel free to contact me on my email: khim.mwangi@gmail.com
