package controllers;

import models.Professor;
import serializers.ProfessorSerializer;

public class Professores extends DefaultController {

	public static void saveProfessor(Professor professor) {
//		validateParameters(professor);
//
//		Professor usuario = Professor.createByProfessor(professor);
//
//		renderJSON(usuario, ProfessorSerializer.create);
		
		professor.salvar(professor);
	}

}
