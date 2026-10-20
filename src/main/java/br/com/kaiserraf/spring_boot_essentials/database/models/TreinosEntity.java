package br.com.kaiserraf.spring_boot_essentials.database.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "treinos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TreinosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID Id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private AlunoEntity aluno;
    @ManyToMany
    @JoinTable(
            name = "treinos_exercicios",
            joinColumns = @JoinColumn(name = "treino_id"),
            inverseJoinColumns = @JoinColumn(name = "exercicio_id")
    )
    private Set<ExerciciosEntity> exercicios = new HashSet<>();
}