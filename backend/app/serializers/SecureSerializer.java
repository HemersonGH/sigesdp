package serializers;

import flexjson.JSONSerializer;
import play.Play;
import play.Play.Mode;

public class SecureSerializer {
	public static JSONSerializer getToken;
	public static JSONSerializer setPerfilUsuario;
	public static JSONSerializer authenticate;

	static {
		boolean prettyPrint = Play.mode == Mode.DEV;

		getToken = new JSONSerializer().include("id", "email").exclude("*").prettyPrint(prettyPrint);
		authenticate = setPerfilUsuario = getToken;
	}
}
