package exceptions;

import play.i18n.Messages;

// Exceção deve ser lançada quando um usuário não cadastrado tentar logar

public class LoginException extends RuntimeException {

	private String messageKey;
	private Object[] messageArgs;

	public LoginException() {
		this.userMessage("sessao.expirada");
	}

	public LoginException(String reason) {
		super(reason);
		this.userMessage("sessao.expirada");
	}

	public String getUserMessage() {
		return Messages.get(messageKey, messageArgs);
	}

	public LoginException userMessage(String messageKey, Object... messageArgs) {

		this.messageArgs = messageArgs;
		this.messageKey = messageKey;

		return this;

	}
}