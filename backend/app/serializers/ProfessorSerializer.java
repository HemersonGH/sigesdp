package serializers;

import java.util.Date;

import flexjson.JSONSerializer;
import play.Play;
import play.Play.Mode;

public class ProfessorSerializer {

	public static JSONSerializer docentesTables, docentes, docentesDetails, login, alunosDocente, disciplinasDocente,
			projetosPesquisaDocente;

	static {
		boolean prettyPrint = Play.mode == Mode.DEV;

		docentesTables = new JSONSerializer().include("id", "nome", "departamento.nome", "departamento.sigla")
				.exclude("*").prettyPrint(prettyPrint);

		docentes = new JSONSerializer()
				.include("id", "nome", "curriculoLattes", "formacaoAcademica", "sala", "telefone", "usuario.id",
						"usuario.email", "departamento.id", "departamento.nome", "departamento.sigla",
						"areaConhecimento.id", "areaConhecimento.nome", "disciplinas.id", "disciplinas.codigo",
						"disciplinas.nome", "disciplinas.cargaHoraria", "disciplinas.local", "disciplinas.horario",
						"disciplinas.tipo", "alunos.id", "alunos.nome", "alunos.email", "alunos.curso.id",
						"alunos.curso.nome", "alunos.modalidadeBolsa.id", "alunos.modalidadeBolsa.nome",
						"alunos.modalidadeBolsa.sigla", "projetosPesquisa.id", "projetosPesquisa.titulo",
						"projetosPesquisa.dataInicio", "projetosPesquisa.dataTermino", "projetosPesquisa.resumo",
						"projetosPesquisa.codigo", "projetosPesquisa.aluno.id", "projetosPesquisa.aluno.nome",
						"projetosPesquisa.aluno.curso.nome", "projetosPesquisa.aluno.curso.departamento.nome",
						"projetosPesquisa.aluno.curso.departamento.sigla", "projetosPesquisa.aluno.modalidadeBolsa.id",
						"projetosPesquisa.aluno.modalidadeBolsa.nome", "projetosPesquisa.aluno.modalidadeBolsa.sigla")
				.transform(new DateSerializer().getTransformer(), Date.class).exclude("*").prettyPrint(prettyPrint);

		docentesDetails = new JSONSerializer()
				.include("id", "nome", "curriculoLattes", "formacaoAcademica", "sala", "telefone", "departamento.id",
						"departamento.nome", "departamento.sigla", "usuario.id", "usuario.email", "disciplinas.id",
						"disciplinas.codigo", "disciplinas.nome", "disciplinas.cargaHoraria", "disciplinas.local",
						"disciplinas.horario", "disciplinas.tipo", "areaConhecimento.id", "areaConhecimento.nome")
				.exclude("*").prettyPrint(prettyPrint);

		login = new JSONSerializer().include("id", "nome", "usuario.id", "usuario.email").exclude("*")
				.prettyPrint(prettyPrint);

		alunosDocente = new JSONSerializer()
				.include("id", "nome", "alunos.id", "alunos.nome", "alunos.email", "alunos.professor.nome",
						"alunos.professor.id", "alunos.curso.id", "alunos.curso.nome", "alunos.modalidadeBolsa.id",
						"alunos.modalidadeBolsa.nome", "alunos.modalidadeBolsa.sigla")
				.exclude("*").prettyPrint(prettyPrint);

		disciplinasDocente = new JSONSerializer().include("id", "nome", "disciplinas.id", "disciplinas.nome",
				"disciplinas.codigo", "disciplinas.cargaHoraria", "disciplinas.local", "disciplinas.horario",
				"disciplinas.tipo", "disciplinas.departamento.id", "disciplinas.departamento.nome",
				"disciplinas.departamento.sigla").exclude("*").prettyPrint(prettyPrint);

		projetosPesquisaDocente = new JSONSerializer()
				.include("id", "nome", "usuario.email", "areaConhecimento.id", "areaConhecimento.nome",
						"projetosPesquisa.id", "projetosPesquisa.titulo", "projetosPesquisa.dataInicio",
						"projetosPesquisa.dataTermino", "projetosPesquisa.resumo", "projetosPesquisa.codigo",
						"projetosPesquisa.aluno.id", "projetosPesquisa.aluno.nome", "projetosPesquisa.aluno.curso.nome",
						"projetosPesquisa.aluno.curso.departamento.nome",
						"projetosPesquisa.aluno.curso.departamento.sigla")
				.transform(new DateSerializer().getTransformer(), Date.class).exclude("*").prettyPrint(prettyPrint);
	}
}
