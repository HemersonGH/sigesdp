package serializers;

import java.util.Date;

import flexjson.JSONSerializer;
import play.Play;
import play.Play.Mode;

public class DepartamentoSerializer {
	public static JSONSerializer listIten, listAll;

	static {
		boolean prettyPrint = Play.mode == Mode.DEV;

		listIten = new JSONSerializer().include("nome", "sigla", "chefe").exclude("*").prettyPrint(prettyPrint);

		listAll = new JSONSerializer().include("id", "nome", "sigla", "chefe", "telefone", "descricao").exclude("*")
				.prettyPrint(prettyPrint);
	}
}
