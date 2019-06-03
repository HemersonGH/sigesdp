package serializers;

import flexjson.JSONSerializer;
import play.Play;
import play.Play.Mode;

public class ProfessorSerializer {

	public static JSONSerializer docentesTables, docentes, docentesDetails;

	static {
		boolean prettyPrint = Play.mode == Mode.DEV;

		docentesTables = new JSONSerializer().include("id", "nome", "departamento.nome", "departamento.sigla")
				.exclude("*").prettyPrint(prettyPrint);

		docentes = new JSONSerializer().include("id", "nome", "curriculoLates", "formacaoAcademica", "sala", "telefone",
				"usuario.id", "usuario.email", "departamento.id", "departamento.nome", "departamento.sigla",
				"areaConhecimento.id", "areaConhecimento.nome", "disciplinas.id", "disciplinas.codigo",
				"disciplinas.nome", "disciplinas.cargaHoraria", "disciplinas.local", "disciplinas.horario",
				"disciplinas.tipo", "alunos.id", "alunos.nome", "alunos.email", "alunos.curso.id", "alunos.curso.nome",
				"alunos.modalidadeBolsa.id", "alunos.modalidadeBolsa.nome", "alunos.modalidadeBolsa.sigla").exclude("*")
				.prettyPrint(prettyPrint);

		docentesDetails = new JSONSerializer()
				.include("id", "nome", "curriculoLates", "formacaoAcademica", "sala", "telefone", "departamento.id",
						"departamento.nome", "departamento.sigla", "usuario.id", "usuario.email", "disciplinas.id",
						"disciplinas.codigo", "disciplinas.nome", "disciplinas.cargaHoraria", "disciplinas.local",
						"disciplinas.horario", "disciplinas.tipo", "areaConhecimento.id", "areaConhecimento.nome")
				.exclude("*").prettyPrint(prettyPrint);
	}
}
