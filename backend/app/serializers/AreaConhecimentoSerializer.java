package serializers;

import flexjson.JSONSerializer;
import play.Play;
import play.Play.Mode;

public class AreaConhecimentoSerializer {

	public static JSONSerializer areasConhecimento;

	static {
		boolean prettyPrint = Play.mode == Mode.DEV;

		areasConhecimento = new JSONSerializer().include("id", "nome").exclude("*").prettyPrint(prettyPrint);
	}
}