package controllers;

import java.util.List;

import javax.validation.ValidationException;

import models.AreaConhecimento;
import play.mvc.Controller;
import serializers.AreaConhecimentoSerializer;
import utils.MessagesUtil;

public class AreasConhecimento extends Controller {

	public static void cadastraAreaConhecimento(AreaConhecimento areaConhecimento) {
		areaConhecimento.salvar();
	}

	public static void findAll() {
		List<AreaConhecimento> areasConhecimento = AreaConhecimento.findAll();

		if (areasConhecimento == null) {
			throw new ValidationException(MessagesUtil.AREAS_CONHECIMENTO_NAO_ENCONTRADAS);
		}

		renderJSON(areasConhecimento);
	}

	public static void findById(Integer id) {
		if (id == null) {
			throw new ValidationException(MessagesUtil.AREA_CONHECIMENTO_NAO_ENCONTRADA);
		}

		AreaConhecimento areaConhecimento = AreaConhecimento.findById(id);

		if (areaConhecimento == null) {
			throw new ValidationException(MessagesUtil.ID_AREA_CONHECIMENTO_NAO_ENCONTRADA);
		}

		renderJSON(areaConhecimento);
	}
}
