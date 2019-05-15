package models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import play.data.validation.Required;
import play.db.jpa.GenericModel;

@Entity
@Table(schema = "sigesdp", name = "grupo_pesquisa")
public class GrupoPesquisa extends GenericModel {
	private static final String SEQ = "sigesdp.grupo_pesquisa_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
	@SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
	private Integer id;

	@Required
	@Column(name = "grupo_pesquisa")
	private String grupoPesquisa;

	@Required
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_professor", referencedColumnName = "id")
	private Professor professor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGrupoPesquisa() {
		return grupoPesquisa;
	}

	public void setGrupoPesquisa(String grupoPesquisa) {
		this.grupoPesquisa = grupoPesquisa;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public void salvar() {
		this.save();
	}
}
