package com.ifam.sistema_estagio.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifam.sistema_estagio.model.entity.Ata;

@Repository
public interface AtaRepository extends JpaRepository<Ata, Integer>{

}
