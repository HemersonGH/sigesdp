package exceptions;

import java.util.List;

import play.data.validation.Error;

public class ValidationException extends ApplicationException {
	public List<Error> errors;

	public ValidationException() {
		super();
	}

	public ValidationException(List<Error> errors) {
		this.errors = errors;
		super.userMessage("validacao.erro", getErrorsMessage());
	}

	public ValidationException(String erro, String userMessage, Object... args) {
		super(erro);
		this.userMessage(userMessage, args);
	}

	private String getErrorsMessage() {
		if (this.errors == null || this.errors.isEmpty()) {
			return super.getMessage();
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < errors.size(); i++) {
			sb.append(errors.get(i).message()).append("\n");
		}

		return sb.toString();
	}
}
