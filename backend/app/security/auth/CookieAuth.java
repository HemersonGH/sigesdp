package security.auth;

import models.Usuario;
import play.Logger;
import play.cache.Cache;
import play.mvc.Http.Request;
import play.mvc.Scope.Session;
import security.IAuthService;
import security.IAuthUser;
import security.SHA256Generator;
import security.SHA512Generator;

public class CookieAuth implements IAuthService {

	@Override
	public IAuthUser authenticate(Request request, Session session) {
		if (request.user == null || request.password == null) {
			return null;
		}

		// Aplicando SALT
		String password = SHA256Generator.generateValue(request.password).toUpperCase();
		Usuario usuario = Usuario.find("email = :email AND senha = :senha").setParameter("email", request.user)
				.setParameter("senha", password).first();

		if (usuario == null || usuario.getId() == null) {
			// Tratamento simples para evitar ataques de força bruta
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				Logger.error("Falha ao fazer Thread dormir. Tratamento anti força bruta.");
			}

			return null;
		}

		return usuario;
	}

	@Override
	public IAuthUser getAuthenticatedUser(Session session) {
		return (IAuthUser) Cache.get(session.getId());
	}
}
