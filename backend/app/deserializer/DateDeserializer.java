package deserializer;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import play.Logger;
import play.Play;

public class DateDeserializer implements JsonDeserializer<Date> {
	private static final String DATE_FORMAT = Play.configuration.getProperty("date.format");

	@Override
	public Date deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
		String date = json.getAsJsonPrimitive().getAsString();

		return deserialize(date);
	}

	public Date deserialize(String date) {
		if (date.length() > 2 && date.matches("-?[0-9]+")) {
			return parseMsDate(date);
		}

		return parseDate(date);
	}

	public static Date parseMsDate(String dateText) {
		try {
			return new Date(Long.parseLong(dateText));
		} catch (NumberFormatException nfe) {
			Logger.error(nfe, "Erro ao desserializar data. String recebida: %s", dateText);
			return null;
		}
	}

	public static Date parseDate(String dateText) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);

			return formatter.parse(dateText);
		} catch (ParseException pe) {
			pe.printStackTrace();
			return null;
		}
	}
}
