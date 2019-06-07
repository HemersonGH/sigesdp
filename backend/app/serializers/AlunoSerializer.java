package serializers;

import flexjson.JSONSerializer;
import play.Play;
import play.Play.Mode;

public class AlunoSerializer {

	public static JSONSerializer alunos, alunosFiltro;

	static {
		boolean prettyPrint = Play.mode == Mode.DEV;

		alunos = new JSONSerializer()
				.include("id", "nome", "email", "professor.id", "professor.nome", "curso.id", "curso.nome",
						"modalidadeBolsa.id", "modalidadeBolsa.nome", "modalidadeBolsa.sigla")
				.exclude("*").prettyPrint(prettyPrint);

		alunosFiltro = new JSONSerializer()
				.include("id", "nome", "email", "professor.nome", "professor.id", "curso.id", "curso.nome",
						"modalidadeBolsa.id", "modalidadeBolsa.nome", "modalidadeBolsa.sigla")
				.exclude("*").prettyPrint(prettyPrint);
	}
}
