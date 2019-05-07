package controllers;

import java.util.List;

import models.Departamento;

public class Departamentos extends DefaultController {
	public static void cadastraDepartamento(Departamento departamento) {
//		validateParameters(departamento);
		departamento.salvar();
	}

	public static void findAll() {
		List<Departamento> departamentos = Departamento.findAll();
//		List<Departamento> departamentos = Departamento.find("nome = :nome").setParameter("nome", "nome").fetch();
		renderJSON(departamentos);
	}
}