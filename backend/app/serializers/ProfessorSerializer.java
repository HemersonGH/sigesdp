package serializers;

import flexjson.JSONSerializer;
import play.Play;
import play.Play.Mode;

public class ProfessorSerializer {
	public static JSONSerializer findAllPaginated, create;

	static {
		boolean prettyPrint = Play.mode == Mode.DEV;

		create = findAllPaginated = new JSONSerializer()
			.include(
				"id",
				"login",
				"ativo",
				"pessoa.id",
				"pessoa.nome",
				"pessoa.pessoaFisica",
				"perfis.id",
				"perfis.nome",
				"perfis.codigo",
				"perfis.modulo"
			)
			.exclude("*").prettyPrint(prettyPrint);
	}

}
