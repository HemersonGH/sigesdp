package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import play.data.validation.Required;
import play.db.jpa.GenericModel;

@Entity
@Table(schema = "sigesdp", name = "disciplina")
public class Disciplina extends GenericModel {

	private static final String SEQ = "sigesdp.disciplina_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
	@SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
	private Integer id;

	@Required
	private String nome;

	@Required
	private String codigo;

	@Required
	@Column(name = "carga_horaria")
	private String cargaHoraria;

	@Required
	private String local;

	@Required
	private String horario;

	@Required
	private Integer tipo;

	@Required
	@OneToOne
	@JoinColumn(name = "id_professor", referencedColumnName = "id")
	public Professor professor;

	@Required
	@OneToOne
	@JoinColumn(name = "id_departamento", referencedColumnName = "id")
	public Departamento departamento;

	public Integer getId() {
		return id;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public void salvar() {
		this.professor = Professor.findById(this.professor.getId());
		this.departamento = Departamento.findById(this.departamento.getId());

		this.save();
	}

	public void atualiza(Disciplina disciplina) {
		this.setNome(disciplina.nome);
		this.setCodigo(disciplina.codigo);
		this.setCargaHoraria(disciplina.cargaHoraria);
		this.setLocal(disciplina.local);
		this.setHorario(disciplina.horario);
		this.setTipo(disciplina.tipo);
		this.setDepartamento(Departamento.findById(disciplina.departamento.getId()));
		
		this.save();
	}
	
	public void remove() {
		this.delete();
	}
}
