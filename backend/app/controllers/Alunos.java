package controllers;

import java.util.List;

import javax.validation.ValidationException;

import models.Aluno;
import models.Professor;
import serializers.AlunoSerializer;
import serializers.ProfessorSerializer;
import utils.MessagesUtil;

public class Alunos extends DefaultController {

	public static void cadastraAluno(Aluno aluno) {
//		validateParameters(aluno);
		aluno.salvar();

		renderText(MessagesUtil.ALUNO_CADASTRADO_COM_SUCESSO);
	}

	public static void findAll() {
		List<Aluno> alunos = Aluno.findAll();

		if (alunos == null) {
			throw new ValidationException(MessagesUtil.ALUNOS_NAO_ENCONTRADOS);
		}

		renderJSON(alunos, AlunoSerializer.alunos);
	}

	public static void findById(Integer id) {
		if (id == null) {
			throw new ValidationException(MessagesUtil.ALUNO_NAO_ENCONTRADO);
		}

		Aluno aluno = Aluno.findById(id);

		if (aluno == null) {
			throw new ValidationException(MessagesUtil.ID_ALUNO_NAO_ENCONTRADO);
		}

		renderJSON(aluno, AlunoSerializer.alunos);
	}

	public static void atualizaAluno(Aluno aluno) {
		notFoundIfNull(aluno);

		Aluno alunoSave = Aluno.findById(aluno.getId());

		if (alunoSave == null) {
			throw new ValidationException(MessagesUtil.ALUNO_NAO_ENCONTRADO);
		}

		alunoSave.atualiza(aluno);

		renderText(MessagesUtil.ALUNO_ATUALIZADO_COM_SUCESSO);
	}

	public static void removeAluno(Integer id) {
		Aluno aluno = Aluno.findById(id);

		notFoundIfNull(aluno);

		if (aluno == null) {
			throw new ValidationException(MessagesUtil.ALUNO_NAO_ENCONTRADO);
		}

		aluno.remove();

		renderText(MessagesUtil.ALUNO_REMOVIDO_COM_SUCESSO);
	}

	public static void findByFilter(Integer idModalidade) {
//		String nome, 
//		if (nome == null || idModalidade == null) {
		if (idModalidade == null) {
			throw new ValidationException(MessagesUtil.ALUNO_NAO_ENCONTRADO);
		}

		List<Aluno> alunos = Aluno.find("id_modalidade_bolsa", idModalidade).fetch(); // setParameter("id_modalidade_bolsa", idModalidade).

		if (alunos == null) {
			throw new ValidationException(MessagesUtil.ALUNOS_NAO_ENCONTRADOS);
		}

		renderJSON(alunos, ProfessorSerializer.alunosDocente);
	}
}
