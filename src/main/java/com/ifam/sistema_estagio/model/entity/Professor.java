package com.ifam.sistema_estagio.model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ifam.sistema_estagio.model.entity.interfaces.UsuarioLogavel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "professor")
public class Professor extends Usuario implements UsuarioLogavel {

	// Avaliadores da banca
	@OneToMany(mappedBy = "professor")
	private List<Avaliadores> avaliadores;

	// Fichas de avaliação de estágios
	@OneToMany(mappedBy = "professor")
	private List<FichaDeAvaliacaoEstagio> fichaEstagios;

	// Fichas de avaliação de projetos
	@OneToMany(mappedBy = "professor")
	private List<FichaDeAvaliacaoProjeto> fichaProjeto;

	// Projetos ou estágios
	@OneToMany(mappedBy = "responsavel")
	private List<EstagioPCCT> estagiosPcct;

	@ManyToOne
	@JoinColumn(name = "papel_id")
	private Papel papel;
}
