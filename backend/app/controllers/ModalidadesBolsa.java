package controllers;

import java.util.List;

import javax.validation.ValidationException;

import models.AreaConhecimento;
import models.ModalidadeBolsa;
import play.mvc.Controller;
import utils.MessagesUtil;

public class ModalidadesBolsa extends Controller {
	
	public static void cadastraAreaConhecimento(ModalidadeBolsa modalidadeBolsa) {
		modalidadeBolsa.salvar();
	}

	public static void findAll() {
		List<ModalidadeBolsa> modalidadesBolsa = ModalidadeBolsa.findAll();

		if (modalidadesBolsa == null) {
			throw new ValidationException(MessagesUtil.MODALIDADE_BOLSA_NAO_ENCONTRADAS);
		}

		renderJSON(modalidadesBolsa);
	}

	public static void findById(Integer id) {
		if (id == null) {
			throw new ValidationException(MessagesUtil.MODALIDADE_BOLSA_NAO_ENCONTRADA);
		}

		ModalidadeBolsa modalidadeBolsa = ModalidadeBolsa.findById(id);

		if (modalidadeBolsa == null) {
			throw new ValidationException(MessagesUtil.ID_MODALIDADE_BOLSA_NAO_ENCONTRADA);
		}

		renderJSON(modalidadeBolsa);
	}
}
