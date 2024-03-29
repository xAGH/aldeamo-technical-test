# Entrega de Prueba Técnica - Aldeamo

Estimado equipo de Aldeamo,

Adjunto encontrarán la solución desarrollada para la prueba técnica solicitada. He implementado la lógica requerida utilizando Spring Boot versión 3.2.4 y Gradle versión 8.6, siguiendo las indicaciones proporcionadas en el enunciado.

A continuación, proporciono detalles sobre la implementación realizada:

## Detalles de la Solución

- **Tecnologías Utilizadas:**

  - Spring Boot versión 3.2.4
  - Gradle versión 8.6
  - JPA y JDBC
  - Docker
  - Swagger

- **Arquitectura:**
  - He seguido una arquitectura limpia hexagonal basada en puertos y adaptadores.

## Endpoints

Todos los endpoints tienen el prefijo `/api/stacks`, excepto la ruta de Swagger que se encuentra en `/doc/swagger-ui/index.html`.

- `GET /doc/swagger-ui/index.html`

  - Descripcion: Muestra la documentación de la API con uso de Swagger3 y OpenApi.

- `GET /api/stack/:id`

  - Descripcion: Obtiene el stack correspondiente al id proporcionado.
  - Parrámetros (Parámetros de consulta):
    - `id: integer` (número entero que indica el id del stack)
    - Respuesta: Información del stack solicitado.

- `GET /api/stack/`

  - Descripcion: Obtiene todos los stacks.
  - Respuesta: Lista de los stacks.

- `POST /api/stacks/`

  - Descripción: Crea un nuevo stack.
  - Parámetros (JSON):
    - `input_array | inputArray: string` (lista de números enteros positivos separados por coma)
  - Respuesta: Información del stack creado.

- `PUT /api/stacks/`

  - Descripción: Modifica un stack existente.
  - Parámetros (JSON):
    - `id: integer` (id del stack a modificar)
    - `input_array | inputArray: string` (lista de números enteros positivos separados por coma)
  - Respuesta: Información del stack modificado.

- `DELETE /api/stack/:id`

  - Descripcion: Elimina el stack correspondiente al id proporcionado.
  - Parrámetros (Parámetros de consulta):
    - `id: integer` (número entero que indica el id del stack)
  - Respuesta: Información del stack eliminado.

- `POST /api/stacks/order`
  - Descripción: Procesa los datos de acuerdo a los parámetros recibidos.
  - Parámetros (JSON):
    - `iterations: integer` (número de iteraciones)
    - `stack_id | stackId: integer` (id de la pila de datos)
  - Respuesta: Array resultante del procesamiento.

## Despliegue

La aplicación ha sido desplegada en Docker Hub, en el repositorio
`xagh/aldeamo-technical-test`. Además, he incluido el archivo
`docker-compose.yml` y su correspondiente `.env` en el proyecto.
Para levantar el proyecto basta con ejecutar el comando
`docker-compose up` en la raiz donde se encuentre tanto el archivo
`docker-compose.yml` y el archivo `.env`

También intenté desarrollar un frontend en Angular para mejorar la
experiencia de usuario, sin embargo, debido a limitaciones de
tiempo, no pude completar esta parte del proyecto. Queda pendiente
para futuras mejoras.

## Próximos Pasos

Quedo a la espera de sus comentarios y retroalimentación sobre la solución proporcionada. Si necesitan cualquier ajuste o mejora, estoy disponible para realizarlos.

Muchas gracias por la oportunidad de participar en esta prueba técnica. Espero que la solución sea de su agrado y cumpla con sus expectativas.

Atentamente, Alejandro Giraldo Herrera
