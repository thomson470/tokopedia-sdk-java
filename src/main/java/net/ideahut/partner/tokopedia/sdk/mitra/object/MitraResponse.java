package net.ideahut.partner.tokopedia.sdk.mitra.object;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;

import net.ideahut.partner.tokopedia.sdk.util.Mapper;

public class MitraResponse <T> {

	public String status;
	public String error;
	public T data;
	
	public static <T> MitraResponse<T> parse(Class<T> type, byte[] value) {
		MitraResponse<T> response = new MitraResponse<T>();
		JsonNode jnode = Mapper.readValue(JsonNode.class, value);
		if (jnode.has("status")) {
			response.status = jnode.get("status").asText();
		}
		if (jnode.has("data")) {
			response.data = Mapper.convert(type, jnode.get("data"));
		}
		return response;
	}
	
	public static <T> MitraResponse<T> parse(TypeReference<T> typeRef, byte[] value) {
		MitraResponse<T> response = new MitraResponse<T>();
		JsonNode jnode = Mapper.readValue(JsonNode.class, value);
		if (jnode.has("status")) {
			response.status = jnode.get("status").asText();
		}
		if (jnode.has("data")) {
			response.data = Mapper.convert(typeRef, jnode.get("data"));
		}
		return response;
	}
	
}
