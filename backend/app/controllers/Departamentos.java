package controllers;

import models.Departamento;
import serializers.DepartamentoSerializer;

public class Departamentos extends DefaultController {
	public static void cadastraDepartamento(Departamento departamento) {
//		validateParameters(departamento);
//
//		Professor usuario = Professor.createByProfessor(professor);
//
//		renderJSON(departamento, DepartamentoSerializer.save);

//		System.out.println(request.current().params.get("body"));
		departamento.salvar(departamento);
	}
}