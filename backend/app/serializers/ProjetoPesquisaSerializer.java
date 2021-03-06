package serializers;

import java.util.Date;

import flexjson.JSONSerializer;
import play.Play;
import play.Play.Mode;

public class ProjetoPesquisaSerializer {

	public static JSONSerializer projetosPesquisa;

	static {
		boolean prettyPrint = Play.mode == Mode.DEV;

		projetosPesquisa = new JSONSerializer()
				.include("id", "titulo", "dataInicio", "dataTermino", "resumo", "codigo", "aluno.id", "aluno.nome",
						"aluno.curso.nome", "aluno.curso.departamento.nome", "aluno.curso.departamento.sigla",
						"aluno.modalidadeBolsa.id", "aluno.modalidadeBolsa.nome", "aluno.modalidadeBolsa.sigla",
						"professor.id", "professor.nome", "professor.usuario.email", "professor.areaConhecimento.id",
						"professor.areaConhecimento.nome")
				.transform(new DateSerializer().getTransformer(), Date.class).exclude("*").prettyPrint(prettyPrint);
	}
}
