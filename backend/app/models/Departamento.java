package models;

import java.io.IOException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import play.data.validation.Required;
import play.db.jpa.GenericModel;

@Entity
@Table(schema = "sigesdp", name = "departamento")
public class Departamento extends GenericModel {
	private static final String SEQ = "sigesdp.departamento_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
	@SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
	private Long id;

	@Required
	@Column(name = "nome")
	private String nome;

	@Required
	@Column(name = "chefe")
	private String chefe;

	@Required
	@Column(name = "telefone")
	private String telefone;

	@Required
	@Column(name = "sigla")
	private String sigla;

	@Required
	@Column(name = "descricao")
	private String descricao;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getChefe() {
		return this.chefe;
	}

	public void setChefe(String chefe) {
		this.chefe = chefe;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void salvar() {
		this.save();
	}
}
