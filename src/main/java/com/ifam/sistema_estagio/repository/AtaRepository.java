package com.ifam.sistema_estagio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ifam.sistema_estagio.entity.Ata;
import com.ifam.sistema_estagio.entity.Banca;

@Repository
public interface AtaRepository extends JpaRepository<Ata, String>{
	Optional<Ata> findByBanca(Banca banca);
}
