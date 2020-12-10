package com.ifam.sistema_estagio.entity;


import java.io.File;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ifam.sistema_estagio.config.IdentificadorHexadecimalGenerator;
import com.ifam.sistema_estagio.util.ManipularNumerosHexadecimais;
import com.ifam.sistema_estagio.util.enums.ModalidadeCurso;
import com.ifam.sistema_estagio.util.enums.TipoServico;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "estagio_pcct")
public class EstagioPCCT {

	@Id
	@GeneratedValue(generator = IdentificadorHexadecimalGenerator.nome)
	@GenericGenerator(
			name = IdentificadorHexadecimalGenerator.nome,
			strategy = "com.ifam.sistema_estagio.config.IdentificadorHexadecimalGenerator"
	)
	@Column(length = ManipularNumerosHexadecimais.TAMANHO_NUMERO_ALEATORIO)
	private String id;
	
	@Column(nullable = false, name = "titulo")
	private String titulo;

	@Column(nullable = false, name = "carga_horario")
	private Integer cargaHoraria;
	
	@Column(nullable = true, name = "concluido")
	private Boolean concluido;

	@Column(nullable = true, name = "local")
	private String local;
	
	@Column(nullable = true, name = "descricao")
	private String descricao;

	@Column(nullable = false, name = "tipo")
	@Enumerated(EnumType.STRING)
	private TipoServico tipo;

	@Column(nullable = false, name = "modalidade")
	@Enumerated(EnumType.STRING)
	private ModalidadeCurso modalidadeCurso;

	@Column(nullable = true, name = "anexo")
	private File anexo;

	@JsonBackReference
	@OneToMany(mappedBy = "estagioPcct")
	private List<Banca> bancas;

	@JsonBackReference
	@OneToMany(mappedBy = "estagioPcct")
	private List<Aluno> alunos;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "responsavel_id")
	private Professor responsavel;
}