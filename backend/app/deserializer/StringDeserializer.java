package deserializer;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class StringDeserializer implements JsonDeserializer<String>{

	@Override
	public String deserialize(JsonElement json, Type type, JsonDeserializationContext context)
			throws JsonParseException {

		String value = json.getAsJsonPrimitive().getAsString();

		if (value == null || value.isEmpty()) {
			return null;
		}

		return value;
	}

}
