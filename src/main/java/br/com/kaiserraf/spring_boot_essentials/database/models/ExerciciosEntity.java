package br.com.kaiserraf.spring_boot_essentials.database.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "exercicios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExerciciosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    @Column(nullable = false)
    private String name;
    @Column(name = "grupo_muscular", nullable = false)
    private String grupoMuscular;
}
