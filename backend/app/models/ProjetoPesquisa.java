package models;

import java.util.Date;

import javax.persistence.Column;
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
@Table(schema = "sigesdp", name = "projeto_pesquisa")
public class ProjetoPesquisa extends GenericModel {

	private static final String SEQ = "sigesdp.projeto_pesquisa_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
	@SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
	private Integer id;

	@Required
	private String titulo;

	@Required
	@Column(name = "data_inicio")
	private Date dataInicio;

	@Required
	@Column(name = "data_termino")
	private Date dataTermino;

	@Required
	private String resumo;

	@Required
	private String codigo;

	// id_grupo_pesquisa

//	@Required
//	@OneToOne
//	@JoinColumn(name = "id_anexo", referencedColumnName = "id")
//	private Anexo anexo;

	@Required
	@OneToOne
	@JoinColumn(name = "id_professor", referencedColumnName = "id")
	private Professor professor;

	@Required
	@OneToOne
	@JoinColumn(name = "id_aluno", referencedColumnName = "id")
	private Aluno aluno;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return this.dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getResumo() {
		return this.resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

//	public Anexo getAnexo() {
//		return this.anexo;
//	}
//
//	public void setAnexo(Anexo anexo) {
//		this.anexo = anexo;
//	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Professor getProfessor() {
		return this.professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void salvar() {
		this.setProfessor(Professor.findById(this.getProfessor().getId()));
		this.setAluno(Aluno.findById(this.getAluno().getId()));
//		this.usuario.setSenha() 

		this.save();
	}

	public void atualiza(ProjetoPesquisa projetoPesquisa) {
		this.setTitulo(projetoPesquisa.getTitulo());
		this.setDataInicio(projetoPesquisa.getDataInicio());
		this.setDataTermino(projetoPesquisa.getDataTermino());
		this.setResumo(projetoPesquisa.getResumo());
		this.setCodigo(projetoPesquisa.getCodigo());
		this.setAluno(Aluno.findById(this.getAluno().getId()));

		this.save();
	}

	public void remove() {
		this.delete();
	}
}
