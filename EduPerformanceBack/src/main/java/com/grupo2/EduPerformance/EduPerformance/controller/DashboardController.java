package com.grupo2.EduPerformance.EduPerformance.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api/graficos")
public class DashboardController {
        private final RestClient restClient;

    public DashboardController() {
        // URL base del microservicio analítico de Python
        this.restClient = RestClient.create("http://localhost:8000");
    }

        @GetMapping("/headless/promedio-notas-por-curso")
    public ResponseEntity<?> headlessPromedioNotasPorCurso() {
        try {
            List<?> respuesta = restClient.get()
                    .uri("/headless/promedio-notas-por-curso")
                    .retrieve()
                    .body(List.class);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(Map.of("error", "Servicio analítico no disponible."));
        }
    }

    @GetMapping("/headless/asistencia-vs-nota")
    public ResponseEntity<?> headlessAsistenciaVsNota() {
        try {
            List<?> respuesta = restClient.get()
                    .uri("/headless/asistencia-vs-nota")
                    .retrieve()
                    .body(List.class);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(Map.of("error", "Servicio analítico no disponible."));
        }
    }

    @GetMapping("/headless/rendimiento-por-profesor")
    public ResponseEntity<?> headlessRendimientoPorProfesor() {
        try {
            List<?> respuesta = restClient.get()
                    .uri("/headless/rendimiento-por-profesor")
                    .retrieve()
                    .body(List.class);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(Map.of("error", "Servicio analítico no disponible."));
        }
    }

    @GetMapping("/headless/asistencia-por-curso")
    public ResponseEntity<?> headlessAsistenciaPorCurso(
            @RequestParam(defaultValue = "10") int top) {
        try {
            List<?> respuesta = restClient.get()
                    .uri("/headless/asistencia-por-curso?top=" + top)
                    .retrieve()
                    .body(List.class);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(Map.of("error", "Servicio analítico no disponible."));
        }
    }
    
    @GetMapping("/headless/estudiantes-por-profesor")
    public ResponseEntity<?> headlessEstudiantesPorProfesor() {
        try {
            List<?> respuesta = restClient.get()
                    .uri("/headless/estudiantes-por-profesor")
                    .retrieve()
                    .body(List.class);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(Map.of("error", "Servicio analítico no disponible."));
        }
    }

    @GetMapping("/headless/cursos-por-profesor")
    public ResponseEntity<?> headlessCursosPorProfesor() {
        try {
            List<?> respuesta = restClient.get()
                    .uri("/headless/cursos-por-profesor")
                    .retrieve()
                    .body(List.class);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(Map.of("error", "Servicio analítico no disponible."));
        }
    }

    @GetMapping("/headless/cursos-por-estudiante")
    public ResponseEntity<?> headlessCursosPorEstudiante() {
        try {
            List<?> respuesta = restClient.get()
                    .uri("/headless/cursos-por-estudiante")
                    .retrieve()
                    .body(List.class);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(Map.of("error", "Servicio analítico no disponible."));
        }
    }

    @GetMapping("/headless/cursos-con-mas-estudiantes")
    public ResponseEntity<?> headlessCursosConMasEstudiantes(
            @RequestParam(defaultValue = "10") int top) {
        try {
            List<?> respuesta = restClient.get()
                    .uri("/headless/cursos-con-mas-estudiantes?top=" + top)
                    .retrieve()
                    .body(List.class);
            return ResponseEntity.ok(respuesta);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(Map.of("error", "Servicio analítico no disponible."));
        }
    }

}
