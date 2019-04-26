package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import play.data.validation.Required;

@Entity
@Table(schema = "sigesdp", name = "aluno")
public class Aluno {

	private static final String SEQ = "sigesdp.aluno_id_seq";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ)
	@SequenceGenerator(name = SEQ, sequenceName = SEQ, allocationSize = 1)
	private Long id;

	private String nome;

	private String email;

	@Required
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_professor", referencedColumnName = "id")
	private Professor professor;

}
