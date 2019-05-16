package serializers;

import flexjson.JSONSerializer;
import play.Play;
import play.Play.Mode;

public class ProfessorSerializer {
	public static JSONSerializer getProfessor;

	static {
		boolean prettyPrint = Play.mode == Mode.DEV;

		getProfessor = new JSONSerializer().include("id", "nome", "curriculoLates", "areaInteresse",
				"formacaoAcademica", "sala", "telefone", "idDepartamento", "usuario.id", "usuario.email").exclude("*")
				.prettyPrint(prettyPrint);
	}
}
