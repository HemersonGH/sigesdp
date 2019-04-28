package controllers;

import models.Professor;
import serializers.ProfessorSerializer;

public class Professores extends DefaultController {

	public static void cadastraProfessor(Professor professor) {
//		validateParameters(professor);
//
//		Professor usuario = Professor.createByProfessor(professor);
//
//		renderJSON(usuario, ProfessorSerializer.create);

		System.out.println("\n" + "TEST");
		System.out.println(professor.getNome());

		professor.salvar(professor);
	}
}
