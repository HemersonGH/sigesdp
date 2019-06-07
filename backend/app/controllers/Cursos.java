package controllers;

import java.util.List;

import javax.validation.ValidationException;

import models.Curso;
import serializers.CursoSerializer;
import utils.MessagesUtil;

public class Cursos extends DefaultController {

	public static void cadastraCurso(Curso curso) {
		curso.salvar();

		renderText(MessagesUtil.CURSO_CADASTRADO_COM_SUCESSO);
	}

	public static void findAll() {
		List<Curso> cursos = Curso.findAll();

		if (cursos == null) {
			throw new ValidationException(MessagesUtil.CURSOS_NAO_ENCONTRADOS);
		}

		renderJSON(cursos, CursoSerializer.cursos);
	}

	public static void findById(Integer id) {
		if (id == null) {
			throw new ValidationException(MessagesUtil.CURSO_NAO_ENCONTRADO);
		}

		Curso curso = Curso.findById(id);

		if (curso == null) {
			throw new ValidationException(MessagesUtil.ID_CURSO_NAO_ENCONTRADO);
		}

		renderJSON(curso, CursoSerializer.cursos);
	}

	public static void atualizaCurso(Curso curso) {
		notFoundIfNull(curso);

		Curso cursoSave = Curso.findById(curso.getId());

		if (cursoSave == null) {
			throw new ValidationException(MessagesUtil.CURSO_NAO_ENCONTRADO);
		}

		cursoSave.atualiza(curso);

		renderText(MessagesUtil.CURSO_ATUALIZADO_COM_SUCESSO);
	}

	public static void removeCurso(Integer id) {
		Curso curso = Curso.findById(id);

		notFoundIfNull(curso);

		if (curso == null) {
			throw new ValidationException(MessagesUtil.CURSO_NAO_ENCONTRADO);
		}

		curso.remove();

		renderText(MessagesUtil.CURSO_REMOVIDO_COM_SUCESSO);
	}
}
