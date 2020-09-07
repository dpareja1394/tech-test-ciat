# tech-test-ciat
Este proyecto consta de 2 componentes, Front-End y Back-End.

El Back-End quedó configurado en el proyecto bk-tech-test-ciat. 
Se encuentra desarrollado con SpringBoot y Maven para gestión de Dependencias.
Se debe importar como un proyecto Maven en el Eclipse y se puede ejecutar desde el Entorno de Desarrollo Integrado. Una vez ejecutado el proyecto, queda disponible escuchando por http://localhost:9090
El proyecto fue generado con la ayuda del Framework de Desarrollo ZathuraCode en su versión 8.0.0 (https://zathuracode.org/).
Tiene una arquitectura de microservicio con las siguientes capas:
    - Repository : Encargada de la interacción de los objetos Java y las entidades en Base de datos; cabe resaltar que está con Spring Data JPA. 
    - Service: Encargada de la lógica de negocio.
    - RestControllers: Capa encargada de gestionar los End-Points donde se harán las peticiones Rest (POST-PUT-GET-DELETE) al MicroServicio. 

La base de datos quedó configurada en el proyecto Backend (bk-tech-test-ciat).
Se debe ir al archivo bk-tech-test-ciat\src\main\resources\application.properties, en este archivo se observa la configuración en #Spring DataSource Basic Config.

El Front-End quedó configurado en el proyecto fe-tech-test-ciat.
Se encuentra desarrollado con Angular y Node para gestión de dependencias.
Para ejecutar se debe tener la versión 12.18.3 LTS de NodeJS (disponible en https://nodejs.org/es/) y Angular en su versión 10.1.0 (disponible en https://cli.angular.io/).
Una vez se tenga instalado Angular y Node, se procede a acceder a la carpeta fe-tech-test-ciat por medio de una terminal de comandos (CMD, Powershell, Terminal) y se debe ejecutar el comando "ng serve -o", el proyecto estará disponible en el navegador en la ruta: http://localhost:4200/.