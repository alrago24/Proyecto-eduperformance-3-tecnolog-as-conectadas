# Diagrama de Base de Datos - Backend EduPerformance

Este documento describe el esquema relacional actual implementado en el backend de EduPerformance.

## Tablas principales

- **Usuario**: datos base de cada persona del sistema.
- **Perfil**: datos personales complementarios del usuario.
- **Estudiante**: rol académico con matrícula, carrera y semestre.
- **Profesor**: rol académico con departamento y especialidad.
- **Cursos**: cursos asociados a un profesor.
- **Calificaciones**: notas de estudiantes por curso y actividad.
- **Asistencias**: registro de presencia/ausencia por curso.
- **estudiante_curso**: tabla intermedia para la relación N:M entre estudiantes y cursos.

## Esquema relacional actual

![Diagrama de Base de Datos](./diagrama-base-datos.svg)

```mermaid
erDiagram
    Usuario {
        Long id PK
        String nombre
        String apellido
        Integer edad
        String email
        String password
    }
    Perfil {
        Long id PK
        String direccion
        String telefono
        Long usuario_id FK
    }
    Estudiante {
        Long id PK
        Long usuario_id FK
        String codigo
        String carrera
        Integer semestre
    }
    Profesor {
        Long id PK
        Long usuario_id FK
        String codigo
        String departamento
        String especialidad
    }
    Cursos {
        Long id PK
        String nombre
        String descripcion
        Long usuario_id FK
    }
    Calificacion {
        Long id PK
        Double nota
        Integer porcentaje
        String actividad
        LocalDate fecha
        String observacion
        Long estudiante_id FK
        Long curso_id FK
    }
    Asistencia {
        Long id PK
        LocalDate fecha
        Boolean presente
        Long estudiante_id FK
        Long curso_id FK
    }

    Usuario ||--|| Perfil : tiene
    Usuario ||--|| Estudiante : es
    Usuario ||--|| Profesor : es
    Usuario ||--o{ Cursos : dicta
    Estudiante ||--o{ Cursos : matriculado_en
    Estudiante ||--o{ Calificacion : recibe
    Cursos ||--o{ Calificacion : contiene
    Estudiante ||--o{ Asistencia : registra
    Cursos ||--o{ Asistencia : pertenece_a
```

## Relaciones clave

- `Usuario` mantiene relaciones uno a uno con `Perfil`, `Estudiante` y `Profesor`.
- `Cursos` es dictado por un `Usuario` (profesor) mediante la columna `usuario_id`.
- `Estudiante` se matricula en `Cursos` con la tabla intermedia `estudiante_curso`.
- `Calificacion` y `Asistencia` tienen referencias directas a `estudiante_id` y `curso_id`.
