package serializers;

import java.util.Date;

import flexjson.JSONSerializer;
import play.Play;
import play.Play.Mode;

public class DepartamentoSerializer {
	public static JSONSerializer getAll;

	static {
		boolean prettyPrint = Play.mode == Mode.DEV;

		getAll = new JSONSerializer().include("nome", "chefe", "sigla").exclude("*")
				.prettyPrint(prettyPrint);
	}

}
