# Domain Modelling Workshop

Dieses Repository enthält ein einfaches Demoprojekt als Grundlage für den Domain Modelling Workshop.

## Projektaufbau

Das Projekt nutzt [Spring Boot](https://spring.io/projects/spring-boot), um eine einfache REST-API bereitzustellen.

Als Datenbank kommt die In-Memory Datenbank [H2](https://www.h2database.com/) zum Einsatz.

Um weniger Code schreiben zu müssen ist [Lombok](https://projectlombok.org/) integriert. Hiermit werden Getter/Setter und Konstruktoren generiert.

Für das Mapping zwischen Domänenobjekten, DTOs und Entites kommt [Mapstruct](https://mapstruct.org/) zum Einsatz.

Struktur:

- `core` enthält die fachlichen Domänenobjekte und -services
- `web` enthält die REST-API Controller und DTO-Klassen
- `persistence` enthält die Datenbankrepositories und Entites.

## Projekt bauen

Ein initialer Aufruf von

```shell
mvn clean install
```

stellt sicher, dass alle benötigten Klassen generiert wurden.

Nach Änderungen an den Mappern kann es auch notwendig sein, diese mit dem Befehl neu zu generieren.

## Projekt starten

In IntelliJ die Main-Klasse `DomainModellingWorkshopApplication` starten.

Wenn IntelliJ fragt, ob Annotation Processing aktiviert werden soll, die Abfrage bestätigen.
Wird für Lombok und Mapstruct benötigt. 

## OpenAPI

Swagger UI unter http://localhost:8080/swagger-ui/index.html aufrufen