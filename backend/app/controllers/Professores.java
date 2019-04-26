package controllers;

import models.Professor;

public class Professores extends DefaultController{
	
	public static void saveProfessor(Professor professor) {
		
		professor.salvar()
	}

}
