package serializers;

import java.util.Date;

import flexjson.JSONSerializer;
import play.Play;
import play.Play.Mode;

public class DepartamentoSerializer {
	public static JSONSerializer listAllToTable, getDetails;

	static {
		boolean prettyPrint = Play.mode == Mode.DEV;

		listAllToTable = new JSONSerializer().include("nome", "sigla", "chefe").exclude("*")
				.prettyPrint(prettyPrint);
		
		getDetails = new JSONSerializer().include("nome", "sigla", "chefe", "telefone", "descricao").exclude("*")
				.prettyPrint(prettyPrint);
	}

}
