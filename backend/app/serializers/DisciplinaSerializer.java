package serializers;

import flexjson.JSONSerializer;
import play.Play;
import play.Play.Mode;

public class DisciplinaSerializer {

	public static JSONSerializer disciplinasTables, disciplinas, disciplinasSelect;

	static {
		boolean prettyPrint = Play.mode == Mode.DEV;

		disciplinasTables = new JSONSerializer().include("nome", "codigo").exclude("*").prettyPrint(prettyPrint);

		disciplinas = new JSONSerializer().include("id", "nome", "codigo", "cargaHoraria", "local", "horario", "tipo")
				.exclude("*").prettyPrint(prettyPrint);

		disciplinasSelect = new JSONSerializer().include("id", "nome").exclude("*").prettyPrint(prettyPrint);
	}
}
