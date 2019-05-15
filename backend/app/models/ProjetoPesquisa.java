package models;

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
	private String dataInicio;

	@Required
	@Column(name = "data_termino")
	private String dataTermino;

	@Required
	private String resumo;

	@Required
	@Column(name = "codigo_projeto")
	private String codigoProjeto;

	// id_grupo_pesquisa
	// id_area_conhecimento
	// id_modalidade_bolsa
	// id_anexo
	// id_aluno

}
