package serializers;

import flexjson.JSONSerializer;
import play.Play;
import play.Play.Mode;

public class ProfessorSerializer {
	public static JSONSerializer listIten, listAll, listDetails;

	static {
		boolean prettyPrint = Play.mode == Mode.DEV;

		listIten = new JSONSerializer().include("id", "nome", "departamento.nome", "departamento.sigla").exclude("*")
				.prettyPrint(prettyPrint);

		listAll = new JSONSerializer()
				.include("id", "nome", "curriculoLates", "areaConhecimento.id", "areaConhecimento.nome", "formacaoAcademica", "sala", "telefone",
						"departamento.id", "departamento.nome", "departamento.sigla", "usuario.id", "usuario.email")
				.exclude("*").prettyPrint(prettyPrint);

		listDetails = new JSONSerializer().include("id", "nome", "curriculoLates", "formacaoAcademica",
				"sala", "telefone", "departamento.id", "departamento.nome", "departamento.sigla", "usuario.id",
				"usuario.email", "disciplinas.id", "disciplinas.codigo", "disciplinas.nome", "disciplinas.cargaHoraria", "disciplinas.local",
				"disciplinas.horario", "disciplinas.tipo", "areaConhecimento.id", "areaConhecimento.nome").exclude("*").prettyPrint(prettyPrint);
	}
}
