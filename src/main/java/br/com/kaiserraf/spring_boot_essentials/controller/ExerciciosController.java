package br.com.kaiserraf.spring_boot_essentials.controller;

import br.com.kaiserraf.spring_boot_essentials.DTOs.ExercicioDto;
import br.com.kaiserraf.spring_boot_essentials.database.models.ExerciciosEntity;
import br.com.kaiserraf.spring_boot_essentials.services.ExerciciosService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

@RestController
@RequestMapping("v1/exercicios")
@RequiredArgsConstructor
public class ExerciciosController {

    private final ExerciciosService exerciciosService;

    @GetMapping
    public ResponseEntity<List<ExerciciosEntity>> findAll(){
        return new ResponseEntity<>(exerciciosService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ExerciciosEntity> saveExercicio(@Valid @RequestBody ExercicioDto exercicioDto){
        return new ResponseEntity<>(exerciciosService.saveExercicio(exercicioDto), HttpStatus.CREATED);
    }

    @GetMapping("/grupos/{grupoMuscular}")
    public ResponseEntity<List<ExerciciosEntity>> findByGrupoMuscular(@PathVariable String grupoMuscular){
        return new ResponseEntity<>(exerciciosService.findExercicioByGrupoMuscular(grupoMuscular), HttpStatus.OK);
    }
}
