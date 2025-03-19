all: clean package run

package:
	mvn -f pom.xml package

run:
	java -jar target/finteh-0.0.1-SNAPSHOT.jar

clean:
	mvn -f ./pom.xml clean

docker:
	@if [ -z "$$(docker ps -q -f name=postgres)" ]; then \
		docker compose up -d; \
	else \
		echo "Docker контейнер postgres уже запущен"; \
	fi