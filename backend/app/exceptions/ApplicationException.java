package exceptions;

import play.i18n.Messages;

public class ApplicationException extends RuntimeException {

	private String messageKey;
	private Object[] messageArgs;

	public ApplicationException() {

	}

	public ApplicationException(Throwable throwable) {
		super(throwable);
	}

	public ApplicationException(String error) {
		super(error);
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public String getUserMessage() {
		String userMessage = Messages.get(messageKey, messageArgs);

		if (userMessage == null || userMessage.isEmpty()) {
			userMessage = Messages.get("erro.padrao");
		}

		return userMessage;
	}

	public ApplicationException userMessage(String messageKey, Object... messageArgs) {
		this.messageArgs = messageArgs;
		this.messageKey = messageKey;

		return this;
	}
}