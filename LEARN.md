# These are just conventions. It may vary project to project.

#### Even I follow another convention. I'm writing this conventions just for fun.

## Main applications source code write in `src/main/java`

It's the entry point of the application.

### The base package of the application is `com.example.application`.

### The controller class responsible for handling HTTP request. This package name is `com.example.application.controller`

### In the same way model class represent the data structure of application and stored in `com.example.application.model`.

### Repository interact with database or other external data sources and the package name is ..... you know what this is.

### Exception and configuration packagees names are `..exception` & `..configuration`.

## Applications resources like static files, templates, configuration etc are stored in `src/main/resources`

### Database connection details or server port or any other configuration details are stored in `application.propertise`. (Some of them also use `application.yml` -> it's easy)

### Static files like CSS, JS, images are stored in `static` directory

### Templates are stored in `templates` directory. (There are template engine like Thymeleaf, FreeMarker ets)

## Test code of this application are stored in `src/test/java`

## The maven build configuration file that defines project dependencies, plugins, or other build related settings are stored in the `pom.xml` file. It's in the main directory.
