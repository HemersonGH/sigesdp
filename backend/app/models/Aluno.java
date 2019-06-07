package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import play.data.validation.Required;
import play.db.jpa.GenericModel;

@Entity
@Table(schema = "sigesdp", name = "aluno")
public class Aluno extends GenericModel {

	private static final String SEQ = "sigesdp.aluno_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
	@SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
	private Integer id;

	@Required
	private String nome;

	@Required
	private String email;

	@Required
	@ManyToOne
	@JoinColumn(name = "id_professor", referencedColumnName = "id")
	private Professor professor;

	@Required
	@OneToOne
	@JoinColumn(name = "id_curso", referencedColumnName = "id")
	public Curso curso;

	@Required
	@OneToOne
	@JoinColumn(name = "id_modalidade_bolsa", referencedColumnName = "id")
	public ModalidadeBolsa modalidadeBolsa;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public ModalidadeBolsa getModalidadeBolsa() {
		return this.modalidadeBolsa;
	}

	public void setModalidadeBolsa(ModalidadeBolsa modalidadeBolsa) {
		this.modalidadeBolsa = modalidadeBolsa;
	}

	public void salvar() {
		this.setProfessor(Professor.findById(this.professor.getId()));
		this.setCurso(Curso.findById(this.curso.getId()));
		this.setModalidadeBolsa(ModalidadeBolsa.findById(this.modalidadeBolsa.getId()));

		this.save();
	}

	public void atualiza(Aluno aluno) {
		this.setNome(aluno.getNome());
		this.setEmail(aluno.getEmail());
		this.setCurso(Curso.findById(aluno.curso.getId()));
		this.setModalidadeBolsa(ModalidadeBolsa.findById(aluno.modalidadeBolsa.getId()));

		this.save();
	}

	public void remove() {
		this.delete();
	}
}
