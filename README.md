# Umugram

Este repositorio contiene la implementación completa del proyecto Umugram, que demuestra cómo realizar una integración continua con una herramienta predictora mediante el lenguaje Orion. También se proporciona un genererador de Orion a MySQL encargado de las migraciones de esquema.
.
├── .github
│   ├── codeql
│   │   ├── codeql-config.yml       ← Configuración genérica de CodeQL
│   │   └── generator.jar           ← Biblioteca para M2T (Orion→CodeQL)
│   └── workflows
│       ├── codeql-analysis.yml     ← GitHub Action: análisis estático con CodeQL
│       ├── migration-schema.yml    ← GitHub Action: versionado de esquemas con Orion
│       └── upload-sarif.yml        ← GitHub Action: subida de resultados SARIF
├── orion
│   ├── orion_scripts              ← Scripts de migración `.orion` (vX_…)
│   ├── orion_schema_version.txt   ← Control de la última versión de esquema
│   └── version_table.md           ← Historial de versiones en formato Markdown
├── Tools
│   ├── es.um.uschema.xtext.athena.parent   ← Gramática Athena (Xtext)
│   ├── es.um.uschema.xtext.orion.parent     ← Gramática Orion (Xtext)
│   ├── spring.data.jpa.codeql.generator    ← M2T (Orion→JPA/@Query + CodeQL)
│   └── uschema                              ← Metamodelo U-Schema (Ecore)
└── usecase
    ├── src
    │   └── main/java/...            ← Código de ejemplo (Spring Boot + JPA)
    └── pom.xml                      ← POM Maven del backend

