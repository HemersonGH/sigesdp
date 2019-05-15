package controllers;

import models.Professor;
import serializers.ProfessorSerializer;

public class Professores extends DefaultController {

	public static void cadastraProfessor(Professor professor) {
//		validateParameters(professor);

		professor.salvar();
	}
}
