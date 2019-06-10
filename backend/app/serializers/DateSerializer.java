package serializers;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import flexjson.transformer.DateTransformer;
import flexjson.transformer.Transformer;
import play.Play;

public class DateSerializer implements JsonSerializer<Date> {

	private static final String DATE_FORMAT = Play.configuration.getProperty("date.format");

	@Override
	public JsonElement serialize(Date date, Type arg1, JsonSerializationContext arg2) {
		SimpleDateFormat simpleDateFormatter = new SimpleDateFormat(DATE_FORMAT);

		return new JsonPrimitive(simpleDateFormatter.format(date));
	}

	public static Transformer getTransformer() {
		return new DateTransformer(DATE_FORMAT);
	}
}
