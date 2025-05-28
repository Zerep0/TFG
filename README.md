# Umugram

Este repositorio contiene la implementación completa del proyecto Umugram, que demuestra cómo realizar una integración continua con una herramienta predictora mediante el lenguaje Orion. También se proporciona un genererador de Orion a MySQL encargado de las migraciones de esquema.

# Mi proyecto

```mermaid
flowchart TD
  subgraph UMUGRAM
    subgraph GITHUB[".github/"]
      codeql["codeql/"]
      cfg["codeql-config.yml"]
      jar["generator.jar"]
      subgraph WFS["workflows/"]
        a["codeql-analysis.yml"]
        b["migration-schema.yml"]
        c["upload-sarif.yml"]
      end
    end
    subgraph ORION["orion/"]
      scripts["orion_scripts/"]
      vtxt["orion_schema_version.txt"]
      vmd["version_table.md"]
    end
    subgraph TOOLS["Tools/"]
      t1["es.um.uschema.xtext.athena.parent"]
      t2["es.um.uschema.xtext.orion.parent"]
      t3["spring.data.jpa.codeq.generator"]
      t4["uschema/"]
      t5["aa/"]
    end
    UseCase["UseCase/"]
  end

  UMUGRAM --> GITHUB
  UMUGRAM --> ORION
  UMUGRAM --> TOOLS
  UMUGRAM --> UseCase
```

