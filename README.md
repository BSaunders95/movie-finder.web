# Movie Finder Web
An application to display movie data requested by [movie-finder.api]("https://github.com/BSaunders95/movie-finder.api")

## Requirements
In order to run the application locally you'll need the following installed on your machine:

- [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads)

## Getting started

### Building the app
To compile the application without executing unit tests, simply run `make` at the root of the 
application directory.

To clean out the workspace, removing the compiled jar file and '/target' directory, run `make clean` 
at the root of the application directory.

To execute unit tests, run `make test` at the root of the application directory.

### Starting the app
Once built, execute the `start.sh` script to run the application. The application will boot at port 8081.

## Viewing the data
Once started, the app will be listening on port 8081.

In your browser, navigate to `localhost:8081` for further instructions.