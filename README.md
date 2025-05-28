# Umugram

Este repositorio contiene la implementación completa del proyecto Umugram, que demuestra cómo realizar una integración continua con una herramienta predictora mediante el lenguaje Orion. También se proporciona un genererador de Orion a MySQL encargado de las migraciones de esquema.

# Mi proyecto

```mermaid
flowchart TD
  ROOT["./"]:::root
  ROOT --- GITHUB[".github/"]:::folder
  ROOT --- ORION["orion/"]:::folder
  ROOT --- TOOLS["Tools/"]:::folder

  GITHUB --- codeql["codeql/"]:::folder
  GITHUB --- cfg["codeql-config.yml"]:::file
  GITHUB --- wfs["workflows/"]:::folder
  wfs   --- a["codeql-analysis.yml"]:::file
  wfs   --- b["migration-schema.yml"]:::file
  wfs   --- c["upload-sarif.yml"]:::file

  ORION --- scripts["orion_scripts/"]:::folder
  ORION --- vmd["version_table.md"]:::file

  TOOLS --- t1["es.um.uschema.xtext.athena.parent"]:::folder
  TOOLS --- t2["es.um.uschema.xtext.orion.parent"]:::folder
  TOOLS --- t3["spring.data.jpa.codeq.generator"]:::folder
  TOOLS --- t4["uschema/"]:::folder
  TOOLS --- t5["aa/"]:::folder

  classDef root   fill:#fff,stroke:#000,stroke-width:2px;
  classDef folder fill:#eef,stroke:#66f;
  classDef file   fill:#ffe,stroke:#e62;
```

