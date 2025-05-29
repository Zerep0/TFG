# TFG

Este repositorio contiene la implementación completa del proyecto Umugram, que demuestra cómo realizar una integración continua con una herramienta predictora mediante el lenguaje Orion. También se proporciona un genererador de Orion a MySQL encargado de las migraciones de esquema.

# Mi proyecto

- 📁 **.github**
  - 📁 codeql
  - 📄 codeql-config.yml
  - 📁 workflows
    - 📄 codeql-analysis.yml
    - 📄 migration-schema.yml
    - 📄 upload-sarif.yml
- 📁 **orion**
  - 📁 orion_scripts
  - 📄 version_table.md
  - 📄 orion_schema_version.txt
- 📁 **Tools**
  - 📁 es.um.uschema.xtext.athena.parent
  - 📁 es.um.uschema.xtext.orion.parent
  - 📁 spring.data.jpa.codeq.generator
  - 📁 uschema


# Componentes principales

1. **Integración continua** (`.github/workflows/`)  
   - `migration-schema.yml`: gestion de la tabla de versiones
   - `codeql-analysis.yml`: genera AST de Java y analiza con CodeQL  
   - `upload-sarif.yml`: sube resultados SARIF a code-scanning  

2. **Migraciones Orion** (`orion/`)  
   - `orion_scripts/`: scripts de migración nombrados `V{n}_{descripción}.orion`  
   - `orion_schema_version.txt`: controla la última versión aplicada  
   - `version_table.md`: tabla de versiones según convención Flyway  

3. **Herramientas M2T** (`tools/`)  
   - **Athena & Orion** (Xtext): DSLs para esquema prescriptivo y operaciones  
   - **CodeQL Generator**: convierte Orion → JPQL/@Query anotadas → consultas CodeQL  
   - **U-Schema**: metamodelo unificado relacional/NoSQL  

4. **Caso de uso** (`UseCase/`)  
   - Aplicación sencilla de ejemplo en Java/Spring Boot con Spring Data JPA

# Como ejecutar herramienta M2T a MySQL

1. Se debe instalar desde la página oficial de eclipse el paquete modeling tools: [Modeling Tools](https://www.eclipse.org/downloads/packages/release/2024-12/r/eclipse-modeling-tools) 

2. Una vez instalado, se deben instalar las siguientes dependencias desde eclipse marketplace:
   - [Xtext](https://marketplace.eclipse.org/content/xtext)
   - [maven2ecore](https://download.eclipse.org/technology/m2e/releases/2.8.0) Esta versión se debe instalar desde install new software, ya que no está disponible en el marketplace.

3. Importar los siguientes proyectos:
   - `es.um.uschema.xtext.orion.parent` 
   - `es.um.uschema.xtext.athena.parent`
   - `uschema`

4. Una vez importados, para los proyectos Xtext de Athena y Orion, se debe acceder al paquete con el mismo nombre del proyecto y ejecutar el archivo **Generate(Athena|Orion).mwe2**. El paso se procederá a realizar con errores, el código se construirá y se generarán los archivos necesarios para la herramienta. Se deben compilar ambos, primero el de Athena y luego el de Orion.

5. Una vez instalado, el método de entrada se encuentra dentro del proyecto `es.um.uschema.xtext.orion`:
   - `src/main/java/es/um/uschema/xtext/orion/Orion2MySQLMain.java`

6. En los argumentos se especifica el fichero de entrada y de salida en los argumentos:
   ```java
   val customArgs = newArrayList("-i", "models/sql/Umugram.orion", "-o", "models/sql/code-generated")
   ```

# Como ejecutar workflows junto con Orion

1. Se debe crear un fichero orion y colocarlo en la raiz del repositorio, por ejemplo `Umugram.orion`.
   ```txt
   ADD ENTITY User {
      +id: Long,
      name: String,
      !email: String
   }
   ```
2. Se debe de subir el fichero mostrando en el commit la cabecera de mensaje con el nombre idéntico al del fichero orion, por ejemplo `Umugram`. Es decir:
   ```bash
   git add Umugram.orion
   git commit -m "Umugram.orion"
   git push origin main
   ```
3. Una vez subido, los cambios apareceran minutos después en la sección de Github > Security > Code Scanning, donde se podrá ver el resultado de la ejecución del workflow `codeql-analysis.yml`.

4. Para tomar una decisión, existen dos mensajes posibles tras este paso. La cabecera debe de ser vacia (--allow-empty):
- orion(accept): nombre_fichero.orion, descripcion
- orion(cancel): nombre_fichero.orion

5. Envio de los casos: 
- Caso de aceptación. 
   ```bash
   git add Umugram.orion
   git commit --allow-empty "orion(accept): Umugram.orion, descripcion"
   git push origin main
   ```
- Caso de cancelación.
   ```bash
   git add Umugram.orion
   git commit --allow-empty "orion(cancel): Umugram.orion"
   git push origin main
   ```

# Authors

- [@Zerep0](https://www.github.com/Zerep0)



