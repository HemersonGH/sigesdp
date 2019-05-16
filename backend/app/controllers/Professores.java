package controllers;

import models.Professor;
import serializers.ProfessorSerializer;

public class Professores extends DefaultController {

	public static void cadastraProfessor(Professor professor) {
//		validateParameters(professor);

		System.out.println("\n ---------------------------------------------------------------");
//		System.out.println("prof.getDepartamento() -> " + professor.getDepartamento());
//		System.out.println("prof.departamento -> " + professor.departamento);
//		System.out.println("prof.departamento.getSigla() -> " + professor.departamento.getSigla());
		System.out.println("\n ---------------------------------------------------------------");

		professor.salvar();
	}
}
