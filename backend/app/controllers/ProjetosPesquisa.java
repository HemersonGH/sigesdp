package controllers;

import java.util.List;

import javax.validation.ValidationException;

import models.ProjetoPesquisa;
import models.ProjetoPesquisa;
import serializers.ProjetoPesquisaSerializer;
import serializers.ProjetoPesquisaSerializer;
import serializers.ProjetoPesquisaSerializer;
import utils.MessagesUtil;

public class ProjetosPesquisa extends DefaultController {

	public static void cadastraProjetoPesquisa(ProjetoPesquisa projetoPesquisa) {
//		validateParameters(projetoPesquisa);
		projetoPesquisa.salvar();

		renderText(MessagesUtil.PROJETO_PESQUISA_CADASTRADO_COM_SUCESSO);
	}

	public static void findAll() {
		List<ProjetoPesquisa> projetosPesquisa = ProjetoPesquisa.findAll();

		if (projetosPesquisa == null) {
			throw new ValidationException(MessagesUtil.PROJETOS_PESQUISA_NAO_ENCONTRADOS);
		}

		renderJSON(projetosPesquisa, ProjetoPesquisaSerializer.projetosPesquisa);
	}

	public static void findById(Integer id) {
		if (id == null) {
			throw new ValidationException(MessagesUtil.PROJETO_PESQUISA_NAO_ENCONTRADO);
		}

		ProjetoPesquisa projetoPesquisa = ProjetoPesquisa.findById(id);

		if (projetoPesquisa == null) {
			throw new ValidationException(MessagesUtil.ID_PROJETO_PESQUISA_NAO_ENCONTRADO);
		}

		renderJSON(projetoPesquisa, ProjetoPesquisaSerializer.projetosPesquisa);
	}

	public static void atualizaProjetoPesquisa(ProjetoPesquisa projetoPesquisa) {
		notFoundIfNull(projetoPesquisa);

		ProjetoPesquisa projetoPesquisaSave = ProjetoPesquisa.findById(projetoPesquisa.getId());

		if (projetoPesquisaSave == null) {
			throw new ValidationException(MessagesUtil.PROJETO_PESQUISA_NAO_ENCONTRADO);
		}

		projetoPesquisaSave.atualiza(projetoPesquisa);

		renderText(MessagesUtil.PROJETO_PESQUISA_ATUALIZADO_COM_SUCESSO);
	}

	public static void removeProjetoPesquisa(Integer id) {
		ProjetoPesquisa projetoPesquisa = ProjetoPesquisa.findById(id);

		notFoundIfNull(projetoPesquisa);

		if (projetoPesquisa == null) {
			throw new ValidationException(MessagesUtil.PROJETO_PESQUISA_NAO_ENCONTRADO);
		}

		projetoPesquisa.remove();

		renderText(MessagesUtil.PROJETO_PESQUISA_REMOVIDO_COM_SUCESSO);
	}

	public static void findByFilter(Integer idProfessor) {
		if (idProfessor == null) {
			throw new ValidationException(MessagesUtil.PROJETO_PESQUISA_NAO_ENCONTRADO);
		}

		List<ProjetoPesquisa> projetosPesquisa = ProjetoPesquisa.find("id_professor", idProfessor).fetch();

		if (projetosPesquisa == null) {
			throw new ValidationException(MessagesUtil.PROJETOS_PESQUISA_NAO_ENCONTRADOS);
		}

		renderJSON(projetosPesquisa, ProjetoPesquisaSerializer.projetosPesquisa);
	}
}
