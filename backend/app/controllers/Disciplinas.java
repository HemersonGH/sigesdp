package controllers;

import java.util.List;

import javax.validation.ValidationException;

import models.Aluno;
import models.Disciplina;
import serializers.DisciplinaSerializer;
import utils.MessagesUtil;

public class Disciplinas extends DefaultController {

	public static void cadastraDisciplina(Disciplina disciplina) {
		disciplina.salvar();

		renderText(MessagesUtil.DISCIPLINA_CADASTRADA_COM_SUCESSO);
	}

	public static void findAll() {
		List<Disciplina> disciplinas = Disciplina.findAll();

		if (disciplinas == null) {
			throw new ValidationException(MessagesUtil.DISCIPLINAS_NAO_ENCONTRADAS);
		}

		renderJSON(disciplinas, DisciplinaSerializer.disciplinas);
	}

	public static void findById(Integer id) {
		if (id == null) {
			throw new ValidationException(MessagesUtil.DISCIPLINA_NAO_ENCONTRADA);
		}

		Disciplina disciplina = Disciplina.findById(id);

		if (disciplina == null) {
			throw new ValidationException(MessagesUtil.ID_DISCIPLINA_NAO_ENCONTRADA);
		}

		renderJSON(disciplina, DisciplinaSerializer.disciplinas);
	}

	public static void fieldSelect() {
		List<Disciplina> disciplinas = Disciplina.findAll();

		if (disciplinas == null) {
			throw new ValidationException(MessagesUtil.DISCIPLINAS_NAO_ENCONTRADAS);
		}

		renderJSON(disciplinas, DisciplinaSerializer.disciplinasSelect);
	}

	public static void atualizaDisciplina(Disciplina disciplina) {
		notFoundIfNull(disciplina);

		Disciplina disciplinaSave = Aluno.findById(disciplina.getId());

		if (disciplinaSave == null) {
			throw new ValidationException(MessagesUtil.DISCIPLINA_NAO_ENCONTRADA);
		}

		disciplinaSave.atualiza(disciplina);

		renderText(MessagesUtil.DISCIPLINA_ATUALIZADA_COM_SUCESSO);
	}

	public static void removeDisciplina(Integer id) {
		Disciplina disciplina = Disciplina.findById(id);

		notFoundIfNull(disciplina);

		if (disciplina == null) {
			throw new ValidationException(MessagesUtil.DISCIPLINA_NAO_ENCONTRADA);
		}

		disciplina.remove();

		renderText(MessagesUtil.DISCIPLINA_REMOVIDA_COM_SUCESSO);
	}
}