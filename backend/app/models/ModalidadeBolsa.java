package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import play.data.validation.Required;
import play.db.jpa.GenericModel;

@Entity
@Table(schema = "sigesdp", name = "modalidade_bolsa")
public class ModalidadeBolsa extends GenericModel {

	private static final String SEQ = "sigesdp.modalidade_bolsa_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
	@SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
	private Integer id;

	@Required
	private String nome;
	
	@Required
	private String sigla;

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
	
	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public void salvar() {
		this.save();
	}
}
