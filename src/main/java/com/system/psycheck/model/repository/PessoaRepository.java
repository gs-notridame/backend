package com.system.psycheck.model.repository;

import com.system.psycheck.model.entity.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Page<Pessoa> findAll(Pageable paginacao);
}
