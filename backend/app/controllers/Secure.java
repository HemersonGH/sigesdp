package controllers;

import models.Usuario;
import play.Logger;
import play.Play;
import play.cache.Cache;
import play.mvc.Before;
import security.AuthServiceFactory;
import security.IAuthService;
import serializers.SecureSerializer;

public class Secure extends DefaultController {

	private static IAuthService authService = new AuthServiceFactory().getInstance();

	@Before(unless = { "isAuthenticated", "getAuthenticatedUser", "clearUserSession", "authenticate", "logout", "getToken" })
	public static void isAuthenticated() {
		Usuario usuarioLogado = (Usuario) authService.getAuthenticatedUser(session);

		if (usuarioLogado == null) {
			Logger.debug("Permissão negada! Sem usuario logado.");
			clearUserSession();
			unauthorized();
		}

		Cache.set(session.getId(), usuarioLogado, Play.configuration.getProperty("application.session.maxAge"));
	}

	public static void logout() {
		clearUserSession();
	}

	public static void getAuthenticatedUser() {
		Logger.debug("ID da Sessão: %s", new Object[] { session.getId() });
		renderJSON(Cache.get(session.getId(), Usuario.class), SecureSerializer.authenticate);
	}

	private static void clearUserSession() {
		Cache.delete(session.getId());
		session.clear();
	}

	public static void authenticate() throws Exception {
		Usuario usuario = (Usuario) authService.authenticate(request, session);

		if (usuario == null || usuario.getId() == null) {
			throw new Exception("Here");
//			throw new LoginException().userMessage("erro.login");
		}

		setUserSession(usuario);
		renderJSON(usuario, SecureSerializer.authenticate);
	}

	private static void setUserSession(Usuario usuario) {
		String sessionKey = session.getId();

		Logger.debug("ID da Sessão: %s", new Object[] { sessionKey });
		Cache.set(sessionKey, usuario, Play.configuration.getProperty("application.session.maxAge"));
	}
}
