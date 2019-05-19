.PHONY: all
all: build

.PHONY: clean
clean:
	mvn clean
	rm -f ./movie-finder.web.jar

.PHONY: test
test:
	mvn test

.PHONY: build
build:
	mvn package -DskipTests=true
	cp ./target/movie-finder.web-0.0.1-SNAPSHOT.jar ./movie-finder.web.jar