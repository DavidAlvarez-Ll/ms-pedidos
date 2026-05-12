# ms-pedidos

## Descripción
Microservicio responsable de registrar y gestionar pedidos realizados por clientes.

## Tecnologías utilizadas
- Java 17
- Spring Boot 3.2
- Spring Data JPA
- PostgreSQL (Neon)
- Maven
- Docker

## Endpoints disponibles
| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | /api/pedidos | Crear pedido |
| GET | /api/pedidos | Listar pedidos |
| GET | /api/pedidos/{id} | Buscar por ID |
| PATCH | /api/pedidos/{id}/estado | Actualizar estado |
| DELETE | /api/pedidos/{id} | Eliminar pedido |

## Variables de entorno
| Variable | Descripción |
|----------|-------------|
| DB_URL | URL de conexión a PostgreSQL |
| DB_USERNAME | Usuario de la base de datos |
| DB_PASSWORD | Contraseña de la base de datos |
| PORT | Puerto del servidor |

## Ejecutar en local
1. Clonar el repositorio
2. Configurar variables de entorno con los datos de Neon
3. Ejecutar con IntelliJ o con:
```bash
mvn spring-boot:run
```

## Despliegue en Render
1. Conectar repositorio GitHub en Render
2. Seleccionar runtime Docker
3. Configurar las variables de entorno
4. Deploy

## URL del servicio desplegado
https://ms-pedidos-iz8x.onrender.com
