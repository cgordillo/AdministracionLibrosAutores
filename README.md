# Instrucciones

### Ambiente local

- Libros: [localhost:8080/AdministracionLibros/V1.0](localhost:8080/AdministracionLibros/V1.0)
- Autores: [localhost:8080/AdministracionAutores/V1.0](localhost:8080/AdministracionAutores/V1.0)

## Construccion y ejecucion

### Como archivo jar
```
# Compilacion mvn
mvn clean install
```
```
java -jar target/administracionlibros-1.0.1.jar
```

### Como contenedor Docker
```
# Construir la imagen
docker build --tag=administracionlibros:1.0.1 .

# Ejecutar el contenedor
docker run --name administracionlibros --rm -p 8080:8080 administracionlibros:1.0.1


# Guardar imagen en archivo tar
docker save -o ARTEFACTOS/administracionlibros_1.0.1.tar administracionlibros:1.0.1



# Cargar imagen de archivo tar
docker load -i ARTEFACTOS/administracionlibros_1.0.1.tar
```


### Prueba con proyecto Postman
```
Crear autores y verificar el CRUD del API de estos
```
```
Crear libros teniendo en cuenta el idAutor asociado
Continuar con la verificación de CRUD teniendo en cuenta el idLibro y idAutor asociados
```

### DEMO y prueba de ejecución
```
Ruta donde se encuentran
  - Modelo E-R de la solución
  - Proyecto Postman
  - Imagen Docker (archivo tar)
  - Jar de ejecución si se requiere

https://drive.google.com/drive/folders/1LPsNPH-ULdm32daX2uxs2gPJMCEpEpK2?usp=drive_link

```
