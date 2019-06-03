package serializers;

import flexjson.JSONSerializer;
import play.Play;
import play.Play.Mode;

public class ModalidadeBolsaSerializer {

	public static JSONSerializer listAll;

	static {
		boolean prettyPrint = Play.mode == Mode.DEV;

		listAll = new JSONSerializer().include("id", "sigla").exclude("*").prettyPrint(prettyPrint);
	}
}