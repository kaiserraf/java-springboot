package br.com.kaiserraf.spring_boot_essentials.services;

import br.com.kaiserraf.spring_boot_essentials.DTOs.ExercicioDto;
import br.com.kaiserraf.spring_boot_essentials.database.models.ExerciciosEntity;
import br.com.kaiserraf.spring_boot_essentials.database.repository.IExerciciosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ExerciciosService {

    private final IExerciciosRepository exerciciosRepository;

    public List<ExerciciosEntity> findAll(){
        return exerciciosRepository.findAll();
    }

    public ExerciciosEntity saveExercicio(ExercicioDto exercicioDto){
        ExerciciosEntity exercicio = ExerciciosEntity.builder()
                        .name(exercicioDto.getName())
                        .grupoMuscular(exercicioDto.getGrupoMuscular())
                .build();

        exerciciosRepository.save(exercicio);

        return exercicio;
    }

    public List<ExerciciosEntity> findExercicioByGrupoMuscular(String grupoMuscular){
        return exerciciosRepository.findAllByGrupoMuscular(grupoMuscular);
    }
}
