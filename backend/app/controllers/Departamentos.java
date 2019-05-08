package controllers;

import java.util.List;

import javax.validation.ValidationException;

import models.Departamento;
import serializers.DepartamentoSerializer;
import utils.MessagesUtil;

public class Departamentos extends DefaultController {
	public static void cadastraDepartamento(Departamento departamento) {
//		validateParameters(departamento);
		departamento.salvar();
	}

	public static void findAll() {
		List<Departamento> departamentos = Departamento.findAll();

		if (departamentos == null) {
			throw new ValidationException(MessagesUtil.DEPARTAMENTOS_NAO_ENCONTRADOS);
		}

//		List<Departamento> departamentos = Departamento.find("nome = :nome").setParameter("nome", "nome").fetch();
		renderJSON(departamentos, DepartamentoSerializer.listAllToTable);
	}

	public static void findById(Integer id) {
		if (id == null) {
			throw new ValidationException(MessagesUtil.DEPARTAMENTO_NAO_ENCONTRADO);
		}

		Departamento departamento = Departamento.findById(id);

		if (departamento == null) {
			throw new ValidationException(MessagesUtil.ID_DEPARTAMENTO_NAO_ENCONTRADO);
		}

		renderJSON(departamento, DepartamentoSerializer.getDetails);
	}
}