# Angular 2 Workshop with Spring Boot - The backend

To demonstrate how to use spring boot to serve an Angular 2 application.

* [UI](https://github.com/TomJahncke/Angular2Workshop/) project that is served by this application.
* Started by using https://start.spring.io/

# Build the final sample
* mvn package
* cd target
* java -jar tohWeb-0.0.1-SNAPSHOT.jar
    * Can add -Dexploded.path=<Path to the dist folder of your Angular 2 application, with a slash at the end>
    * Such as -Dexploded.path=file:///Users/tjahncke/playground/Angular2Workshop/dist/