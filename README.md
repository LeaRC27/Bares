# Bares

Cree y ejecute la app usando Maven.
mvn package
java -jar target/bares-0.0.1-SNAPSHOT.jar

Alternativamente, puede ejecutar la app sin empaquetarla usando
mvn spring-boot:run

Sample REST API with Spring Boot, H2, CRUD, Maven and JUnit

Se utilizo Maven para empaquetado y gestion de dependencias, 
Spring Boot para desplegar una API REST en la cual se implemento CrudRepository y H2 para la persistencia de datos,
y JUnit para realizarar algunos test unitarios.

Algunas posibles mejoras:
- Agregar validaciones a atributos de Bar que aun no poseen.
- Agregar test Unitarios a los servicios.
- Agregar test de integracion entre los servicios y el guardado de datos en la base.
