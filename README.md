# Kata 2

## Objetivo
Leer datos de portátiles desde distintos orígenes mediante InputStream,
convertir las filas en objetos y calcular un resumen por categoría.

Escribir el resultado en distintos destinos mediante OutputStream.

## Ejecución
Abre el proyecto en IntelliJ y ejecuta la clase Main.

La versión final utiliza URL y memoria como orígenes de entrada.
El resumen se muestra en consola y se guarda en resultado.txt.

Es necesaria conexión a Internet para leer desde la URL.

## JDK y dependencias
Versión 26.
Build: Maven.

Ninguna dependencia externa utilizada.

## Cómo compilar y ejecutar
Desde la raíz del proyecto:

```bash
mvn compile
java -cp target/classes software.ulpgc.kata2.Main
```

También se puede ejecutar desde la clase Main en IntelliJ.

## Estructura de la entrega y clases principales
- Código fuente: src/main/java/software/ulpgc/kata2.
- Paquete: software.ulpgc.kata2.
- Laptop: Representa un portátil con fabricante, modelo y categoría.
- LaptopStatistics: Calcula el número de portátiles por categoría.
- LaptopReader: Interfaz de lectura mediante InputStream.
- CsvLaptopReader: Lee el CSV y transforma las filas en objetos Laptop.
- LaptopWriter: Interfaz de escritura mediante OutputStream.
- TextLaptopWriter: Escribe el resumen en el destino recibido.
- Main: Conecta la lectura, el cálculo del resumen y la escritura.

La lógica de estadísticas no depende del origen ni del destino.
Los streams se abren y cierran desde Main.

## Dataset
Fichero local: src/main/resources/laptops.csv.

Origen:
https://github.com/37Degrees/DataSets/blob/master/laptops.csv

Se utilizan las columnas Manufacturer, Model Name y Category.
El lector salta la cabecera e ignora las líneas vacías.

Las comas dentro de comillas forman parte del campo.
Por ejemplo, "Lapbook 15,6" se interpreta como un único modelo.

El lector está preparado para un registro por línea.
No admite saltos de línea dentro de un campo entrecomillado.

## Tratamiento de errores
Si una fila tiene menos de tres columnas, campos obligatorios
vacíos o comillas sin cerrar, se detiene la lectura y se muestra
un mensaje de error.

Los errores de acceso al fichero, a la URL o al destino de salida
se muestran desde Main.

Una entrada vacía produce una colección vacía y un total de cero.

## Git
Las repeticiones se organizan en first-repetition,
second-repetition y third-repetition.

Cada repetición se integra en develop y después en master.
La rama master contiene la versión final de la entrega.

Los commits permiten localizar la implementación inicial
y las tres repeticiones.

## Cambios realizados
- Unifiqué la lectura en CsvLaptopReader.
- Utilicé InputStream para cambiar el origen sin duplicar el lector.
- Unifiqué la escritura en TextLaptopWriter.
- Utilicé OutputStream para cambiar el destino.
- Separé las estadísticas de la lectura y escritura.
- Añadí el tratamiento de comas dentro de comillas.
- Añadí mensajes para filas incorrectas y errores de entrada/salida.
- Utilicé try-with-resources para cerrar los streams.

## Implementación inicial
Lectura desde fichero y URL.
Cálculo del número de portátiles por categoría.
Escritura del resumen en consola y fichero.

## Repeticiones
En las tres repeticiones se mantiene el mismo objetivo y la misma
estructura: lector, entidad, estadísticas y escritor.

### Primera repetición
Rama: first-repetition.


Reconstrucción del ejercicio utilizando fichero y memoria
como orígenes de entrada.

Los datos en memoria se leen mediante ByteArrayInputStream.
El resumen se escribe en consola y en ByteArrayOutputStream.



### Segunda repetición
Rama: second-repetition.

Reconstrucción del ejercicio utilizando fichero y un recurso
del proyecto como orígenes de entrada.

El recurso se obtiene mediante getResourceAsStream.
El resumen se escribe en consola y fichero.


### Tercera repetición
Rama: third-repetition.

Reconstrucción del ejercicio utilizando URL y memoria
como orígenes de entrada.

Se comparan los resúmenes de ambos orígenes.
El resultado se escribe en consola y fichero.


## Ejemplo de salida
Para la copia del dataset incluida en el proyecto,
los conteos esperados son:

```text
2 in 1 Convertible: 121
Gaming: 205
Netbook: 25
Notebook: 727
Ultrabook: 196
Workstation: 29

Total: 1303 laptops
```



## Verificación

Para comparar dos orígenes se utiliza el mismo conjunto de datos.
La copia remota puede cambiar y producir diferencias con la local.

## Vídeo

