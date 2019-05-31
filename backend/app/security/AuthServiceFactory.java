package security;

import play.Play;

public class AuthServiceFactory {

	private static IAuthService service = null;

	public IAuthService getInstance() {
		if (service == null) {
			service = createService();
		}

		return service;
	}

	@SuppressWarnings("deprecation")
	private IAuthService createService() {
		try {
			String className = "security.auth.CookieAuth";
			return (IAuthService) Class.forName(className).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
