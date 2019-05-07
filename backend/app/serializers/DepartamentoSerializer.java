package serializers;

import java.util.Date;

import flexjson.JSONSerializer;
import play.Play;
import play.Play.Mode;

public class DepartamentoSerializer {
	public static JSONSerializer save;

	static {
		boolean prettyPrint = Play.mode == Mode.DEV;

		save = new JSONSerializer().include("id", "nome", "chefe", "telefone", "sigla", "descricao").exclude("*")
				.prettyPrint(prettyPrint);
	}

}
