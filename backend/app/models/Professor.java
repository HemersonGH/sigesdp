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
import play.data.validation.Validation;
import play.db.jpa.GenericModel;

import exceptions.ValidationException;

@Entity
@Table(schema = "sigesdp", name = "professor")
public class Professor extends GenericModel {
	private static final String SEQ = "sigesdp.professor_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
	@SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
	private Long id;
	
	@Required
	private String nome;

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

	@Required
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_departamento", referencedColumnName = "id")
	private Departamento departamento;

	@Required
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Usuario usuario;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "professor", targetEntity = Aluno.class)
	private List<Aluno> alunos;

	public void salvar(Professor professor) {
		this._save();
	}
	
//	public void validate() {
//		Validation.current().clear();
//
//		if(!Validation.current().valid(this).ok) {
//			throw new ValidationException(Validation.current().errors());
//		}
//	}
//
//
//	public static Professor createByProfessor(Professor professor) {
//		Usuario usuario = new Usuario();
//		
//		usuario = professor.usuario;
//		
//		
//		return professor;
//	}
	
	
	
}
