package br.com.kaiserraf.spring_boot_essentials.database.repository;

import br.com.kaiserraf.spring_boot_essentials.database.models.AlunoEntity;
import br.com.kaiserraf.spring_boot_essentials.database.models.ExerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IAlunosRepository extends JpaRepository<AlunoEntity, UUID> {
}
