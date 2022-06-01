# Afiliaciones 
## _Micro servicios para realizar la afiliación de clientes a diferentes programas._

## Instrucciones
Recomendaciones a tener en cuenta:
- Una base de datos en MySql.
- Tener instalado el gestor de paquetes Maven.
- Postman (herramienta para realizar consumos a rest).

## Instalación

- Se debe descargar este Respositorio, donde se encuentran los 4 micro servicios
- Importar individualmente los 4 Proyectos en el ambiente qeu utilice (Eclipse, Intellij Idea, Visual Studio)
- Al dar Run en alguno de los proyecto, se conectará a la Base de datos que esté en su local, ya que en el propperties de cada uno de los proyectos tiene su s respectivas credenciales
- La Base de datos se actualizará a como está desarrollada en el Proyecto

## Run (desplegar proyecto)

- Para probar los Micro Servicios se deberá importar la colección de Postman que fue enviada al correo
- La colección está separada por Micro servicios, asi que se probarán los servicios del proyecto que esté desplegado

## Ejecución
En la Colección de postamn está ordenada por Micro Servicios, con su respoectivo body si es para registrar o para actualizar

## Respuestas esperadas
Para los servicios que consultan algun dato en la base de datos, tiene 2 opciones, o encontrarlo y respon
> {
>    "code": 200,
>    "dateAt": "2021-07-27 11:26:24",
>    "response": "Response exitosa"
>}

O no encontrarlo y mostrar la excepción personalizada del notFound
> {
>    "code": 401
>    "dateAt": "2021-07-27 15:23:48",
>    "message": "Upss, no se encontraron resultados"
> }

## Pruebas Unitarias

Cada uno de los Micro Servicios tiene Pruebas Unitarias, el total de las pruebas está a un 90% de exitoso, pero los Services tienen 100%.

Esto se puede comprobar con el Coverage As JUnit, que ya viene implementado como depencia en cada uno de los proyectos .

## Documentación Swagger
Cada uno de los proyectos tiene implementada la dependencia de Swagger, donde al desplegar cada uno de los proyect, se podrá acceder a la siguiente url y comporbar su documentación
```sh
{{puerto_donde_esté_corriendo}}/swagger-ui/index.html#/
```
## Branching
La ramificación se realizo en cada uno de los micro servicios, se desarrollo cada en su propia rama, para al final realizar el Merge con la rama Master

## Muchas Gracias!! 
