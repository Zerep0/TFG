# Umugram

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

3. **Herramientas M2T** (`Tools/`)  
   - **Athena & Orion** (Xtext): DSLs para esquema prescriptivo y operaciones  
   - **CodeQL Generator**: convierte Orion → JPQL/@Query anotadas → consultas CodeQL  
   - **U-Schema**: metamodelo unificado relacional/NoSQL  

4. **Caso de uso** (`usecase/`)  
   - Aplicación de ejemplo en Java/Spring Boot con Spring Data JPA

# Como ejecutar herramienta M2T a MySQL

# Como ejecutar workflows junto con Orion
  
# Authors

- [@Zerep0](https://www.github.com/Zerep0)



