package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSerializer;

import flexjson.JSONSerializer;
import play.Logger;
import play.db.jpa.JPA;
import play.i18n.Messages;
import play.libs.Time;
import play.mvc.Catch;
import play.mvc.Controller;
import play.mvc.results.RenderJson;

public class DefaultController extends Controller {

	protected static Gson gson;

	static {

		GsonBuilder builder = new GsonBuilder().serializeSpecialFloatingPointValues();

		gson = builder.create();

	}

	/**
	 * Tratamento de exceção geral.
	 * 
	 * As exceções não tratadas que chegam à controller serão tratadas por este
	 * método.
	 * 
	 * É retornado o status 500 e o texto de mensagem.
	 * 
	 * @param exception
	 *            Excessão capturada.
	 */
	@Catch(value = Exception.class, priority = 3)
	protected static void returnIfExceptionRaised(Exception exception) {

		Logger.error(exception, exception.getMessage());

		JPA.setRollbackOnly();

		error(Messages.get("erro.padrao"));

	}

	/**
	 * Render a 200 OK application/json response.
	 * 
	 * @param o
	 *            The Java object to serialize
	 * 
	 */
	protected static void renderJSON(Object model) {
		throw new RenderJson(model);
	}

	/**
	 * Render a 200 OK application/json response.
	 * 
	 * @param o
	 *            The Java object to serialize
	 * @param adapters
	 *            A set of GSON serializers/deserializers/instance creator to use
	 * 
	 */
	protected static void renderJSON(Object o, JsonSerializer<?>... adapters) {
		throw new RenderJson(o, adapters);
	}

	/**
	 * Renderiza um JSON utilizando o serializador informado.
	 */
	protected static void renderJSON(Object model, JSONSerializer js) {

		String json = js.serialize(model);

		renderJSON(json);

	}

	protected static void setCache(String expiration) {

		Integer seconds = Time.parseDuration(expiration);

		response.setHeader("Cache-Control", "max-age=" + seconds);

	}
}
