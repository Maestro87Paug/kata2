# Kata 2 - Entrada/Salida con Laptops

## Objetivo

Programa que lee un dataset de portátiles desde un InputStream (fichero o URL),
transforma cada fila en un objeto de dominio, calcula un resumen por categoría
y escribe el resultado en un OutputStream (consola o fichero).

## Cómo compilar
```bash
mvn compile
```
## Como ejecutar

Ejecutar desde la clase Main.

## Dependencias y JDK

JDK: Amazon Coretto 26
Build: Maven

Sin dependencias.

## Estructura del proyecto y clases principales
```
src/main/java/software/ulpgc/kata2/
├── Main.java                        → Punto de entrada, conecta reader + estadísticas + writer
├── model/
│   ├── Laptop.java                  → Entidad de dominio (manufacturer, modelName, category)
│   └── LaptopStatistics.java        → Calcula resumen: conteo de laptops por categoría
└── io/
├── LaptopReader.java            → Interfaz de lectura
├── UrlLaptopReader.java         → Lee desde una URL (InputStream)
├── FileLaptopReader.java        → Lee desde un fichero local (FileInputStream)
├── LaptopWriter.java            → Interfaz de escritura
├── ConsoleLaptopWriter.java     → Escribe en consola (System.out)
└── FileLaptopWriter.java        → Escribe en fichero (FileOutputStream)
```
## Dataset
CSV de https://github.com/37Degrees/DataSets/blob/master/laptops.csv