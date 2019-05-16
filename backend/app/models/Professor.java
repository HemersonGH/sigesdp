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
	public static final String SEQ = "sigesdp.professor_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
	@SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
	public Integer id;

	@Required
	public String nome;

	@Required
	@Column(name = "curriculo_lates")
	public String curriculoLates;

	@Required
	@Column(name = "area_interesse")
	public String areaInteresse;

	@Required
	@Column(name = "formacao_academica")
	public String formacaoAcademica;

	@Required
	public String sala;

	@Required
	public String telefone;

//	@Required
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id_departamento", referencedColumnName = "id")
//	public Departamento departamento;
	
	@Required	
	@Column(name = "id_departamento")
	public Integer idDepartamento;

	@Required
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	public Usuario usuario;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "professor", targetEntity = Aluno.class)
	public List<Aluno> alunos;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurriculoLates() {
		return this.curriculoLates;
	}

	public void setCurriculoLates(String curriculoLates) {
		this.curriculoLates = curriculoLates;
	}

	public String getAreaInteresse() {
		return this.areaInteresse;
	}

	public void setAreaInteresse(String areaInteresse) {
		this.areaInteresse = areaInteresse;
	}

	public String getFormacaoAcademica() {
		return this.formacaoAcademica;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getSala() {
		return this.sala;
	}

	public void setFormacaoAcademica(String formacaoAcademica) {
		this.formacaoAcademica = formacaoAcademica;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

//	public Departamento getDepartamento() {
//		return this.departamento;
//	}
//
//	public void setDepartamento(Departamento departamento) {
//		this.departamento = departamento;
//	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
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

	public void salvar() {
		this.save();
	}
}
