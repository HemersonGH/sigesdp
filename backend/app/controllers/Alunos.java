package controllers;

import java.util.List;

import javax.validation.ValidationException;

import models.Aluno;
import serializers.AlunoSerializer;
import serializers.ProfessorSerializer;
import utils.MessagesUtil;

public class Alunos extends DefaultController {

	public static void cadastraAluno(Aluno aluno) {
//		validateParameters(aluno);
		aluno.salvar();
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

	public static void removeAluno(Integer id) {
		Aluno aluno = Aluno.findById(id);

		notFoundIfNull(aluno);

		if (aluno == null) {
			throw new ValidationException(MessagesUtil.ALUNO_NAO_ENCONTRADO);
		}

		aluno.remove();

		renderText(MessagesUtil.ALUNO_REMOVIDO_COM_SUCESSO);
	}
}
