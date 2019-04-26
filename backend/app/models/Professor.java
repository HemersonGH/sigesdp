package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import play.data.validation.Required;

@Entity
@Table(schema = "sigesdp", name = "professor")
public class Professor {

	private static final String SEQ = "sigesdp.professor_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
	@SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
	private Long id;

	@Required
	@Column(name = "curriculo_lates")
	private String curriculoLates;

	@Required
	@Column(name = "area_interesse")
	private String areaInteresse;

	@Required
	@Column(name = "formacao_academica")
	private String formacaoAcademica;

	@Required
	private String telefone;

//	private Long id_departamento;

	@Required
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuario;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "professor", targetEntity = Aluno.class)
	private List<Aluno> alunos;
	
}
