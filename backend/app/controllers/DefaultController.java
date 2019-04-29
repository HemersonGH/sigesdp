package controllers;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSerializer;

import exceptions.ApplicationException;
import exceptions.ValidationException;
import flexjson.JSONSerializer;
import play.Logger;
import play.db.jpa.JPA;
import play.i18n.Messages;
import play.libs.Time;
import play.mvc.Catch;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Http.Header;
import play.mvc.results.RenderJson;
import serializers.DateSerializer;

public class DefaultController extends Controller {

	protected static Gson gson;

	static {
		GsonBuilder builder = new GsonBuilder().registerTypeAdapter(Date.class, new DateSerializer())
				.serializeSpecialFloatingPointValues();

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
	 * @param exception Excessão capturada.
	 */
	@Catch(value = Exception.class, priority = 3)
	protected static void returnIfExceptionRaised(Exception exception) {
		Logger.error(exception, exception.getMessage());

		JPA.setRollbackOnly();

		error(Messages.get("erro.padrao"));
	}

	/**
	 * Tratamento de exceção do tipo ApplicationException.
	 * 
	 * A mensagem de erro para o usuário estará contida na exceção, caso contrário
	 * será utilizada uma mensagem padrão.
	 * 
	 * É retornado o status 501 e o texto de mensagem.
	 * 
	 * @param exception Excessão capturada.
	 */
	@Catch(value = ApplicationException.class, priority = 2)
	protected static void returnIfExceptionRaised(ApplicationException exception) {
		Logger.error(exception, exception.getMessage());

		JPA.setRollbackOnly();

		error(501, exception.getUserMessage());
	}

	/**
	 * Tratamento de exceção do tipo ValidationException.
	 * 
	 * A mensagem de erro para o usuário estará contida na exceção, caso contrário
	 * será utilizada uma mensagem padrão.
	 * 
	 * É retornado o status 400 e o texto de mensagem.
	 * 
	 * @param exception Excessão capturada.
	 */
	@Catch(value = ValidationException.class, priority = 1)
	protected static void returnIfExceptionRaised(ValidationException exception) {
		Logger.error(exception, exception.getMessage());

		JPA.setRollbackOnly();

		error(400, exception.getUserMessage());
	}

	/**
	 * Render a 200 OK application/json response.
	 * 
	 * @param o The Java object to serialize
	 * 
	 */
	protected static void renderJSON(Object model) {
		throw new RenderJson(model);
	}

	/**
	 * Render a 200 OK application/json response.
	 * 
	 * @param o        The Java object to serialize
	 * @param adapters A set of GSON serializers/deserializers/instance creator to
	 *                 use
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

	/**
	 * Captura parametros
	 */

	public static String getParamsAsString(String key) {
		String string = request.params.get(key);

		if (StringUtils.isEmpty(string)) {
			return null;
		}

		return string;
	}

	public static Integer getParamsAsInteger(String key) {
		String integer = request.params.get(key);

		if (!StringUtils.isNumeric(integer)) {
			return null;
		}

		return Integer.parseInt(integer);
	}

	protected static Boolean getParamAsBoolean(String key) {
		String value = request.params.get(key);

		if (StringUtils.isEmpty(value))
			return null;

		return BooleanUtils.toBooleanObject(value);
	}

	protected static List<Integer> getParamAsIntegerList(String key) {
		String[] keys = request.params.getAll(key);

		if (keys == null || keys.length == 0) {
			return null;
		}

		List<Integer> ints = new ArrayList<Integer>();

		for (int i = 0; i < keys.length; ++i) {

			ints.add(Integer.parseInt(keys[i]));
		}

		return ints;
	}

	protected static List<String> getParamAsStringList(String key) {
		String[] keys = request.params.getAll(key);

		if (keys == null || keys.length == 0)
			return null;

		return Arrays.asList(keys);
	}

	protected static void renderFile(String nomeFile, String pathFile) throws IOException {
		File file = new File(pathFile);

		file.createNewFile();

		if (file.exists() || file.getAbsoluteFile().exists()) {

			response.setHeader("Content-Disposition", "attachment; filename=" + nomeFile);
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.setHeader("Content-Type", "application/download");
			renderBinary(file);

		}
	}

	protected static void unauthorized(String realm) {
		error(Http.StatusCode.UNAUTHORIZED, realm);
	}

	protected static String getHashByWwwAuthenticate() {
		String hash = null;

		Header header = request.headers.get("www-authenticate");

		if (header != null) {
			hash = header.value();
		}

		if (hash == null) {
			unauthorized();
		}

		return hash;
	}
}
