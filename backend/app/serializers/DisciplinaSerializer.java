package serializers;

import flexjson.JSONSerializer;
import play.Play;
import play.Play.Mode;

public class DisciplinaSerializer {

	public static JSONSerializer listIten, listAll, listSelect;

	static {
		boolean prettyPrint = Play.mode == Mode.DEV;

		listIten = new JSONSerializer().include("nome", "sigla", "chefe").exclude("*").prettyPrint(prettyPrint);

		listAll = new JSONSerializer().include("id", "nome", "sigla", "chefe", "telefone", "descricao").exclude("*")
				.prettyPrint(prettyPrint);

		listSelect = new JSONSerializer().include("id", "nome").exclude("*").prettyPrint(prettyPrint);
	}
}
