package controllers;

import java.util.List;

import javax.validation.ValidationException;

import models.Disciplina;
import serializers.DisciplinaSerializer;
import utils.MessagesUtil;

public class Disciplinas extends DefaultController {

	public static void cadastraDisciplina(Disciplina disciplina) {
		disciplina.salvar();
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
}