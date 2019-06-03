package serializers;

import flexjson.JSONSerializer;
import play.Play;
import play.Play.Mode;

public class ModalidadeBolsaSerializer {

	public static JSONSerializer modalidadesBolsa;

	static {
		boolean prettyPrint = Play.mode == Mode.DEV;

		modalidadesBolsa = new JSONSerializer().include("id", "sigla").exclude("*").prettyPrint(prettyPrint);
	}
}