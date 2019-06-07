package serializers;

import flexjson.JSONSerializer;
import play.Play;
import play.Play.Mode;

public class CursoSerializer {

	public static JSONSerializer cursos;

	static {
		boolean prettyPrint = Play.mode == Mode.DEV;

		cursos = new JSONSerializer().include("id", "nome", "departamento.id", "departamento.nome").exclude("*")
				.prettyPrint(prettyPrint);
	}
}
