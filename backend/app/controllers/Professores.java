package controllers;

import java.util.List;

import javax.validation.ValidationException;

import models.Professor;
import models.Usuario;
import serializers.ProfessorSerializer;
import utils.MessagesUtil;

public class Professores extends DefaultController {

	public static void cadastraProfessor(Professor professor) {
//		validateParameters(professor);
		professor.salvar();

		renderJSON(professor, ProfessorSerializer.docentesDetails);
	}

	public static void findAll() {
		List<Professor> professor = Professor.findAll();

		if (professor == null) {
			throw new ValidationException(MessagesUtil.PROFESSORES_NAO_ENCONTRADOS);
		}

		renderJSON(professor, ProfessorSerializer.docentes);
	}

	public static void findById(Integer id) {
		if (id == null) {
			throw new ValidationException(MessagesUtil.ID_PROFESSOR_NAO_ENCONTRADO);
		}

		Professor professor = Professor.findById(id);

		if (professor == null) {
			throw new ValidationException(MessagesUtil.PROFESSOR_NAO_ENCONTRADO);
		}

//		renderJSON(professor);
		renderJSON(professor, ProfessorSerializer.docentesDetails);
	}

	public static void atualizaDisciplina(Professor professor) {
		notFoundIfNull(professor);

		Professor professorSave = Professor.findById(professor.getId());

		if (professorSave == null) {
			throw new ValidationException(MessagesUtil.PROFESSOR_NAO_ENCONTRADO);
		}

		professorSave.atualiza(professor);

		renderText(MessagesUtil.DISCIPLINA_ATUALIZADA_COM_SUCESSO);
	}

	public static void removeDisciplina(Integer id) {
		Professor professor = Professor.findById(id);

		notFoundIfNull(professor);

		if (professor == null) {
			throw new ValidationException(MessagesUtil.PROFESSOR_NAO_ENCONTRADO);
		}

		professor.remove();

		renderText(MessagesUtil.PROFESSOR_REMOVIDO_COM_SUCESSO);
	}

	public static void findByEmail(String email) {
		if (email == null) {
			throw new ValidationException(MessagesUtil.ID_PROFESSOR_NAO_ENCONTRADO);
		}

		Usuario usuario = Usuario.find("email = :email").setParameter("email", email).first();

		Integer idUsuario = usuario.getId();

		Professor professor = Professor.find("usuario.id", idUsuario).first();

		if (professor == null) {
			throw new ValidationException(MessagesUtil.PROFESSOR_NAO_ENCONTRADO);
		}

		renderJSON(professor, ProfessorSerializer.login);
	}

	public static void findAlunos(Integer id) {
		if (id == null) {
			throw new ValidationException(MessagesUtil.ID_PROFESSOR_NAO_ENCONTRADO);
		}

		Professor professor = Professor.findById(id);

		if (professor == null) {
			throw new ValidationException(MessagesUtil.PROFESSOR_NAO_ENCONTRADO);
		}

		renderJSON(professor, ProfessorSerializer.alunosDocente);
	}

	public static void findDisciplinas(Integer id) {
		if (id == null) {
			throw new ValidationException(MessagesUtil.ID_PROFESSOR_NAO_ENCONTRADO);
		}

		Professor professor = Professor.findById(id);

		if (professor == null) {
			throw new ValidationException(MessagesUtil.PROFESSOR_NAO_ENCONTRADO);
		}

		renderJSON(professor, ProfessorSerializer.disciplinasDocente);
	}

	public static void findProjetosPesquisa(Integer id) {
		if (id == null) {
			throw new ValidationException(MessagesUtil.ID_PROFESSOR_NAO_ENCONTRADO);
		}

		Professor professor = Professor.findById(id);

		if (professor == null) {
			throw new ValidationException(MessagesUtil.PROFESSOR_NAO_ENCONTRADO);
		}

		renderJSON(professor, ProfessorSerializer.projetosPesquisaDocente);
	}
}
