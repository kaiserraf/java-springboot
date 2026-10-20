package br.com.kaiserraf.spring_boot_essentials.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExercicioDto {

    @NotBlank
    private String name;
    private String grupoMuscular;
}
