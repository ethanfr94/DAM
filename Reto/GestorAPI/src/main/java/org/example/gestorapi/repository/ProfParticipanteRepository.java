package org.example.gestorapi.repository;

import org.example.gestorapi.model.Actividad;
import org.example.gestorapi.model.ProfParticipante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfParticipanteRepository extends JpaRepository<ProfParticipante, Integer> {
    List<ProfParticipante> findProfParticipanteByActividadId(Integer actividadId);
}
