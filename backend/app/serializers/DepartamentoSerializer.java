package serializers;

import java.util.Date;

import flexjson.JSONSerializer;
import play.Play;
import play.Play.Mode;

public class DepartamentoSerializer {

	public static JSONSerializer departamentosTables, departamentos, departamentosSelect;

	static {
		boolean prettyPrint = Play.mode == Mode.DEV;

		departamentosTables = new JSONSerializer().include("nome", "sigla", "chefe").exclude("*").prettyPrint(prettyPrint);

		departamentos = new JSONSerializer().include("id", "nome", "sigla", "chefe", "telefone", "descricao").exclude("*")
				.prettyPrint(prettyPrint);

		departamentosSelect = new JSONSerializer().include("id", "nome").exclude("*").prettyPrint(prettyPrint);
	}
}
