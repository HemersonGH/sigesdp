package security;

import play.mvc.Http;
import play.mvc.Scope;

public interface IAuthService {

	IAuthUser authenticate(Http.Request request, Scope.Session session);

	IAuthUser getAuthenticatedUser(Scope.Session session);
}
