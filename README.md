# Umugram

Este repositorio contiene la implementación completa del proyecto Umugram, que demuestra cómo realizar una integración continua con una herramienta predictora mediante el lenguaje Orion. También se proporciona un genererador de Orion a MySQL encargado de las migraciones de esquema.

# Mi proyecto

```mermaid
flowchart TD
  A[Inicio] --> B{¿Usuario logueado?}
  B -- Sí --> C[Dashboard]
  B -- No  --> D[Login]
  D --> E[Registro]
  C --> F[Perfil]
  C --> G[Configuración]
```

