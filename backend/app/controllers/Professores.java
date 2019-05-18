package controllers;

import java.util.List;

import javax.validation.ValidationException;

import models.Departamento;
import models.Professor;
import serializers.DepartamentoSerializer;
import serializers.ProfessorSerializer;
import utils.MessagesUtil;

public class Professores extends DefaultController {
	public static void cadastraProfessor(Professor professor) {
//		validateParameters(professor);
		professor.salvar();
	}

	public static void findAll() {
		List<Professor> professor = Professor.findAll();

		if (professor == null) {
			throw new ValidationException(MessagesUtil.PROFESSORES_NAO_ENCONTRADOS);
		}

		renderJSON(professor, ProfessorSerializer.listAll);
	}

	public static void findById(Integer id) {
		if (id == null) {
			throw new ValidationException(MessagesUtil.PROFESSORES_NAO_ENCONTRADOS);
		}

		Professor professor = Professor.findById(id);

		if (professor == null) {
			throw new ValidationException(MessagesUtil.ID_PROFESSOR_NAO_ENCONTRADO);
		}

		renderJSON(professor, ProfessorSerializer.listIten);
	}
}
