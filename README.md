# Umugram

Este repositorio contiene la implementación completa del proyecto Umugram, que demuestra cómo realizar una integración continua con una herramienta predictora mediante el lenguaje Orion. También se proporciona un genererador de Orion a MySQL encargado de las migraciones de esquema.

# Mi proyecto

```mermaid
flowchart TD
  subgraph UMUGRAM
    subgraph .github
      codeql["codeql/"]
      cfg["codeql-config.yml"]
      jar["generator.jar"]
      workflows["workflows/"]
    end
    subgraph workflows
      a["codeql-analysis.yml"]
      b["migration-schema.yml"]
      c["upload-sarif.yml"]
    end
    subgraph orion
      scripts["orion_scripts/"]
      vtxt["orion_schema_version.txt"]
      vmd["version_table.md"]
    end
    subgraph Tools
      t1["es.um.uschema.xtext.athena.parent"]
      t2["es.um.uschema.xtext.orion.parent"]
      t3["spring.data.jpa.codeq.generator"]
      t4["uschema/"]
      t5["aa/"]
    end
    subgraph UseCase
      /* …vacío… */
    end
    
    UMUGRAM --> .github
    UMUGRAM --> orion
    UMUGRAM --> Tools
    UMUGRAM --> UseCase
    
    .github --> codeql
    .github --> cfg
    .github --> jar
    .github --> workflows
    
    workflows --> a
    workflows --> b
    workflows --> c
    
    orion --> scripts
    orion --> vtxt
    orion --> vmd
    
    Tools --> t1
    Tools --> t2
    Tools --> t3
    Tools --> t4
    Tools --> t5
```

