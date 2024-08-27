# mi_arqueotipo

Planteamiento del Problema
Diseñar un sistema de gestión para un . El sistema debe permitir gestionar deportes, entrenadores, miembros y sesiones de entrenamiento. Los requisitos incluyen:
Cada deporte tiene un nombre, una descripción, y un nivel de dificultad (bajo, medio, alto). Un deporte puede tener varios entrenadores asignados.
Un entrenador tiene un nombre, una especialidad (el deporte que entrena) y una lista de sesiones de entrenamiento que imparte.
Los miembros del club pueden ser de dos tipos: juveniles o adultos. Cada miembro tiene un nombre, una dirección de correo electrónico y un número de identificación. Los juveniles solo pueden inscribirse en deportes con nivel de dificultad bajo o medio, mientras que los adultos pueden inscribirse en deportes de cualquier nivel de dificultad.
Una sesión de entrenamiento registra la fecha, la duración, y el estado (programada o completada). Cada sesión está asociada a un único deporte y a un único entrenador.
Un administrador tiene un nombre y un número de identificación. Es responsable de programar y gestionar las sesiones de entrenamiento.
Para el problema anterior:

1. Entregar el modelo de Clases(usando relaciones de herencia, interfaces, asociación, agregación).
2. Implementar el código java con interfaces de usuario
3. Desarrollar los crud para las entidades core.
4. Desarrollar la funcionalidad principal: gestionar inscripciones en sesiones de entrenamiento
5. Entregar el repositorio en github
6. Entregar un video de explicación del trabajo realizado.

# Autores

- Juan Nicolas Castro
- Maryam Hernadez
-Santiago poloncia 

# Herramientas

- [java 17](https://adoptium.net/es)
- [junit 5.10.0](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.10.0)
- [maven](https://maven.apache.org)


# Construcción y pruebas

Para compilar el proyecto puede usar el comando:

```shell
mvn clean compile
```

Para ejecutar las pruebas puede usar el comando: 

```shell
 mvn clean test
```

Para generar el jar puede usar el comando: 

```shell
 mvn clean package
```

y para ejecutar el jar

```shell
 java -jar target/mi_arqueotipo-1.0.jar
```
