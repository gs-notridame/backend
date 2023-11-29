package com.system.psycheck.model.repository;

import com.system.psycheck.model.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
